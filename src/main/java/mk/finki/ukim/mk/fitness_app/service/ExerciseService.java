package mk.finki.ukim.mk.fitness_app.service;

import mk.finki.ukim.mk.fitness_app.model.Exercise;
import mk.finki.ukim.mk.fitness_app.model.Rating;
import mk.finki.ukim.mk.fitness_app.model.dtos.ExerciseDto;
import mk.finki.ukim.mk.fitness_app.model.dtos.RatingDto;

import java.util.List;
import java.util.Optional;

public interface ExerciseService {

    Optional<Exercise> find_by_id (Long id);
    Optional<Exercise> add_exercise (ExerciseDto exercise);
    Optional<Exercise> update_exercise (Long id,ExerciseDto exercise);
    void delete_exercise(Long id);
    List<Exercise> show_all_exercises ();
    List<Rating> show_ratings_for_exercise(Long id);
    Optional<Exercise> add_rating(Long id, RatingDto rating);
}
