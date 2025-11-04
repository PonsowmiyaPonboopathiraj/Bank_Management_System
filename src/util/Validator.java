
package util;
import java.util.regex.Pattern;

public class Validator {

    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
    private static final Pattern PHONE_PATTERN = Pattern.compile("^[6-9]\\d{9}$");
    private static final Pattern NAME_PATTERN = Pattern.compile("^[A-Za-z ]{3,50}$");
    private static final Pattern IFSC_PATTERN = Pattern.compile("^[A-Z]{4}0[A-Z0-9]{6}$");
    private static final Pattern ACCOUNT_NUMBER_PATTERN = Pattern.compile("^[0-9]{10,18}$");


    public static boolean isValidName(String name) {
        if (name == null || name.trim().isEmpty()) {
            System.out.println(" Name cannot be empty!");
            return false;
        }
        if (!NAME_PATTERN.matcher(name).matches()) {
            System.out.println(" Invalid name! Only alphabets and spaces allowed (3-50 chars).");
            return false;
        }
        return true;
    }

    public static boolean isValidEmail(String email) {
        if (email == null || email.trim().isEmpty()) {
            System.out.println(" Email cannot be empty!");
            return false;
        }
        if (!EMAIL_PATTERN.matcher(email).matches()) {
            System.out.println(" Invalid email format! Example: user@example.com");
            return false;
        }
        return true;
    }

    public static boolean isValidPhone(String phone) {
        if (phone == null || phone.trim().isEmpty()) {
            System.out.println(" Phone number cannot be empty!");
            return false;
        }
        if (!PHONE_PATTERN.matcher(phone).matches()) {
            System.out.println(" Invalid phone number! Must be 10 digits and start with 6-9.");
            return false;
        }
        return true;
    }

    public static boolean isValidIFSC(String ifsc) {
        if (ifsc == null || ifsc.trim().isEmpty()) {
            System.out.println(" IFSC Code cannot be empty!");
            return false;
        }
        if (!IFSC_PATTERN.matcher(ifsc).matches()) {
            System.out.println(" Invalid IFSC code format! Example: HDFC0001234");
            return false;
        }
        return true;
    }

    public static boolean isValidAccountNumber(String accNo) {
        if (accNo == null || accNo.trim().isEmpty()) {
            System.out.println(" Account number cannot be empty!");
            return false;
        }
        if (!ACCOUNT_NUMBER_PATTERN.matcher(accNo).matches()) {
            System.out.println(" Invalid account number! Must be 10–18 digits.");
            return false;
        }
        return true;
    }

    public static boolean isValidAmount(double amount) {
        if (amount <= 0) {
            System.out.println(" Amount must be greater than zero!");
            return false;
        }
        return true;
    }

    public static boolean isNotNullOrEmpty(String input, String fieldName) {
        if (input == null || input.trim().isEmpty()) {
            System.out.println(  fieldName + " cannot be empty!");
            return false;
        }
        return true;
    }

    public static boolean validateCustomerInput(String name, String email, String phone) {
        return isValidName(name) && isValidEmail(email) && isValidPhone(phone);
    }

    
    public static void handleInputMismatch(Exception e) {
        System.out.println(" Input Mismatch! Please enter the correct data type. Error: " + e.getMessage());
    }

    public static void handleIllegalArgument(Exception e) {
        System.out.println(" Illegal Argument! Please check your input values. Error: " + e.getMessage());
    }
}


