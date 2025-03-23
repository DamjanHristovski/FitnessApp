package mk.finki.ukim.mk.fitness_app.model.Exceptions;

public class MealNotFoundException extends RuntimeException{
    public MealNotFoundException() {
        super("Exercise not found");
    }
}
