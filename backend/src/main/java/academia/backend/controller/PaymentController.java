package academia.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import academia.backend.entity.Payment;
import academia.backend.service.PaymentService;


@RestController
@RequestMapping("/payments")
public class PaymentController {
    
    @Autowired
    private PaymentService paymentService;

    @GetMapping
    public List <Payment> findAll(){
        return paymentService.findAll();
    }
    
    @GetMapping("/{id}")
    public Payment findById(@PathVariable Integer id) {
        return paymentService.findById(id);
    }

    @PostMapping
    public Payment save(@RequestBody Payment payment) {
        return paymentService.save(payment);
    }

    @PutMapping("/{id}")
    public Payment update(@PathVariable Integer id, @RequestBody Payment payment) {
        return paymentService.update(id, payment);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        paymentService.delete(id);
    }
}
