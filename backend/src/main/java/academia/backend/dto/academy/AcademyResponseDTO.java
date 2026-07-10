package academia.backend.dto.academy;

import java.time.LocalDateTime;

public record AcademyResponseDTO(

    Integer id,
    String name,
    String email,
    String phone,
    LocalDateTime createdAt,
    LocalDateTime updatedAt

) {} 
