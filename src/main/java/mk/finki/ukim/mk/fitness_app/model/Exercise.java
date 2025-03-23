package mk.finki.ukim.mk.fitness_app.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import mk.finki.ukim.mk.fitness_app.model.Enum.Muscle_group;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Exercise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long exercise_id;

    private String name;

    @Enumerated(EnumType.STRING)
    private Muscle_group muscle;

    private String description;

    @ElementCollection
    private List<Rating> rating;

    @ManyToOne
    @JoinColumn(name = "workout_id")
    private Workout workout;


    public Exercise(String name, Muscle_group muscle, String description) {
        this.name = name;
        this.muscle = muscle;
        this.description = description;
        this.rating = new ArrayList<>();
    }

    public Exercise() {

    }

    public Long getExercise_id() {
        return exercise_id;
    }

    public void setExercise_id(Long exercise_id) {
        this.exercise_id = exercise_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Muscle_group getMuscle() {
        return muscle;
    }

    public void setMuscle(Muscle_group muscle) {
        this.muscle = muscle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Rating> getRating() {
        return rating;
    }

    public void setRating(List<Rating> rating) {
        this.rating = rating;
    }
}
