package academia.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import academia.backend.dto.payment.PaymentRequestDTO;
import academia.backend.dto.payment.PaymentResponseDTO;
import academia.backend.entity.Academy;
import academia.backend.entity.Payment;
import academia.backend.entity.Student;
import academia.backend.mapper.PaymentMapper;
import academia.backend.repository.AcademyRepository;
import academia.backend.repository.PaymentRepository;
import academia.backend.repository.StudentRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PaymentService {

        private final PaymentRepository paymentRepository;
        private final StudentRepository studentRepository;
        private final AcademyRepository academyRepository;
        private final PaymentMapper paymentMapper;

        public PaymentResponseDTO save(PaymentRequestDTO dto) {

                Student student = studentRepository.findById(dto.studentId())
                                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));

                Academy academy = academyRepository.findById(dto.academyId())
                                .orElseThrow(() -> new RuntimeException("Academia não encontrada"));

                Payment payment = paymentMapper.toEntity(dto, student, academy);

                return paymentMapper.toResponse(paymentRepository.save(payment));
        }

        public List<PaymentResponseDTO> findAll() {
                return paymentRepository.findAll()
                                .stream()
                                .map(paymentMapper::toResponse)
                                .toList();
        }

        public PaymentResponseDTO findById(Integer id) {

                Payment payment = paymentRepository.findById(id)
                                .orElseThrow(() -> new RuntimeException("Pagamento não encontrado"));

                return paymentMapper.toResponse(payment);
        }

        public PaymentResponseDTO update(Integer id, PaymentRequestDTO dto) {

                Payment payment = paymentRepository.findById(id)
                                .orElseThrow(() -> new RuntimeException("Pagamento não encontrado"));

                Student student = studentRepository.findById(dto.studentId())
                                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));

                Academy academy = academyRepository.findById(dto.academyId())
                                .orElseThrow(() -> new RuntimeException("Academia não encontrada"));

                payment.setStudent(student);
                payment.setAcademy(academy);
                payment.setAmount(dto.amount());
                payment.setStatus(dto.status());
                payment.setPaymentDate(dto.paymentDate());

                return paymentMapper.toResponse(paymentRepository.save(payment));
        }

        public void delete(Integer id) {
                paymentRepository.deleteById(id);
        }
}