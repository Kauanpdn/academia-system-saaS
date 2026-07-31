package academia.backend.mapper;

import org.springframework.stereotype.Component;

import academia.backend.dto.workout.WorkoutRequestDTO;
import academia.backend.dto.workout.WorkoutResponseDTO;
import academia.backend.entity.Student;
import academia.backend.entity.Workout;

@Component
public class WorkoutMapper {

    public Workout toEntity(
            WorkoutRequestDTO dto,
            Student student) {

        Workout workout = new Workout();

        workout.setName(dto.name());
        workout.setDescription(dto.description());
        workout.setStudent(student);

        return workout;
    }

    public WorkoutResponseDTO toResponse(Workout workout) {

        return new WorkoutResponseDTO(
                workout.getId(),
                workout.getName(),
                workout.getDescription(),
                workout.getStudent().getId(),
                workout.getCreatedAt(),
                workout.getUpdatedAt()
        );
    }
}