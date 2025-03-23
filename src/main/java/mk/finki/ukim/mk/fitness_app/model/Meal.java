package mk.finki.ukim.mk.fitness_app.model;

import jakarta.persistence.*;
import mk.finki.ukim.mk.fitness_app.model.Enum.Meal_types;

@Entity
public class Meal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long meal_id;

    private String name;

    @Enumerated(EnumType.STRING)
    private Meal_types type;

    private Nutritive_values nutrition;

    public Meal(String name, Meal_types type, Nutritive_values nutrition) {
        this.name = name;
        this.type = type;
        this.nutrition = nutrition;
    }

    public Meal() {
    }

    public Long getMeal_id() {
        return meal_id;
    }

    public void setMeal_id(Long meal_id) {
        this.meal_id = meal_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Meal_types getType() {
        return type;
    }

    public void setType(Meal_types type) {
        this.type = type;
    }

    public Nutritive_values getNutrition() {
        return nutrition;
    }

    public void setNutrition(Nutritive_values nutrition) {
        this.nutrition = nutrition;
    }
}
