package mk.finki.ukim.mk.fitness_app.service.impl;

import lombok.SneakyThrows;
import mk.finki.ukim.mk.fitness_app.model.Enum.Workout_splits;
import mk.finki.ukim.mk.fitness_app.model.Exceptions.ExerciseNotFoundException;
import mk.finki.ukim.mk.fitness_app.model.Exceptions.WorkoutNotFoundException;
import mk.finki.ukim.mk.fitness_app.model.Exercise;
import mk.finki.ukim.mk.fitness_app.model.Workout;
import mk.finki.ukim.mk.fitness_app.model.dtos.WorkoutDto;
import mk.finki.ukim.mk.fitness_app.repository.ExerciseRepository;
import mk.finki.ukim.mk.fitness_app.repository.WorkoutRepository;
import mk.finki.ukim.mk.fitness_app.service.WorkoutService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class WorkoutServiceImpl implements WorkoutService {

    private final WorkoutRepository workoutRepository;
    private final ExerciseRepository exerciseRepository;


    public WorkoutServiceImpl(WorkoutRepository workoutRepository, ExerciseRepository exerciseRepository) {
        this.workoutRepository = workoutRepository;
        this.exerciseRepository = exerciseRepository;
    }

    @Override
    public List<Workout> show_all_workouts() {
        return this.workoutRepository.findAll();
    }

    @Override
    public Optional<Workout> add_custom_workout(WorkoutDto workout) {
        ModelMapper modelmapper = new ModelMapper();
        if (!workout.getExercises().isEmpty() && workout.getWorkout_days() != null && workout.getWorkout_split() != null)
        {
            List<Exercise> exercises = workout.getExercises().stream()
                    .map(dto -> modelmapper.map(dto, Exercise.class))
                    .toList();
            return Optional.of(this.workoutRepository.save(new Workout(Workout_splits.valueOf(workout.getWorkout_split()), exercises, workout.getWorkout_days())));
        }
        return Optional.empty();
    }

    @Override
    public Optional<Workout> find_by_id(Long workoutId) {
        return this.workoutRepository.findById(workoutId);
    }

    @Override
    public Optional<Workout> update_workout(Long workoutId,WorkoutDto workout) {
        ModelMapper modelMapper = new ModelMapper();
        return this.workoutRepository.findById(workoutId)
                .map(
                        existing_workout ->{
                            if (!workout.getExercises().isEmpty() && workout.getWorkout_days() != null && workout.getWorkout_split() != null)
                            {
                                List<Exercise> new_exercises = workout.getExercises().stream()
                                                .map(dto -> modelMapper.map(dto, Exercise.class))
                                                .toList();
                                existing_workout.setExercises(new_exercises);
                                existing_workout.setWorkout_split(Workout_splits.valueOf(workout.getWorkout_split()));
                                existing_workout.setWorking_days(workout.getWorkout_days());
                            }
                            return this.workoutRepository.save(existing_workout);

                        }
                );
    }

    @SneakyThrows
    @Override
    public Optional<Workout> add_exercise_to_workout(Long workoutId, Long exerciseId){
        Workout workout = this.workoutRepository.findById(workoutId).orElseThrow(WorkoutNotFoundException::new);
        Exercise exercise = this.exerciseRepository.findById(exerciseId).orElseThrow(ExerciseNotFoundException::new);
        workout.getExercises().add(exercise);
        return Optional.of(this.workoutRepository.save(workout));
    }

    @Override
    public void delete_workout(Long workoutId) {
        this.workoutRepository.deleteById(workoutId);
    }


}
