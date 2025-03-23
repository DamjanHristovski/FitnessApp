package mk.finki.ukim.mk.fitness_app.repository;

import mk.finki.ukim.mk.fitness_app.model.Fitness_plan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Fitness_planRepository extends JpaRepository<Fitness_plan, Long> {
}
