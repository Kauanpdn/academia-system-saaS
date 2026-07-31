package academia.backend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import academia.backend.dto.workout.WorkoutRequestDTO;
import academia.backend.dto.workout.WorkoutResponseDTO;
import academia.backend.service.WorkoutService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/workouts")
@RequiredArgsConstructor
public class WorkoutController {

    private final WorkoutService workoutService;

    @GetMapping
    public List<WorkoutResponseDTO> findAll() {
        return workoutService.findAll();
    }

    @GetMapping("/{id}")
    public WorkoutResponseDTO findById(@PathVariable Integer id) {
        return workoutService.findById(id);
    }

    @PostMapping
    public WorkoutResponseDTO save(@Valid @RequestBody WorkoutRequestDTO dto) {
        return workoutService.save(dto);
    }

    @PutMapping("/{id}")
    public WorkoutResponseDTO update(
            @PathVariable Integer id,
            @Valid @RequestBody WorkoutRequestDTO dto) {

        return workoutService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        workoutService.delete(id);
    }
}