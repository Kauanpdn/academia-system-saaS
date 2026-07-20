package academia.backend.dto.payment;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record PaymentResponseDTO(

        Integer id,
        Integer studentId,
        Integer academyId,
        BigDecimal amount,
        String status,
        LocalDateTime paymentDate,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
        

) {}
