package mk.finki.ukim.mk.fitness_app.model.dtos;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


public class RatingDto {

    private Float stars;

    private String comment;


    public RatingDto(Float stars, String comment) {
        this.stars = stars;
        this.comment = comment;
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
