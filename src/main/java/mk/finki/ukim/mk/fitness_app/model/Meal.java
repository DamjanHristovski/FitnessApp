package mk.finki.ukim.mk.fitness_app.model;

import jakarta.persistence.*;
import mk.finki.ukim.mk.fitness_app.model.Enum.Meal_types;

@Entity
public class Meal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private Meal_types type;

    private Nutritive_values nutrition;
}
