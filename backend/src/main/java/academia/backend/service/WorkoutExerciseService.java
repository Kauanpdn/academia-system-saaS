package academia.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import academia.backend.dto.workoutExercise.WorkoutExerciseRequestDTO;
import academia.backend.dto.workoutExercise.WorkoutExerciseResponseDTO;
import academia.backend.entity.Exercise;
import academia.backend.entity.Workout;
import academia.backend.entity.WorkoutExercise;
import academia.backend.mapper.WorkoutExerciseMapper;
import academia.backend.repository.ExerciseRepository;
import academia.backend.repository.WorkoutExerciseRepository;
import academia.backend.repository.WorkoutRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class WorkoutExerciseService {

    private final WorkoutExerciseRepository workoutExerciseRepository;
    private final WorkoutRepository workoutRepository;
    private final ExerciseRepository exerciseRepository;
    private final WorkoutExerciseMapper workoutExerciseMapper;

    public WorkoutExerciseResponseDTO save(WorkoutExerciseRequestDTO dto) {

        Workout workout = workoutRepository.findById(dto.workoutId())
                .orElseThrow(() -> new RuntimeException("Treino não encontrado"));

        Exercise exercise = exerciseRepository.findById(dto.exerciseId())
                .orElseThrow(() -> new RuntimeException("Exercício não encontrado"));

        WorkoutExercise workoutExercise = workoutExerciseMapper.toEntity(dto, workout, exercise);

        return workoutExerciseMapper.toResponse(workoutExerciseRepository.save(workoutExercise));
    }

    public List<WorkoutExerciseResponseDTO> findAll() {
        return workoutExerciseRepository.findAll()
                .stream()
                .map(workoutExerciseMapper::toResponse)
                .toList();
    }

    public WorkoutExerciseResponseDTO findById(Integer id) {

        WorkoutExercise workoutExercise = workoutExerciseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("WorkoutExercise não encontrado"));

        return workoutExerciseMapper.toResponse(workoutExercise);
    }

    public WorkoutExerciseResponseDTO update(Integer id, WorkoutExerciseRequestDTO dto) {

        WorkoutExercise workoutExercise = workoutExerciseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("WorkoutExercise não encontrado"));

        Workout workout = workoutRepository.findById(dto.workoutId())
                .orElseThrow(() -> new RuntimeException("Treino não encontrado"));

        Exercise exercise = exerciseRepository.findById(dto.exerciseId())
                .orElseThrow(() -> new RuntimeException("Exercício não encontrado"));

        workoutExercise.setWorkout(workout);
        workoutExercise.setExercise(exercise);
        workoutExercise.setSets(dto.sets());
        workoutExercise.setReps(dto.reps());
        workoutExercise.setRestTime(dto.restTime());

        return workoutExerciseMapper.toResponse(workoutExerciseRepository.save(workoutExercise));
    }

    public void delete(Integer id) {
        workoutExerciseRepository.deleteById(id);
    }
}