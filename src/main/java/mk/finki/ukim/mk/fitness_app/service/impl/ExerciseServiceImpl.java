package mk.finki.ukim.mk.fitness_app.service.impl;

import mk.finki.ukim.mk.fitness_app.model.Enum.Muscle_group;
import mk.finki.ukim.mk.fitness_app.model.Exercise;
import mk.finki.ukim.mk.fitness_app.model.Rating;
import mk.finki.ukim.mk.fitness_app.model.dtos.ExerciseDto;
import mk.finki.ukim.mk.fitness_app.repository.ExerciseRepository;
import mk.finki.ukim.mk.fitness_app.service.ExerciseService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExerciseServiceImpl implements ExerciseService {

    private final ExerciseRepository exerciseRepository;

    public ExerciseServiceImpl(ExerciseRepository exerciseRepository) {
        this.exerciseRepository = exerciseRepository;
    }
    @Override
    public List<Exercise> show_all_exercises() {
        return this.exerciseRepository.findAll();
    }

    @Override
    public List<Rating> show_ratings_for_exercise(Long id) {
        if (this.exerciseRepository.findById(id).isPresent())
        {
            return this.exerciseRepository.findById(id).get().getRating();
        }
        return null;
    }

    @Override
    public Optional<Exercise> add_rating(Long id, Rating rating) {
        if (this.exerciseRepository.findById(id).isPresent())
        {
            Exercise exercise = this.exerciseRepository.findById(id).get();
            exercise.getRating().add(new Rating(rating.getStars(),rating.getComment()));
            return Optional.of(this.exerciseRepository.save(exercise));
        }
        return Optional.empty();
    }

    @Override
    public Optional<Exercise> find_by_id(Long id) {
        return exerciseRepository.findById(id);
    }

    @Override
    public Optional<Exercise> add_exercise(ExerciseDto exercise) {
        if (exercise.getName() != null && exercise.getMuscle() != null && exercise.getDescription() != null)
        {
            return Optional.of(this.exerciseRepository.save(new Exercise(exercise.getName(), Muscle_group.valueOf(exercise.getMuscle()), exercise.getDescription())));
        }
        return Optional.empty();
    }

    @Override
    public Optional<Exercise> update_exercise(Long id,ExerciseDto exercise) {
        return this.exerciseRepository.findById(id).map(
                existing_exercise ->{
                    if (exercise.getName() != null && exercise.getMuscle() != null && exercise.getDescription() != null)
                    {
                        existing_exercise.setName(exercise.getName());
                        existing_exercise.setDescription(exercise.getDescription());
                        existing_exercise.setMuscle(existing_exercise.getMuscle());
                    }
                    return this.exerciseRepository.save(existing_exercise);
                }
        );
    }

    @Override
    public void delete_exercise(Long id) {
        this.exerciseRepository.deleteById(id);
    }


}
