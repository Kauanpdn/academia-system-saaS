package academia.backend.mapper;

import org.springframework.stereotype.Component;

import academia.backend.dto.payment.PaymentRequestDTO;
import academia.backend.dto.payment.PaymentResponseDTO;
import academia.backend.entity.Academy;
import academia.backend.entity.Payment;
import academia.backend.entity.Student;

@Component
public class PaymentMapper {

    public Payment toEntity(
            PaymentRequestDTO dto,
            Student student,
            Academy academy) {

        Payment payment = new Payment();

        payment.setStudent(student);
        payment.setAcademy(academy);
        payment.setAmount(dto.amount());
        payment.setStatus(dto.status());
        payment.setPaymentDate(dto.paymentDate());

        return payment;
    }

    public PaymentResponseDTO toResponse(Payment payment) {

        return new PaymentResponseDTO(
                payment.getId(),
                payment.getStudent().getId(),
                payment.getAcademy().getId(),
                payment.getAmount(),
                payment.getStatus(),
                payment.getPaymentDate(),
                payment.getCreatedAt(),
                payment.getUpdatedAt()
        );
    }
}