package academia.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import academia.backend.dto.workout.WorkoutRequestDTO;
import academia.backend.dto.workout.WorkoutResponseDTO;
import academia.backend.entity.Student;
import academia.backend.entity.Workout;
import academia.backend.mapper.WorkoutMapper;
import academia.backend.repository.StudentRepository;
import academia.backend.repository.WorkoutRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class WorkoutService {

    private final WorkoutRepository workoutRepository;
    private final StudentRepository studentRepository;
    private final WorkoutMapper workoutMapper;

    public WorkoutResponseDTO save(WorkoutRequestDTO dto) {

        Student student = studentRepository.findById(dto.studentId())
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));

        Workout workout = workoutMapper.toEntity(dto, student);

        return workoutMapper.toResponse(workoutRepository.save(workout));
    }

    public List<WorkoutResponseDTO> findAll() {
        return workoutRepository.findAll()
                .stream()
                .map(workoutMapper::toResponse)
                .toList();
    }

    public WorkoutResponseDTO findById(Integer id) {

        Workout workout = workoutRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Treino não encontrado"));

        return workoutMapper.toResponse(workout);
    }

    public WorkoutResponseDTO update(Integer id, WorkoutRequestDTO dto) {

        Workout workout = workoutRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Treino não encontrado"));

        Student student = studentRepository.findById(dto.studentId())
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));

        workout.setName(dto.name());
        workout.setDescription(dto.description());
        workout.setStudent(student);

        return workoutMapper.toResponse(workoutRepository.save(workout));
    }

    public void delete(Integer id) {
        workoutRepository.deleteById(id);
    }
}