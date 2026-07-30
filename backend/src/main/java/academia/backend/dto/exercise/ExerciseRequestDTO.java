package academia.backend.dto.exercise;

import jakarta.validation.constraints.NotBlank;

public record ExerciseRequestDTO(

        @NotBlank(message = "O nome é obrigatório")
        String name,

        @NotBlank(message = "O grupo muscular é obrigatório")
        String muscleGroup

) {}