package models;

public class User {
    private int id;
    private String email;
    private String password;
    private Role role;
    private boolean isActive;

    public User() {}

    public User(int id, String email, String password, Role role, boolean isActive) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.role = role;
        this.isActive = isActive;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public Role getRole() { return role; }
    public void setRole(Role role) { this.role = role; }

    public boolean isActive() { return isActive; }
    public void setActive(boolean isActive) { this.isActive = isActive; }

    @Override
    public String toString() {
        return "User [id=" + id + ", email=" + email + ", role=" + role.getRoleName() + ", isActive=" + isActive + "]";
    }
}
