package enums;

public enum BranchQuery {

    LOADALL("""
        SELECT 
            branch_id AS id,
            branch_name,
            ifsc_code,
            branch_address,
            branch_contact
        FROM branch
    """),

    GETBYID("SELECT branch_id AS id, branch_name, ifsc_code, branch_address, branch_contact FROM branch WHERE branch_id = ?"),

    INSERT("INSERT INTO branch (branch_name, ifsc_code, branch_address, branch_contact) VALUES (?, ?, ?, ?)"),

    UPDATE("UPDATE branch SET branch_name = ?, ifsc_code = ?, branch_address = ?, branch_contact = ? WHERE branch_id = ?"),

    DELETE("DELETE FROM branch WHERE branch_id = ?");

    private final String query;

    BranchQuery(String query) {
        this.query = query;
    }

    public String getQuery() {
        return query;
    }
}
