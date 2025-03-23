package mk.finki.ukim.mk.fitness_app.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Embeddable
public class Rating {

    private Float stars;

    private String comment;


    public Rating(Float stars, String comment) {
        this.stars = stars;
        this.comment = comment;

    }

    public Rating()
    {

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
