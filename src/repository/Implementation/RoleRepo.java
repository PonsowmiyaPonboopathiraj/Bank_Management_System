package repository.Implementation;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;


import DBConfig.DBConnection;
import enums.RoleQuery;
import exceptions.NotFoundException;
import models.Role;
import repository.RepoInterface;

public class RoleRepo implements RepoInterface<Role> {

    private static RoleRepo instance;
    private final Map<Integer, Role> roles = new ConcurrentHashMap<>();
    private final Set<Integer> unUpdateRoleIds = new ConcurrentHashMap<>().newKeySet();

    private RoleRepo() {}

    public static RoleRepo getInstance() {
        if (instance == null) {
            instance = new RoleRepo();
        }
        return instance;
    }

    @Override
    public void loadAll() {
        try (Connection conn = DBConnection.getInstance().getConnection();
             PreparedStatement ps = conn.prepareStatement(RoleQuery.LOADALL.getQuery());
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Role role = new Role();
                role.setRoleId(rs.getInt("id"));
                role.setRoleName(rs.getString("role_name"));
                role.setDescription(rs.getString("description"));
                roles.put(role.getRoleId(), role);
            }

        } catch (SQLException e) {
            System.out.println("Error loading roles: " + e.getMessage());
        }
    }

    @Override
    public List<Role> getAll() {
        return new ArrayList<>(roles.values());
    }

    @Override
    public Role getById(int id) {
        Role role = roles.get(id);
        if (role == null) {
            throw new NotFoundException("Role not found for ID: " + id);
        }
        return role;
    }

    @Override
    public void add(Role role) {
        int id = roles.size() + 1;
        role.setRoleId(id);
        roles.put(id, role);
        unUpdateRoleIds.add(id);
    }

    @Override
    public void update(Role role) {
        roles.put(role.getRoleId(), role);
        unUpdateRoleIds.add(role.getRoleId());
    }

    @Override
    public void deleteById(int id) {
        roles.remove(id);
        unUpdateRoleIds.add(id);
    }

    public void syncChanges() {
        for (int id : unUpdateRoleIds) {
            Role role = roles.get(id);
            if (role != null) {
                try (PreparedStatement ps = DBConnection.getInstance().getConnection()
                        .prepareStatement(RoleQuery.INSERT.getQuery())) {

                    ps.setString(1, role.getRoleName());
                    ps.setString(2, role.getDescription());
                    ps.executeUpdate();

                } catch (SQLException e) {
                    System.out.println("Error syncing role: " + e.getMessage());
                }
            }
        }
    }
}
