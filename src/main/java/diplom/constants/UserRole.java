package diplom.constants;

public enum UserRole {
    ROLE_ADMIN("ROLE_ADMIN"),
    ROLE_MANAGER("ROLE_MANAGER");

    private final String role;

    UserRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return role;
    }
}
