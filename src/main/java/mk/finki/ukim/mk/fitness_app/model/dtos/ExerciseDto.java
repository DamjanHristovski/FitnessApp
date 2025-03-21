package mk.finki.ukim.mk.fitness_app.model.dtos;

import lombok.Data;

@Data
public class ExerciseDto {

    private String name;

    private String muscle;

    private String description;

    public ExerciseDto(String name, String muscle, String description) {
        this.name = name;
        this.muscle = muscle;
        this.description = description;
    }
}
