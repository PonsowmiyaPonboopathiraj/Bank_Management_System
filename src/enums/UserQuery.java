package enums;

public enum UserQuery {

    LOADALL("SELECT user_id AS id, email, password, role_id, is_active AS isactive FROM \"user\""),
    INSERT("INSERT INTO \"user\" (user_id, email, password, role_id, is_active) VALUES (?, ?, ?, ?, ?)"),
    UPDATE("UPDATE \"user\" SET email = ?, password = ?, role_id = ?, is_active = ? WHERE user_id = ?"),
    DELETE("DELETE FROM \"user\" WHERE user_id = ?"),
    GETBYID("SELECT user_id AS id, email, password, role_id, is_active AS isactive FROM \"user\" WHERE user_id = ?");

    private final String query;

    UserQuery(String query) {
        this.query = query;
    }

    public String getQuery() {
        return this.query;
    }
}
