package academia.backend.dto.plan;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record PlanResponseDTO(

        Integer id,
        String name,
        BigDecimal price,
        Integer duration,
        Integer academyId,
        LocalDateTime createdAt,
        LocalDateTime updatedAt

) {} 
