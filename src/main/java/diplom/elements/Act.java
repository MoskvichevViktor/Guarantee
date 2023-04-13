package diplom.elements;

import com.fasterxml.jackson.annotation.JsonIgnore;
import diplom.constants.ActStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ACTS")
public class Act {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int actId;

    private Date actDate = new Date();

    @ManyToOne
    @JoinColumn(name = "detail_id")
    @JsonIgnore
    private Detail detail;

    @ManyToOne
    @JoinColumn(name = "client_id")
    @JsonIgnore
    private Client client;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    String description;

    @Enumerated(EnumType.STRING)
    @JsonIgnore
    private ActStatus actStatus;

}


