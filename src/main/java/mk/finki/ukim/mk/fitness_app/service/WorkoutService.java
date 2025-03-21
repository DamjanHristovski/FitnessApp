package mk.finki.ukim.mk.fitness_app.service;

import mk.finki.ukim.mk.fitness_app.model.Workout;
import mk.finki.ukim.mk.fitness_app.model.dtos.WorkoutDto;

import java.util.List;
import java.util.Optional;

public interface WorkoutService {

    Optional<Workout> add_custom_workout(WorkoutDto workout);
    Optional<Workout> find_by_id(Long workoutId);
    Optional<Workout> update_workout(Long workoutId,WorkoutDto workout);
    void delete_workout(Long workoutId);
    List<Workout> show_all_workouts();
    Optional<Workout> add_exercise_to_workout(Long workoutId,Long exerciseId);
}
