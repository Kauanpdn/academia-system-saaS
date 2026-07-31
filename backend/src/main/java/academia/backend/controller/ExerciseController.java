package academia.backend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import academia.backend.dto.exercise.ExerciseRequestDTO;
import academia.backend.dto.exercise.ExerciseResponseDTO;
import academia.backend.service.ExerciseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/exercises")
@RequiredArgsConstructor
public class ExerciseController {

    private final ExerciseService exerciseService;

    @GetMapping
    public List<ExerciseResponseDTO> findAll() {
        return exerciseService.findAll();
    }

    @GetMapping("/{id}")
    public ExerciseResponseDTO findById(@PathVariable Integer id) {
        return exerciseService.findById(id);
    }

    @PostMapping
    public ExerciseResponseDTO save(@Valid @RequestBody ExerciseRequestDTO dto) {
        return exerciseService.save(dto);
    }

    @PutMapping("/{id}")
    public ExerciseResponseDTO update(
            @PathVariable Integer id,
            @Valid @RequestBody ExerciseRequestDTO dto) {

        return exerciseService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        exerciseService.delete(id);
    }

}