package academia.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import academia.backend.dto.exercise.ExerciseRequestDTO;
import academia.backend.dto.exercise.ExerciseResponseDTO;
import academia.backend.entity.Exercise;
import academia.backend.mapper.ExerciseMapper;
import academia.backend.repository.ExerciseRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ExerciseService {

    private final ExerciseRepository exerciseRepository;
    private final ExerciseMapper exerciseMapper;

    public ExerciseResponseDTO save(ExerciseRequestDTO dto) {

        Exercise exercise = exerciseMapper.toEntity(dto);

        return exerciseMapper.toResponse(exerciseRepository.save(exercise));
    }

    public List<ExerciseResponseDTO> findAll() {
        return exerciseRepository.findAll()
                .stream()
                .map(exerciseMapper::toResponse)
                .toList();
    }

    public ExerciseResponseDTO findById(Integer id) {

        Exercise exercise = exerciseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Exercício não encontrado"));

        return exerciseMapper.toResponse(exercise);
    }

    public ExerciseResponseDTO update(Integer id, ExerciseRequestDTO dto) {

        Exercise exercise = exerciseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Exercício não encontrado"));

        exercise.setName(dto.name());
        exercise.setMuscleGroup(dto.muscleGroup());

        return exerciseMapper.toResponse(exerciseRepository.save(exercise));
    }

    public void delete(Integer id) {
        exerciseRepository.deleteById(id);
    }
}