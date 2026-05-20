package academia.backend.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import academia.backend.entity.Workout;

@Repository
public interface WorkoutRepository extends JpaRepository<Workout, Integer> {

}
