package mk.finki.ukim.mk.fitness_app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import mk.finki.ukim.mk.fitness_app.model.Enum.Muscle_group;

@Entity
@Data
public class Exercise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Muscle_group muscle;

    private String description;

    public Exercise(String name, Muscle_group muscle, String description) {
        this.name = name;
        this.muscle = muscle;
        this.description = description;
    }

    public Exercise() {

    }
}
