package academia.backend.dto.payment;


import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PaymentRequestDTO(
        @NotNull(message = "O aluno é obrigatório")
        Integer studentId,

        @NotNull(message = "A academia é obrigatória")
        Integer academyId,

        @NotNull(message = "O valor é obrigatório")
        @DecimalMin(value = "0.0", inclusive = false, message = "O valor deve ser maior que zero")
        BigDecimal amount,

        @NotBlank(message = "O status é obrigatório")
        String status,

        @NotNull(message = "A data do pagamento é obrigatória")
        LocalDateTime paymentDate
) {}
