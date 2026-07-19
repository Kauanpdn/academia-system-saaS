package academia.backend.dto.student;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


public record StudentRequestDTO(

        @NotBlank(message = "O nome é obrigatório")
        @Size(max = 100)
        String name,

        @NotNull(message = "A data de nascimento é obrigatória")
        LocalDate birthDate,

        @NotNull(message = "A academia é obrigatória")
        Integer academyId,

        @NotNull(message = "O plano é obrigatório")
        Integer planId

) {}
