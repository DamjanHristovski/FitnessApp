package mk.finki.ukim.mk.fitness_app.web;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import mk.finki.ukim.mk.fitness_app.model.Fitness_plan;
import mk.finki.ukim.mk.fitness_app.service.Fitness_planService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/plan")
@Tag(name = "Fitness Plan", description = "Manage fitness plans")
public class Fitness_Plan_Controller {
    private final Fitness_planService fitnessPlanService;

    public Fitness_Plan_Controller(Fitness_planService fitnessPlanService) {
        this.fitnessPlanService = fitnessPlanService;
    }

    @GetMapping
    @Operation(summary = "Show all fitness plans")
    public List<Fitness_plan> getAll() {
        return this.fitnessPlanService.show_all_plans();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Show a plan by its id")
    public ResponseEntity<Fitness_plan> getById(@PathVariable Long id) {
        return this.fitnessPlanService.find_fintess_plan_by_id(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/add")
    @Operation(summary = "Create an empty plan")
    public ResponseEntity<Void> createPlan(@RequestParam String name)
    {
        if (name != null && !name.isEmpty())
        {
            this.fitnessPlanService.create_plan(name);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/{id}/meals")
    @Operation(summary = "Add a new meal")
    public ResponseEntity<Fitness_plan> addMeal(@PathVariable Long id, @RequestParam Long meal_id)
    {
        return this.fitnessPlanService.add_new_meal(id,meal_id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/{id}/workouts")
    @Operation(summary = "Add a new workout")
    public ResponseEntity<Fitness_plan> addWorkout(@PathVariable Long id, @RequestParam Long workout_id)
    {
        return this.fitnessPlanService.add_new_workout(id,workout_id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Delete a plan by its id")
    public ResponseEntity<Void> deletePlan(@PathVariable Long id)
    {
        if (this.fitnessPlanService.find_fintess_plan_by_id(id).isPresent())
        {
            this.fitnessPlanService.delete_plan(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();

    }


}
