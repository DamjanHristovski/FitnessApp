package mk.finki.ukim.mk.fitness_app.service.impl;

import mk.finki.ukim.mk.fitness_app.model.Fitness_plan;
import mk.finki.ukim.mk.fitness_app.model.dtos.Fitness_planDto;
import mk.finki.ukim.mk.fitness_app.model.dtos.WorkoutDto;
import mk.finki.ukim.mk.fitness_app.repository.Fitness_planRepository;
import mk.finki.ukim.mk.fitness_app.service.Fitness_planService;
import mk.finki.ukim.mk.fitness_app.service.MealService;
import mk.finki.ukim.mk.fitness_app.service.WorkoutService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Fitness_PlanImpl implements Fitness_planService {
    private final Fitness_planRepository fitness_planRepository;
    private final MealService mealService;
    private final WorkoutService workoutService;

    public Fitness_PlanImpl(Fitness_planRepository fitness_planRepository, MealService mealService, WorkoutService workoutService) {
        this.fitness_planRepository = fitness_planRepository;
        this.mealService = mealService;
        this.workoutService = workoutService;
    }

    @Override
    public Optional<Fitness_plan> find_fintess_plan_by_id(Long id) {
        return this.fitness_planRepository.findById(id);
    }

    @Override
    public List<Fitness_plan> show_all_plans() {
        return this.fitness_planRepository.findAll();
    }

    @Override
    public void create_plan(String name) {
        this.fitness_planRepository.save(new Fitness_plan(name));
    }

    @Override
    public Optional<Fitness_plan> add_new_workout(Long id, Long workout_id) {
       return this.fitness_planRepository.findById(id)
               .map(
                       existing_plan ->{
                           if (this.workoutService.find_by_id(workout_id).isPresent()){
                               existing_plan.getWorkouts().add(this.workoutService.find_by_id(workout_id).get());
                           }
                           return this.fitness_planRepository.save(existing_plan);
                       }
               );
    }

    @Override
    public Optional<Fitness_plan> add_new_meal(Long id, Long meal_id) {
        return this.fitness_planRepository.findById(id)
                .map(
                        existing_plan -> {
                            if (this.mealService.find_meal_by_id(id).isPresent())
                            {
                                existing_plan.getMeals().add(this.mealService.find_meal_by_id(id).get());
                            }
                            return this.fitness_planRepository.save(existing_plan);
                        }
                );
    }


    @Override
    public void delete_plan(Long id) {
        this.fitness_planRepository.deleteById(id);
    }
}
