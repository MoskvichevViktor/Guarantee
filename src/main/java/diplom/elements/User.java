package diplom.elements;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import diplom.constants.UserRole;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "USERS")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    private String userName;
    private String userEmail;
    private String password;

    @Enumerated(EnumType.STRING)
    @JsonIgnore
    private UserRole role;

    // много сотрудников - одна компания
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "company_id")
    @JsonIgnore
    private Company company;


}

