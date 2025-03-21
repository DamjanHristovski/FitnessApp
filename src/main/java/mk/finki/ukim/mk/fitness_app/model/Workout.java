package mk.finki.ukim.mk.fitness_app.model;

import jakarta.persistence.*;
import lombok.Data;
import mk.finki.ukim.mk.fitness_app.model.Enum.Workout_splits;

import java.util.List;

@Entity
@Data
public class Workout {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Workout_splits workout_split;

    @OneToMany
    private List<Exercise> exercises;

    private Integer working_days;

    public Workout(Workout_splits workout_split, List<Exercise> exercises, Integer working_days) {
        this.workout_split = workout_split;
        this.exercises = exercises;
        this.working_days = working_days;
    }

    public Workout() {

    }
}
