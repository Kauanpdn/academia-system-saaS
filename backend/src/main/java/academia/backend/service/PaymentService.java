package academia.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import academia.backend.entity.Payment;
import academia.backend.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentRepository paymentRepository;

    public Payment save(Payment payment) {
        return paymentRepository.save(payment);
    }

    public List<Payment> findAll() {
        return paymentRepository.findAll();
    }

    public Payment findById(Integer id) {
        return paymentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pagamento não encontrado"));
    }

    public Payment update(Integer id, Payment payment) {

        Payment paymentExists = findById(id);

        paymentExists.setStudent(payment.getStudent());
        paymentExists.setAcademy(payment.getAcademy());
        paymentExists.setAmount(payment.getAmount());
        paymentExists.setStatus(payment.getStatus());
        paymentExists.setPaymentDate(payment.getPaymentDate());

        return paymentRepository.save(paymentExists);
    }

    public void delete(Integer id) {
        paymentRepository.deleteById(id);
    }
    
}
