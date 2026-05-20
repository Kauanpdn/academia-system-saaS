package academia.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import academia.backend.entity.WorkoutExercise;

@Repository
public interface WorkoutExerciseRepository extends JpaRepository<WorkoutExercise, Integer>{

}
