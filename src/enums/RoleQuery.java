package enums;

public enum RoleQuery {

    LOADALL("SELECT role_id AS id, role_name, description FROM \"role\""),
    GETBYID("SELECT role_id AS id, role_name, description FROM \"role\" WHERE role_id = ?"),
    INSERT("INSERT INTO \"role\" (role_name, description) VALUES (?, ?)"),
    UPDATE("UPDATE \"role\" SET role_name = ?, description = ? WHERE role_id = ?"),
    DELETE("DELETE FROM \"role\" WHERE role_id = ?");

    private final String query;

    RoleQuery(String query) {
        this.query = query;
    }

    public String getQuery() {
        return this.query;
    }
}
