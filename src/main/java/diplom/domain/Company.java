package diplom.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "COMPANY")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id_company;
    private String name_company;
    private String location_company;
    private String phone_company;
    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private List<User> users;

    public Company(String name_company, String location_company, String phone_company) {
        this.name_company = name_company;
        this.location_company = location_company;
        this.phone_company = phone_company;
    }

    public Company(int id_company, String name_company, String location_company, String phone_company) {
        this.id_company = id_company;
        this.name_company = name_company;
        this.location_company = location_company;
        this.phone_company = phone_company;
    }

    public Company() {
    }

    public int getId_company() {
        return id_company;
    }

    public void setId_company(int id_company) {
        this.id_company = id_company;
    }

    public String getName_company() {
        return name_company;
    }

    public void setName_company(String name_company) {
        this.name_company = name_company;
    }

    public String getLocation_company() {
        return location_company;
    }

    public void setLocation_company(String location_company) {
        this.location_company = location_company;
    }

    public String getPhone_company() {
        return phone_company;
    }

    public void setPhone_company(String phone_company) {
        this.phone_company = phone_company;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id_company=" + id_company +
                ", name_company='" + name_company + '\'' +
                ", location_company='" + location_company + '\'' +
                ", phone_company='" + phone_company + '\'' +
                '}';
    }
}
