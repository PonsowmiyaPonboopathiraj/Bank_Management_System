package enums;

public enum AccountQuery {
    INSERT("""
        INSERT INTO account (customer_id, account_type_id, balance, opened_date, status)
        VALUES (?, ?, ?, ?, ?)
    """),

    UPDATE("""
        UPDATE account
        SET account_type_id = ?, balance = ?, status = ?
        WHERE account_id = ?
    """),

    DELETE("""
        DELETE FROM account WHERE account_id = ?
    """),

    GET_BY_ID("""
        SELECT * FROM account WHERE account_id = ?
    """),

    GET_BY_CUSTOMER_ID("""
        SELECT * FROM account WHERE customer_id = ?
    """),

    LOADALL("""
        SELECT * FROM account
    """),

    GET_ACTIVE_ACCOUNTS("""
        SELECT * FROM account WHERE status = 'active'
    """),

    UPDATE_BALANCE("""
        UPDATE account
        SET balance = ?
        WHERE account_id = ?
    """),

    CLOSE_ACCOUNT("""
        UPDATE account
        SET status = 'closed'
        WHERE account_id = ?
    """),

    ACCOUNT_SUMMARY("""
        SELECT a.account_id, c.full_name, at.type_name, a.balance, a.status
        FROM account a
        JOIN customer c ON a.customer_id = c.customer_id
        JOIN account_type at ON a.account_type_id = at.account_type_id
    """);

    private final String query;

    AccountQuery(String query) {
        this.query = query;
    }

    public String getQuery() {
        return query;
    }
}
