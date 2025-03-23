package mk.finki.ukim.mk.fitness_app.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rating_id;

    private Float stars;

    private String comment;

    @ManyToOne
    @JoinColumn(name = "exercise_id")
    @JsonBackReference
    private Exercise exercise;


    public Rating(Float stars, String comment, Exercise exercise) {
        this.stars = stars;
        this.comment = comment;
        this.exercise = exercise;
    }

    public Rating()
    {

    }

    public Long getRating_id() {
        return rating_id;
    }

    public void setRating_id(Long rating_id) {
        this.rating_id = rating_id;
    }

    public Exercise getExercise() {
        return exercise;
    }

    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
    }


    public Float getStars() {
        return stars;
    }

    public void setStars(Float stars) {
        this.stars = stars;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
