package repository.Implementation;
import java.sql.Connection;
import java.time.LocalDate;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import DBConfig.DBConnection;
import enums.CustomerQuery;

import exceptions.NotFoundException;
import models.Branch;
import models.Customer;
import models.Role;
import models.User;
import repository.RepoInterface;
import java.sql.Date;

import exceptions.NotFoundException;
import models.Branch;
import models.Customer;
import models.User;
public class CustomerRepo implements RepoInterface<Customer> {

    private static CustomerRepo instance;
    private final Map<Integer, Customer> customers = new ConcurrentHashMap<>();
    private final Set<Integer> unUpdateCustomerIds = new ConcurrentHashMap().newKeySet();

    private CustomerRepo() {}

    public static CustomerRepo getInstance() {
        if (instance == null) {
            instance = new CustomerRepo();
        }
        return instance;
    }
@Override
    public void loadAll() {
        try (Connection conn = DBConnection.getInstance().getConnection();
             PreparedStatement ps = conn.prepareStatement(CustomerQuery.LOADALL.getQuery());
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                User user = UserRepo.getInstance().getById(rs.getInt("user_id"));
                Branch branch = BranchRepo.getInstance().getById(rs.getInt("branch_id"));

                Customer c = new Customer();
                c.setCustomerId(rs.getInt("customer_id"));
                c.setUser(user);
                c.setFullName(rs.getString("full_name"));
                c.setPhone(rs.getString("phone"));
                c.setAadhaarNumber(rs.getString("aadhaar_number"));
                c.setPanNumber(rs.getString("pan_number"));
                c.setAddress(rs.getString("address"));
                c.setDateOfBirth(rs.getDate("date_of_birth").toLocalDate());
                c.setBranch(branch);
                c.setStatus(rs.getString("status"));

                customers.put(c.getCustomerId(), c);
            }

        } catch (SQLException e) {
            System.out.println("Error loading customers: " + e.getMessage());
        }
    }

    @Override
    public List<Customer> getAll() {
        return new ArrayList<>(customers.values());
    }

    @Override
    public Customer getById(int id) {
        Customer c = customers.get(id);
        if (c == null) throw new NotFoundException("Customer not found");
        return c;
    }

    @Override
    public void add(Customer c) {
        int id = customers.size() + 1;
        c.setCustomerId(id);
        addOrUpdate(c);
    }

    @Override
    public void update(Customer c) {
        addOrUpdate(c);
    }

    private void addOrUpdate(Customer c) {
        customers.put(c.getCustomerId(), c);
        unUpdateCustomerIds.add(c.getCustomerId());
    }

    @Override
    public void deleteById(int id) {
        customers.remove(id);
        unUpdateCustomerIds.add(id);
    }

    public void syncChanges() {
        for (int id : unUpdateCustomerIds) {
            Customer c = getById(id);
            try (Connection conn = DBConnection.getInstance().getConnection();
                 PreparedStatement ps = conn.prepareStatement(CustomerQuery.INSERT.getQuery())) {

                ps.setInt(1, c.getUser().getId());
                ps.setString(2, c.getFullName());
                ps.setString(3, c.getPhone());
                ps.setString(4, c.getAadhaarNumber());
                ps.setString(5, c.getPanNumber());
                ps.setString(6, c.getAddress());
                ps.setDate(7, Date.valueOf(c.getDateOfBirth()));
                ps.setInt(8, c.getBranch().getBranchId());
                ps.setString(9, c.getStatus());
                ps.executeUpdate();

            } catch (SQLException e) {
                System.out.println("Error syncing customer: " + e.getMessage());
            }
        }
    }
}

    

