package mk.finki.ukim.mk.fitness_app.model.dtos;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberDto {

    private String username;

    private String role;

    private String email;

    private Long workout_id;

    public MemberDto(String username, String role, String email, Long workout_id) {
        this.username = username;
        this.role = role;
        this.email = email;
        this.workout_id = workout_id;
    }
}
