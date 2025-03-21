package mk.finki.ukim.mk.fitness_app.model.dtos;

import lombok.Data;

@Data
public class UserDto {

    private String username;

    private String role;

    private String email;

    private Long workout_id;

    public UserDto(String username, String role, String email, Long workout_id) {
        this.username = username;
        this.role = role;
        this.email = email;
        this.workout_id = workout_id;
    }
}
