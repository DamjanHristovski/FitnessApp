package mk.finki.ukim.mk.fitness_app.model.dtos;


import java.util.List;

public class Fitness_planDto {

    private String name;
    private List<WorkoutDto> workouts;
    private List<MealDto> meals;

    public Fitness_planDto(String name, List<WorkoutDto> workouts, List<MealDto> meals) {
        this.name = name;
        this.workouts = workouts;
        this.meals = meals;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<WorkoutDto> getWorkouts() {
        return workouts;
    }

    public void setWorkouts(List<WorkoutDto> workouts) {
        this.workouts = workouts;
    }

    public List<MealDto> getMeals() {
        return meals;
    }

    public void setMeals(List<MealDto> meals) {
        this.meals = meals;
    }
}
