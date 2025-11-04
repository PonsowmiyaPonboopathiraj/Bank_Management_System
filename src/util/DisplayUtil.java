package util;

import java.util.List;
import models.Role;
import models.User;
import models.Customer;
import models.Employee;

public class DisplayUtil {

    // ---------------- ROLE TABLE DISPLAY ----------------
    public static void showRoles(List<Role> roles) {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("%-8s | %-20s | %-30s%n", "Role ID", "Role Name", "Description"));
        sb.append("--------------------------------------------------------------------------\n");

        for (Role role : roles) {
            sb.append(String.format("%-8d | %-20s | %-30s%n",
                    role.getRoleId(),
                    role.getRoleName(),
                    role.getDescription() == null ? "N/A" : role.getDescription()));
        }

        System.out.println("\n-------ROLE LIST--------");
        System.out.println(sb);
    }

    // ---------------- USER TABLE DISPLAY ----------------
    public static void showUsers(List<User> users) {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("%-8s | %-25s | %-15s | %-10s%n", "User ID", "Email", "Role", "Status"));
        sb.append("--------------------------------------------------------------------------\n");

        for (User user : users) {
            sb.append(String.format("%-8d | %-25s | %-15s | %-10s%n",
                    user.getId(),
                    user.getEmail(),
                    user.getRole() != null ? user.getRole().getRoleName() : "No Role",
                    user.isActive() ? "Active" : "Inactive"));
        }

        System.out.println("\n===== USER LIST =====");
        System.out.println(sb);
    }

    // ---------------- CUSTOMER TABLE DISPLAY ----------------
    public static void showCustomers(List<Customer> customers) {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("%-8s | %-20s | %-12s | %-15s | %-10s | %-15s | %-10s%n",
                "Cust ID", "Full Name", "Phone", "Aadhaar", "PAN", "Branch", "Status"));
        sb.append("---------------------------------------------------------------------------------------------------------------\n");

        for (Customer c : customers) {
            sb.append(String.format("%-8d | %-20s | %-12s | %-15s | %-10s | %-15s | %-10s%n",
                    c.getCustomerId(),
                    c.getFullName(),
                    c.getPhone(),
                    c.getAadhaarNumber(),
                    c.getPanNumber(),
                    c.getBranch() != null ? c.getBranch().getBranchName() : "N/A",
                    c.getStatus()));
        }

        System.out.println("\n===== CUSTOMER LIST =====");
        System.out.println(sb);
    }

    // ---------------- EMPLOYEE TABLE DISPLAY ----------------
    public static void showEmployees(List<Employee> employees) {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("%-10s | %-20s | %-12s | %-15s | %-12s | %-10s%n",
                "Emp ID", "Full Name", "Phone", "Branch", "Date Joined", "Status"));
        sb.append("-------------------------------------------------------------------------------------------------\n");

        for (Employee e : employees) {
            sb.append(String.format("%-10d | %-20s | %-12s | %-15s | %-12s | %-10s%n",
                    e.getEmployeeId(),
                    e.getFullName(),
                    e.getPhone(),
                    e.getBranch() != null ? e.getBranch().getBranchName() : "N/A",
                    e.getDateJoined() != null ? e.getDateJoined().toString() : "N/A",
                    e.getStatus()));
        }

        System.out.println("\n===== EMPLOYEE LIST =====");
        System.out.println(sb);
    }

    // ---------------- GENERAL MESSAGES ----------------
    public static void wrongChoice() {
        System.out.println("\n Wrong choice... Please try again!");
    }

    public static void goBack() {
        System.out.println("\n Returning to previous menu...");
    }

    public static void showDivider() {
        System.out.println("-------------------------------------------------------------------------------------------------");
    }
}
