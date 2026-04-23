package academia.backend.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import academia.backend.entity.Academy;


@Repository
public interface AcademyRepository extends JpaRepository<Academy, Integer> {
    Optional <Academy>  findByEmail(String email);
}
