package models;

public class AccountType {
     private int accountTypeId;
    private String typeName;
    private double interestRate;
    private double minBalance;
    private String description;
 public AccountType(int accountTypeId, String typeName, double interestRate, double minBalance, String description) {
        this.accountTypeId = accountTypeId;
        this.typeName = typeName;
        this.interestRate = interestRate;
        this.minBalance = minBalance;
        this.description = description;
    }
    public AccountType() {
    }

    
    public int getAccountTypeId() {
        return accountTypeId;
    }
    public void setAccountTypeId(int accountTypeId) {
        this.accountTypeId = accountTypeId;
    }
    public String getTypeName() {
        return typeName;
    }
    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
    public double getInterestRate() {
        return interestRate;
    }
    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }
    public double getMinBalance() {
        return minBalance;
    }
    public void setMinBalance(double minBalance) {
        this.minBalance = minBalance;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
   
}