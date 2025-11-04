package Menus;

public class Menus {

    // ---------------- ENTRY MENU ----------------
    public static void entryMenu() {
        System.out.println();
        System.out.println("---------- Welcome To Bank Management System ----------");
        System.out.println("1. Login");
        System.out.println("2. Exit");
        System.out.println();
    }

    // ---------------- ADMIN DASHBOARD ----------------
    public static void adminMenu() {
        System.out.println();
        System.out.println("-------------- Admin Dashboard -----------------");
        System.out.println("1. Manage Roles");
        System.out.println("2. Manage Users (Managers, Employees)");
        System.out.println("3. Manage Loan Types");
        System.out.println("4. Manage Branches");
        System.out.println("5. View All Customers");
        System.out.println("6. View All Employees");
        System.out.println("7. View All Transactions");
        System.out.println("8. Pending Loan Approvals");
        System.out.println("9. Generate System Report");
        System.out.println("10. Logout");
        System.out.println();
    }

    // ---------------- MANAGER DASHBOARD ----------------
    public static void managerMenu() {
        System.out.println();
        System.out.println("-------------- Manager Dashboard -----------------");
        System.out.println("1. Manage Employees");
        System.out.println("2. Manage Customers");
        System.out.println("3. Manage Accounts");
        System.out.println("4. Approve Loans (Customer Requests)");
        System.out.println("5. View Branch Transactions");
        System.out.println("6. Pending Approvals (Account / Loan)");
        System.out.println("7. Generate Branch Report");
        System.out.println("8. Logout");
        System.out.println();
    }

    // ---------------- EMPLOYEE DASHBOARD ----------------
    public static void employeeMenu() {
        System.out.println();
        System.out.println("-------------- Employee Dashboard -----------------");
        System.out.println("1. Register New Customer");
        System.out.println("2. Create New Account");
        System.out.println("3. Deposit Money");
        System.out.println("4. Withdraw Money");
        System.out.println("5. Transfer Funds");
        System.out.println("6. View Customer Details");
        System.out.println("7. View Account Details");
        System.out.println("8. Submit Loan Request (on behalf of Customer)");
        System.out.println("9. Logout");
        System.out.println();
    }

    // ---------------- CUSTOMER DASHBOARD ----------------
    public static void customerMenu() {
        System.out.println();
        System.out.println("-------------- Customer Dashboard -----------------");
        System.out.println("1. View My Accounts");
        System.out.println("2. Deposit Money (ATM/Online)");
        System.out.println("3. Withdraw Money (ATM/Branch)");
        System.out.println("4. Transfer Funds");
        System.out.println("5. Apply for Loan");
        System.out.println("6. View My Loan Status");
        System.out.println("7. View My Transactions");
        System.out.println("8. Update My Profile");
        System.out.println("9. Logout");
        System.out.println();
    }

    // ---------------- COMMON CRUD MENU TEMPLATE ----------------
    public static void manageMenus(String menu) {
        System.out.println();
        System.out.println("-------------- " + menu + " Management -----------------");
        System.out.println("1. Add New " + menu);
        System.out.println("2. Update " + menu);
        System.out.println("3. View All " + menu);
        System.out.println("4. View " + menu + " By ID");
        System.out.println("5. Delete " + menu);
        System.out.println("6. Back");
        System.out.println();
    }

    // ---------------- VIEW DETAILS MENU ----------------
    public static void viewDetailsMenu(String entity) {
        System.out.println();
        System.out.println("-------------- View " + entity + " Details -----------------");
        System.out.println("1. View " + entity + " by ID");
        System.out.println("2. View All " + entity + " Records");
        System.out.println("3. Search " + entity + " by Name");
        System.out.println("4. Back");
        System.out.println();
    }

    // ---------------- APPROVAL MENU ----------------
    public static void approvalMenu(String entity) {
        System.out.println();
        System.out.println("-------------- " + entity + " Approvals -----------------");
        System.out.println("1. View Pending " + entity + " Approvals");
        System.out.println("2. Approve " + entity);
        System.out.println("3. Reject " + entity);
        System.out.println("4. Back");
        System.out.println();
    }

    // ---------------- REPORT MENU ----------------
    public static void reportMenu() {
        System.out.println();
        System.out.println("-------------- Reports -----------------");
        System.out.println("1. Daily Transaction Summary");
        System.out.println("2. Customer Growth Report");
        System.out.println("3. Loan Performance Report");
        System.out.println("4. Account Balance Summary");
        System.out.println("5. Back");
        System.out.println();
    }
}
