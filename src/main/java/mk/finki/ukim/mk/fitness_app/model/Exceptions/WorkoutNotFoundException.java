package mk.finki.ukim.mk.fitness_app.model.Exceptions;

public class WorkoutNotFoundException extends RuntimeException{
    public WorkoutNotFoundException() {
        super("Workout not found");
    }
}
