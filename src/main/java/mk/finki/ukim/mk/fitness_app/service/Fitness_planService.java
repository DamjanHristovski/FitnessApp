package mk.finki.ukim.mk.fitness_app.service;

import mk.finki.ukim.mk.fitness_app.model.Fitness_plan;
import mk.finki.ukim.mk.fitness_app.model.dtos.Fitness_planDto;
import mk.finki.ukim.mk.fitness_app.model.dtos.MealDto;
import mk.finki.ukim.mk.fitness_app.model.dtos.WorkoutDto;

import java.util.List;
import java.util.Optional;

public interface Fitness_planService {

    Optional<Fitness_plan> find_fintess_plan_by_id (Long id);
    List<Fitness_plan> show_all_plans ();
    void create_plan (String name);
    Optional<Fitness_plan> add_new_workout(Long id,Long workout_id);
    Optional<Fitness_plan> add_new_meal(Long id,Long meal_id);
    void delete_plan (Long id);

}
