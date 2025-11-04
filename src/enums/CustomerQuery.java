package enums;

public enum CustomerQuery {

    LOADALL("""
        SELECT 
            customer_id AS id,
            user_id,
            full_name,
            phone,
            aadhaar_number,
            pan_number,
            address,
            date_of_birth,
            branch_id,
            status
        FROM customer
    """),

    GETBYID("""
        SELECT 
            customer_id AS id,
            user_id,
            full_name,
            phone,
            aadhaar_number,
            pan_number,
            address,
            date_of_birth,
            branch_id,
            status
        FROM customer
        WHERE customer_id = ?
    """),


    INSERT("""
        INSERT INTO customer 
        (user_id, full_name, phone, aadhaar_number, pan_number, address, date_of_birth, branch_id, status)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)
    """),

    UPDATE("""
        UPDATE customer SET 
            full_name = ?, 
            phone = ?, 
            aadhaar_number = ?, 
            pan_number = ?, 
            address = ?, 
            date_of_birth = ?, 
            branch_id = ?, 
            status = ?
        WHERE customer_id = ?
    """),

    DELETE("DELETE FROM customer WHERE customer_id = ?");

    private final String query;

    CustomerQuery(String query) {
        this.query = query;
    }

    public String getQuery() {
        return query;
    }
}
