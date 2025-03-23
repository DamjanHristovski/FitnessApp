package mk.finki.ukim.mk.fitness_app.model.dtos;

import mk.finki.ukim.mk.fitness_app.model.Nutritive_values;

public class MealDto {
    private String name;
    private String meal_type;
    private Nutritive_values nutrtion;

    public MealDto(String name, String meal_type, Nutritive_values nutrtion) {
        this.name = name;
        this.meal_type = meal_type;
        this.nutrtion = nutrtion;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMeal_type() {
        return meal_type;
    }

    public void setMeal_type(String meal_type) {
        this.meal_type = meal_type;
    }

    public Nutritive_values getNutrtion() {
        return nutrtion;
    }

    public void setNutrtion(Nutritive_values nutrtion) {
        this.nutrtion = nutrtion;
    }
}
