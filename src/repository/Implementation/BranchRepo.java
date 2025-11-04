package repository.Implementation;

import java.sql.*;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

import DBConfig.DBConnection;
import enums.BranchQuery;
import exceptions.NotFoundException;
import models.Branch;
import repository.RepoInterface;

public class BranchRepo implements RepoInterface<Branch> {

    private static BranchRepo instance;
    private final Map<Integer, Branch> branches = new ConcurrentHashMap<>();
    private final Set<Integer> unUpdateBranchIds = new ConcurrentHashMap<>().newKeySet();

    private BranchRepo() {}

    public static BranchRepo getInstance() {
        if (instance == null) {
            instance = new BranchRepo();
        }
        return instance;
    }

    @Override
    public void loadAll() {
        try (Connection conn = DBConnection.getInstance().getConnection();
             PreparedStatement ps = conn.prepareStatement(BranchQuery.LOADALL.getQuery());
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Branch b = new Branch();
                b.setBranchId(rs.getInt("id"));
                b.setBranchName(rs.getString("branch_name"));
                b.setIfscCode(rs.getString("ifsc_code"));
                b.setBranchAddress(rs.getString("branch_address"));
                b.setBranchContact(rs.getString("branch_contact"));
                branches.put(b.getBranchId(), b);
            }

        } catch (SQLException e) {
            System.out.println("Error loading branches: " + e.getMessage());
        }
    }

    @Override
    public List<Branch> getAll() {
        return new ArrayList<>(branches.values());
    }

    @Override
    public Branch getById(int id) {
        Branch b = branches.get(id);
        if (b == null) throw new NotFoundException("Branch not found for ID: " + id);
        return b;
    }

    @Override
    public void add(Branch b) {
        int id = branches.size() + 1;
        b.setBranchId(id);
        addOrUpdate(b);
    }

    @Override
    public void update(Branch b) {
        addOrUpdate(b);
    }

    private void addOrUpdate(Branch b) {
        branches.put(b.getBranchId(), b);
        unUpdateBranchIds.add(b.getBranchId());
    }

    @Override
    public void deleteById(int id) {
        branches.remove(id);
        unUpdateBranchIds.add(id);
    }

    public void syncChanges() {
        for (int id : unUpdateBranchIds) {
            Branch b = getById(id);
            try (Connection conn = DBConnection.getInstance().getConnection();
                 PreparedStatement ps = conn.prepareStatement(BranchQuery.INSERT.getQuery())) {

                ps.setString(1, b.getBranchName());
                ps.setString(2, b.getIfscCode());
                ps.setString(3, b.getBranchAddress());
                ps.setString(4, b.getBranchContact());
                ps.executeUpdate();

            } catch (SQLException e) {
                System.out.println("Error syncing branch: " + e.getMessage());
            }
        }
    }
}
