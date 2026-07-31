package academia.backend.mapper;

import org.springframework.stereotype.Component;

import academia.backend.dto.exercise.ExerciseRequestDTO;
import academia.backend.dto.exercise.ExerciseResponseDTO;
import academia.backend.entity.Exercise;

@Component
public class ExerciseMapper {

    public Exercise toEntity(ExerciseRequestDTO dto) {

        Exercise exercise = new Exercise();

        exercise.setName(dto.name());
        exercise.setMuscleGroup(dto.muscleGroup());

        return exercise;
    }

    public ExerciseResponseDTO toResponse(Exercise exercise) {

        return new ExerciseResponseDTO(
                exercise.getId(),
                exercise.getName(),
                exercise.getMuscleGroup(),
                exercise.getCreatedAt()
        );
    }
}