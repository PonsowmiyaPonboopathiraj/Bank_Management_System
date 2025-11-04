package models;

import java.time.LocalDate;

public class Customer {
    private int customerId;
    private User user;
    private String fullName;
    private String phone;
    private String aadhaarNumber;
    private String panNumber;
    private String address;
    private LocalDate dateOfBirth;
    private Branch branch;
    private String status;
    
    public Customer(){

    }

    public Customer(int customerId, User user, String fullName, String phone, String aadhaarNumber, String panNumber,
            String address, LocalDate dateOfBirth, Branch branch, String status) {
        this.customerId = customerId;
        this.user = user;
        this.fullName = fullName;
        this.phone = phone;
        this.aadhaarNumber = aadhaarNumber;
        this.panNumber = panNumber;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.branch = branch;
        this.status = status;
    }
public int getCustomerId() {
        return customerId;
    }
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getAadhaarNumber() {
        return aadhaarNumber;
    }
    public void setAadhaarNumber(String aadhaarNumber) {
        this.aadhaarNumber = aadhaarNumber;
    }
    public String getPanNumber() {
        return panNumber;
    }
    public void setPanNumber(String panNumber) {
        this.panNumber = panNumber;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }
    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    public Branch getBranch() {
        return branch;
    }
    public void setBranch(Branch branch) {
        this.branch = branch;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

}
