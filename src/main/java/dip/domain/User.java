package dip.domain;

public class User {

    private int id_user;
    private String name_user;

    public User() {
    }

    public User(int id_user, String name_user) {
        this.id_user = id_user;
        this.name_user = name_user;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getName_user() {
        return name_user;
    }

    public void setName_user(String name_user) {
        this.name_user = name_user;
    }
}
