package mk.finki.ukim.mk.fitness_app.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Fitness_plan {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;


    private String name;

    @ManyToMany
    List<Meal> meals;

    @ManyToMany
    List<Workout> workouts;

    public Fitness_plan(String name) {
        this.name = name;
        this.meals = new ArrayList<Meal>();
        this.workouts = new ArrayList<Workout>();
    }

    public Fitness_plan() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Meal> getMeals() {
        return meals;
    }

    public void setMeals(List<Meal> meals) {
        this.meals = meals;
    }

    public List<Workout> getWorkouts() {
        return workouts;
    }

    public void setWorkouts(List<Workout> workouts) {
        this.workouts = workouts;
    }
}
