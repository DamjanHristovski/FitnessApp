package mk.finki.ukim.mk.fitness_app.service;

import mk.finki.ukim.mk.fitness_app.model.Meal;
import mk.finki.ukim.mk.fitness_app.model.Nutritive_values;
import mk.finki.ukim.mk.fitness_app.model.dtos.MealDto;

import java.util.List;
import java.util.Optional;

public interface MealService {

    Optional<Meal> find_meal_by_id(Long id);
    List<Meal> show_all_meals();
    Optional<Meal> add_new_meal(MealDto meal);
    Optional<Meal> update_meal(Long id,MealDto meal);
    Optional<Meal> update_nutrition(Long id, Nutritive_values nutrition);
    void delete_meal(Long id);


}
