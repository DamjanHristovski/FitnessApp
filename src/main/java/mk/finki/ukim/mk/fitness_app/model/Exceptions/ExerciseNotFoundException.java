package mk.finki.ukim.mk.fitness_app.model.Exceptions;

public class ExerciseNotFoundException extends RuntimeException{
    public ExerciseNotFoundException() {
        super("Exercise not found");
    }
}
