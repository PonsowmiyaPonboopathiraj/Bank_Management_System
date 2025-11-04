package models;

import java.time.LocalDateTime;

public class Account {
    private int accountId;
    private int customerId;
    private int accountTypeId;
    private double balance;
    private LocalDateTime createdAt;
    private boolean isActive;

    public Account() {}

    public Account(int accountId, int customerId, int accountTypeId, double balance, LocalDateTime createdAt, boolean isActive) {
        this.accountId = accountId;
        this.customerId = customerId;
        this.accountTypeId = accountTypeId;
        this.balance = balance;
        this.createdAt = createdAt;
        this.isActive = isActive;
    }

   
    public int getAccountId() { return accountId; }
    public void setAccountId(int accountId) { this.accountId = accountId; }

    public int getCustomerId() { return customerId; }
    public void setCustomerId(int customerId) { this.customerId = customerId; }

    public int getAccountTypeId() { return accountTypeId; }
    public void setAccountTypeId(int accountTypeId) { this.accountTypeId = accountTypeId; }

    public double getBalance() { return balance; }
    public void setBalance(double balance) { this.balance = balance; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public boolean isActive() { return isActive; }
    public void setActive(boolean isActive) { this.isActive = isActive; }

    @Override
    public String toString() {
        return "Account [id=" + accountId + ", balance=" + balance + "]";
    }
}
