package mk.finki.ukim.mk.fitness_app.model.dtos;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class ExerciseDto {

    private String name;

    private String muscle;

    private String description;


    public ExerciseDto(String name, String muscle, String description) {
        this.name = name;
        this.muscle = muscle;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMuscle() {
        return muscle;
    }

    public void setMuscle(String muscle) {
        this.muscle = muscle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
