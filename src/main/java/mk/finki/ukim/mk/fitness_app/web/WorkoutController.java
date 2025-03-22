package mk.finki.ukim.mk.fitness_app.web;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import mk.finki.ukim.mk.fitness_app.model.Workout;
import mk.finki.ukim.mk.fitness_app.model.dtos.WorkoutDto;
import mk.finki.ukim.mk.fitness_app.service.WorkoutService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/workout")
@Tag(name = "Workouts", description = "Manage workouts")
public class WorkoutController {
    private final WorkoutService workoutService;

    public WorkoutController(WorkoutService workoutService) {
        this.workoutService = workoutService;
    }

    @GetMapping
    @Operation(summary = "Show all workouts")
    public List<Workout> getAllWorkouts() {
        return this.workoutService.show_all_workouts();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Show a workout by its id")
    public ResponseEntity<Workout> getWorkoutById(@PathVariable Long id) {
        return this.workoutService.find_by_id(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/add")
    @Operation(summary = "Add a new workout")
    public ResponseEntity<Workout> addNewWorkout(@RequestBody WorkoutDto workout) {
        return this.workoutService.add_custom_workout(workout)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/{id}/add_exercise")
    @Operation(summary = "Add a new exercise to an existing workout")
    public ResponseEntity<Workout> addNewExercise(@PathVariable Long id, Long exercise_id ) {
        return this.workoutService.add_exercise_to_workout(id,exercise_id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/edit/{id}")
    @Operation(summary = "Edit an existing workout")
    public ResponseEntity<Workout> editWorkout(@PathVariable Long id, @RequestBody WorkoutDto workout) {
        return this.workoutService.update_workout(id,workout)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Delete an existing workout")
    public ResponseEntity<Void> deleteWorkout(@PathVariable Long id) {
        if (workoutService.find_by_id(id).isPresent())
        {
            workoutService.delete_workout(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
