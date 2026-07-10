package academia.backend.dto.academy;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record AcademyRequestDTO(

    @NotBlank(message = "Nome é obrigatório")
    @Size(max = 100)
    String name,

    @NotBlank(message = "Email é obrigatório")
    @Email(message = "Email inválido")
    String email,

    @NotBlank(message = "Telefone é obrigatório")
    String phone

) {} 
