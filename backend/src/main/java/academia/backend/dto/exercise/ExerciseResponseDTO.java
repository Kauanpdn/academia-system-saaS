package academia.backend.dto.exercise;

import java.time.LocalDateTime;

public record ExerciseResponseDTO(

        Integer id,
        String name,
        String muscleGroup,
        LocalDateTime createdAt

) {}