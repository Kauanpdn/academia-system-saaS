package academia.backend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import academia.backend.dto.plan.PlanRequestDTO;
import academia.backend.dto.plan.PlanResponseDTO;
import academia.backend.service.PlanService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/plans")
@RequiredArgsConstructor
public class PlanController {

    private final PlanService planService;

    @GetMapping
    public List<PlanResponseDTO> findAll() {
        return planService.findAll();
    }

    @GetMapping("/{id}")
    public PlanResponseDTO findById(@PathVariable Integer id) {
        return planService.findById(id);
    }

    @PostMapping
    public PlanResponseDTO save(@Valid @RequestBody PlanRequestDTO dto) {
        return planService.save(dto);
    }

    @PutMapping("/{id}")
    public PlanResponseDTO update(
            @PathVariable Integer id,
            @Valid @RequestBody PlanRequestDTO dto) {

        return planService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        planService.delete(id);
    }
}