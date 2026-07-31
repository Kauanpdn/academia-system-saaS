package academia.backend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import academia.backend.dto.workoutExercise.WorkoutExerciseRequestDTO;
import academia.backend.dto.workoutExercise.WorkoutExerciseResponseDTO;
import academia.backend.service.WorkoutExerciseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/workout-exercises")
@RequiredArgsConstructor
public class WorkoutExerciseController {

    private final WorkoutExerciseService workoutExerciseService;

    @GetMapping
    public List<WorkoutExerciseResponseDTO> findAll() {
        return workoutExerciseService.findAll();
    }

    @GetMapping("/{id}")
    public WorkoutExerciseResponseDTO findById(@PathVariable Integer id) {
        return workoutExerciseService.findById(id);
    }

    @PostMapping
    public WorkoutExerciseResponseDTO save(
            @Valid @RequestBody WorkoutExerciseRequestDTO dto) {

        return workoutExerciseService.save(dto);
    }

    @PutMapping("/{id}")
    public WorkoutExerciseResponseDTO update(
            @PathVariable Integer id,
            @Valid @RequestBody WorkoutExerciseRequestDTO dto) {

        return workoutExerciseService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        workoutExerciseService.delete(id);
    }
}