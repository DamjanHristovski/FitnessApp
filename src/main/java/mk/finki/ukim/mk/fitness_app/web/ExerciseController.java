package mk.finki.ukim.mk.fitness_app.web;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import mk.finki.ukim.mk.fitness_app.model.Exercise;
import mk.finki.ukim.mk.fitness_app.model.dtos.ExerciseDto;
import mk.finki.ukim.mk.fitness_app.repository.WorkoutRepository;
import mk.finki.ukim.mk.fitness_app.service.ExerciseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/exercises")
@Tag(name="Exercises", description = "Manage the exercises")
public class ExerciseController {
    private final ExerciseService exerciseService;

    public ExerciseController(ExerciseService exerciseService) {
        this.exerciseService = exerciseService;
    }

    @GetMapping
    @Operation(summary = "Show all the exercises")
    public List<Exercise> getAllExercises() {
        return this.exerciseService.show_all_exercises();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Find an exercise by its id")
    public ResponseEntity<Exercise> getExerciseById(@PathVariable Long id) {
        return this.exerciseService.find_by_id(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/add")
    @Operation(summary = "Add a new exercise")
    public ResponseEntity<Exercise> addExercise(@RequestBody ExerciseDto exercise) {
        return this.exerciseService.add_exercise(exercise)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/edit/{id}")
    @Operation(summary = "Edit an existing exercise")
    public ResponseEntity<Exercise> updateExercise(@PathVariable Long id, @RequestBody ExerciseDto exercise) {
        return this.exerciseService.update_exercise(id,exercise)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Delete an existing exercise")
    public ResponseEntity<Void> deleteExercise(@PathVariable Long id) {
        if (this.exerciseService.find_by_id(id).isPresent())
        {
            this.exerciseService.delete_exercise(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
