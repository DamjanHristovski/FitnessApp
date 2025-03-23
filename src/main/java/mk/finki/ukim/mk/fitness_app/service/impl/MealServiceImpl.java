package mk.finki.ukim.mk.fitness_app.service.impl;

import mk.finki.ukim.mk.fitness_app.model.Enum.Meal_types;
import mk.finki.ukim.mk.fitness_app.model.Exceptions.MealNotFoundException;
import mk.finki.ukim.mk.fitness_app.model.Meal;
import mk.finki.ukim.mk.fitness_app.model.Nutritive_values;
import mk.finki.ukim.mk.fitness_app.model.dtos.MealDto;
import mk.finki.ukim.mk.fitness_app.repository.MealRepository;
import mk.finki.ukim.mk.fitness_app.service.MealService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MealServiceImpl implements MealService {

    private final MealRepository mealRepository;

    public MealServiceImpl(MealRepository mealRepository) {
        this.mealRepository = mealRepository;
    }

    @Override
    public Optional<Meal> find_meal_by_id(Long id) {
        return Optional.ofNullable(this.mealRepository.findById(id).orElseThrow(MealNotFoundException::new));
    }

    @Override
    public List<Meal> show_all_meals() {
        return this.mealRepository.findAll();
    }

    @Override
    public Optional<Meal> add_new_meal(MealDto meal) {
        if (meal.getName() != null && meal.getMeal_type() != null && meal.getNutrtion() != null)
        {
            return Optional.of(this.mealRepository.save(new Meal(meal.getName(), Meal_types.valueOf(meal.getMeal_type()),meal.getNutrtion())));
        }
        return Optional.empty();
    }

    @Override
    public Optional<Meal> update_meal(Long id, MealDto meal) {
        return this.mealRepository.findById(id)
                .map(
                        existing_meal -> {
                            if (meal.getName() != null && meal.getMeal_type() != null && meal.getNutrtion() != null)
                            {
                                existing_meal.setName(meal.getName());
                                existing_meal.setType(Meal_types.valueOf(meal.getMeal_type()));
                                existing_meal.setNutrition(meal.getNutrtion());
                            }
                            return this.mealRepository.save(existing_meal);
                        }
                );
    }

    @Override
    public Optional<Meal> update_nutrition(Long id, Nutritive_values nutrition) {
        return this.mealRepository.findById(id)
                .map(
                        existing_meal ->{
                            if (nutrition != null)
                            {
                                existing_meal.setNutrition(nutrition);
                            }
                            return this.mealRepository.save(existing_meal);
                        }
                );
    }

    @Override
    public void delete_meal(Long id) {
        this.mealRepository.deleteById(id);
    }
}
