package academia.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import academia.backend.entity.Plan;

@Repository
public interface PlanRepository extends JpaRepository <Plan, Integer> {

} 
