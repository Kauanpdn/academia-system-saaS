package academia.backend.dto.user;

import java.time.LocalDateTime;

public record UserResponseDTO(

        Integer id,
        String name,
        String email,
        String role,
        Integer academyId,
        LocalDateTime createdAt,
        LocalDateTime updsatedAt

) {} 
