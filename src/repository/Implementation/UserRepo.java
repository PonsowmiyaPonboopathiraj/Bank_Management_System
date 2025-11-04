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
import enums.UserQuery;
import exceptions.NotFoundException;


import models.Role;
import models.User;
import repository.RepoInterface;

public class UserRepo implements RepoInterface<User> {

    private static UserRepo instance;

    private UserRepo() {
    }

    public static UserRepo getInstance() {

        if (instance == null) {
            instance = new UserRepo();
        }

        return instance;
    }

    private final Map<Integer, User> users = new ConcurrentHashMap<>();
    private final Set<Integer> unUpdateUserIds = new ConcurrentHashMap().newKeySet();

    @Override
    public void loadAll() {

        try (PreparedStatement ps = DBConnection.getInstance().getConnection()
                .prepareStatement(UserQuery.LOADALL.getQuery())) {

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Role role = RoleRepo.getInstance().getById(rs.getInt("role_id"));

                try {

                    User user = UserFactory.generateUser(role.getRoleName());
                    user.setId(rs.getInt("id"));
                    user.setEmail(rs.getString("email"));
                    user.setPassword(rs.getString("password"));
                    user.setRole(role);
                    user.setActive(rs.getBoolean("isactive"));

                    users.put(user.getId(), user);

                } catch (NotFoundException e) {
                    System.out.println(e.getMessage());
                }

            }

        } catch (SQLException e) {
            System.out.println("Something Went Wrong...");
        }

    }

    @Override
    public List<User> getAll() {

        return new ArrayList<>(users.values());
    }

    @Override
    public void update(User user) {

        this.addOrupdate(user);
    }

    @Override
    public void add(User user) {

        int id = users.size() + 1;
        user.setId(id);
        this.addOrupdate(user);
    }

    private void addOrupdate(User user) {

        users.put(user.getId(), user);
        unUpdateUserIds.add(user.getId());
    }

    @Override
    public void deleteById(int id) {

        users.remove(id);
        unUpdateUserIds.add(id);

    }

    @Override
    public User getById(int id){

        User user = users.get(id);
        
        if(user == null){
            throw new NotFoundException("The User Not Found (Invalid User Id...)");
        }

        return users.get(id);
    }

    public void syncChanges() {

        if (unUpdateUserIds.isEmpty()) {
            return;
        }

        for (int id : unUpdateUserIds) {

            User user = getById(id);

            if (user != null) {

                try (PreparedStatement ps = DBConnection.getInstance().getConnection()
                        .prepareStatement(UserQuery.INSERT.getQuery())) {

                    ps.setInt(1, user.getId());
                    ps.setString(2, user.getEmail());
                    ps.setString(3, user.getPassword());
                    ps.setInt(4, user.getRole().getRoleId());
                    ps.setBoolean(5, user.isActive());

                    ps.executeUpdate();

                } catch (SQLException e) {
                    System.out.println("Something Went Wrong..." + e.getMessage());
                }
            }
        }
    }

}
