package academia.backend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import academia.backend.dto.payment.PaymentRequestDTO;
import academia.backend.dto.payment.PaymentResponseDTO;
import academia.backend.service.PaymentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/payments")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @GetMapping
    public List<PaymentResponseDTO> findAll() {
        return paymentService.findAll();
    }

    @GetMapping("/{id}")
    public PaymentResponseDTO findById(@PathVariable Integer id) {
        return paymentService.findById(id);
    }

    @PostMapping
    public PaymentResponseDTO save(@Valid @RequestBody PaymentRequestDTO dto) {
        return paymentService.save(dto);
    }

    @PutMapping("/{id}")
    public PaymentResponseDTO update(
            @PathVariable Integer id,
            @Valid @RequestBody PaymentRequestDTO dto) {

        return paymentService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        paymentService.delete(id);
    }
}