package academia.backend.controller;


import java.util.List;

import org.springframework.web.bind.annotation.*;

import academia.backend.dto.academy.AcademyRequestDTO;
import academia.backend.dto.academy.AcademyResponseDTO;
import academia.backend.service.AcademyService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/academies")
@RequiredArgsConstructor
public class AcademyController {

    private final AcademyService academyService;

    @GetMapping
    public List<AcademyResponseDTO> findAll() {
        return academyService.findAll();
    }

    @GetMapping("/{id}")
    public AcademyResponseDTO findById(@PathVariable Integer id) {
        return academyService.findById(id);
    }

    @PostMapping
    public AcademyResponseDTO save(@Valid @RequestBody AcademyRequestDTO dto) {
        return academyService.save(dto);
    }

    @PutMapping("/{id}")
    public AcademyResponseDTO update(
            @PathVariable Integer id,
            @Valid @RequestBody AcademyRequestDTO dto) {

        return academyService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        academyService.delete(id);
    }
}
