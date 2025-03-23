package mk.finki.ukim.mk.fitness_app.web;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import mk.finki.ukim.mk.fitness_app.model.Meal;
import mk.finki.ukim.mk.fitness_app.model.Nutritive_values;
import mk.finki.ukim.mk.fitness_app.model.dtos.MealDto;
import mk.finki.ukim.mk.fitness_app.service.MealService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/meals")
@Tag(name = "Meals",description = "Manage meals")
public class MealController {
    private final MealService mealService;

    public MealController(MealService mealService) {
        this.mealService = mealService;
    }

    @GetMapping
    @Operation(summary = "Show all available meals")
    public List<Meal> getMeals() {
        return this.mealService.show_all_meals();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Show a certain meal by its id")
    public ResponseEntity<Meal> getMeal(@PathVariable Long id) {
        return this.mealService.find_meal_by_id(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/add")
    @Operation(summary = "Add a new meal")
    public ResponseEntity<Meal> addMeal(@RequestBody MealDto meal) {
        return this.mealService.add_new_meal(meal)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/edit/{id}")
    @Operation(summary = "Edit a meal")
    public ResponseEntity<Meal> editMeal(@PathVariable Long id, @RequestBody MealDto meal) {
        return this.mealService.update_meal(id,meal)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/edit/{id}/nutrition")
    @Operation(summary = "Edit a nutrition for a certain meal")
    public ResponseEntity<Meal> editNutrition(@PathVariable Long id, @RequestBody Nutritive_values nutrition) {
        return this.mealService.update_nutrition(id,nutrition)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Delete a meal from its id")
    public ResponseEntity<Void> deleteMeal(@PathVariable Long id) {
        if (this.mealService.find_meal_by_id(id).isPresent())
        {
            this.mealService.delete_meal(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
