
package models;

public class Branch {
    private int branchId;
    private String branchName;
    private String ifscCode;
    private String branchAddress;
    private String branchContact;
    private User managerUser;

   
    public int getBranchId() { return branchId; }
    public void setBranchId(int branchId) { this.branchId = branchId; }

    public String getBranchName() { return branchName; }
    public void setBranchName(String branchName) { this.branchName = branchName; }

    public String getIfscCode() { return ifscCode; }
    public void setIfscCode(String ifscCode) { this.ifscCode = ifscCode; }

    public String getBranchAddress() { return branchAddress; }
    public void setBranchAddress(String branchAddress) { this.branchAddress = branchAddress; }

    public String getBranchContact() { return branchContact; }
    public void setBranchContact(String branchContact) { this.branchContact = branchContact; }

    public User getManagerUser() { return managerUser; }
    public void setManagerUser(User managerUser) { this.managerUser = managerUser; }
}
