package mk.finki.ukim.mk.fitness_app.repository;

import mk.finki.ukim.mk.fitness_app.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
