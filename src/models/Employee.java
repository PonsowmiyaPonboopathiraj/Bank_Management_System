package models;

import java.time.LocalDate;

public class Employee {
    private int employeeId;
    private User user;
    private String fullName;
    private String phone;
    private Branch branch;
    private LocalDate dateJoined;
    private String status;

    // Getters & Setters
    public int getEmployeeId() { return employeeId; }
    public void setEmployeeId(int employeeId) { this.employeeId = employeeId; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public Branch getBranch() { return branch; }
    public void setBranch(Branch branch) { this.branch = branch; }

    public LocalDate getDateJoined() { return dateJoined; }
    public void setDateJoined(LocalDate dateJoined) { this.dateJoined = dateJoined; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
