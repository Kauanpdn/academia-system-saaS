package academia.backend.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import academia.backend.entity.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {
    
}
