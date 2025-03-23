package mk.finki.ukim.mk.fitness_app.repository;

import mk.finki.ukim.mk.fitness_app.model.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Long> {
}
