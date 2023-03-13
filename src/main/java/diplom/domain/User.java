package diplom.domain;

import javax.persistence.*;

@Entity
@Table(name = "USERS")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private int id_user;
    @Column(name = "name_user")
    private String name_user;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name ="id_company")
    private Company company;

    public User(String name_user, Company company) {
        this.name_user = name_user;
        this.company = company;
    }

    public User(int id_user, String name_user, Company company) {
        this.id_user = id_user;
        this.name_user = name_user;
        this.company = company;
    }

    public User() {
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

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "User{" +
                "id_user=" + id_user +
                ", name_user='" + name_user + '\'' +
                ", company=" + company +
                '}';
    }
}
