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
@Table(name = "SOLUTION")
public class Solution {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int solutionId;

    private Date actDate = new Date();

    @OneToOne
    @JoinColumn(name = "act_id")
    @JsonIgnore
    private Act act;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    String description;

    @Enumerated(EnumType.STRING)
    @JsonIgnore
    private ActStatus actStatus;



//    solution
//    user2
//    date2
}
