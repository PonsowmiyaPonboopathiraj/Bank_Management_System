package models;

import java.time.LocalDate;

public class Loan {
    private int loanId;
    private int customerId;
    private int loanTypeId;
    private double amount;
    private double interestRate;
    private LocalDate startDate;
    private LocalDate endDate;
    private String status;

    public Loan() {}

    public Loan(int loanId, int customerId, int loanTypeId, double amount, double interestRate, LocalDate startDate, LocalDate endDate, String status) {
        this.loanId = loanId;
        this.customerId = customerId;
        this.loanTypeId = loanTypeId;
        this.amount = amount;
        this.interestRate = interestRate;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
    }

    // Getters & Setters
    public int getLoanId() { return loanId; }
    public void setLoanId(int loanId) { this.loanId = loanId; }

    public int getCustomerId() { return customerId; }
    public void setCustomerId(int customerId) { this.customerId = customerId; }

    public int getLoanTypeId() { return loanTypeId; }
    public void setLoanTypeId(int loanTypeId) { this.loanTypeId = loanTypeId; }

    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }

    public double getInterestRate() { return interestRate; }
    public void setInterestRate(double interestRate) { this.interestRate = interestRate; }

    public LocalDate getStartDate() { return startDate; }
    public void setStartDate(LocalDate startDate) { this.startDate = startDate; }

    public LocalDate getEndDate() { return endDate; }
    public void setEndDate(LocalDate endDate) { this.endDate = endDate; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    @Override
    public String toString() {
        return "Loan [id=" + loanId + ", amount=" + amount + ", status=" + status + "]";
    }
}
