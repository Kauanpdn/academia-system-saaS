package academia.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import academia.backend.entity.Exercise;

@Repository
public interface ExerciseRepository extends JpaRepository<Exercise, Integer>{
    
}
