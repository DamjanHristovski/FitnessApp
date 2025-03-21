package mk.finki.ukim.mk.fitness_app.model.dtos;

import lombok.Data;
import java.util.List;

@Data
public class WorkoutDto {

    private String workout_split;

    private List<ExerciseDto> exercises;

    private Integer workout_days;

    public WorkoutDto(String workout_split, List<ExerciseDto> exercises, Integer workout_days) {
        this.workout_split = workout_split;
        this.exercises = exercises;
        this.workout_days = workout_days;
    }
}
