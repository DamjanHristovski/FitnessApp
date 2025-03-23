package mk.finki.ukim.mk.fitness_app.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import mk.finki.ukim.mk.fitness_app.model.Enum.User_Roles;

@Entity
@Getter
@Setter
public class Memeber {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;

    @Enumerated(EnumType.STRING)
    private User_Roles role;

    @ManyToOne
    private Workout workout_split;



    public Memeber(Long id, String username, String password, User_Roles role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public Memeber() {

    }
}
