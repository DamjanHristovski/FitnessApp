package mk.finki.ukim.mk.fitness_app.model.dtos;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class WorkoutDto {

    private String workout_split;

    private List<ExerciseDto> exercises;

    private Integer workout_days;

    public WorkoutDto(String workout_split, List<ExerciseDto> exercises, Integer workout_days) {
        this.workout_split = workout_split;
        this.exercises = exercises;
        this.workout_days = workout_days;
    }

    public String getWorkout_split() {
        return workout_split;
    }

    public void setWorkout_split(String workout_split) {
        this.workout_split = workout_split;
    }

    public List<ExerciseDto> getExercises() {
        return exercises;
    }

    public void setExercises(List<ExerciseDto> exercises) {
        this.exercises = exercises;
    }

    public Integer getWorkout_days() {
        return workout_days;
    }

    public void setWorkout_days(Integer workout_days) {
        this.workout_days = workout_days;
    }
}
