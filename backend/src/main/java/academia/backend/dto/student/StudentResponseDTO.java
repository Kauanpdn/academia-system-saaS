package academia.backend.dto.student;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record StudentResponseDTO(
        
        Integer id,
        String name,
        LocalDate birthDate,
        Integer academyId,
        Integer planId,
        LocalDateTime createdAt,
        LocalDateTime updatedAt

) {}
