package academia.backend.dto.workout;

import java.time.LocalDateTime;

public record WorkoutResponseDTO(

        Integer id,
        String name,
        String description,
        Integer studentId,
        LocalDateTime createdAt,
        LocalDateTime updatedAt

) {}