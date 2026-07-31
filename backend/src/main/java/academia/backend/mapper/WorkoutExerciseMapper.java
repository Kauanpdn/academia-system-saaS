package academia.backend.mapper;

import org.springframework.stereotype.Component;

import academia.backend.dto.workoutExercise.WorkoutExerciseRequestDTO;
import academia.backend.dto.workoutExercise.WorkoutExerciseResponseDTO;
import academia.backend.entity.Exercise;
import academia.backend.entity.Workout;
import academia.backend.entity.WorkoutExercise;

@Component
public class WorkoutExerciseMapper {

    public WorkoutExercise toEntity(
            WorkoutExerciseRequestDTO dto,
            Workout workout,
            Exercise exercise) {

        WorkoutExercise workoutExercise = new WorkoutExercise();

        workoutExercise.setWorkout(workout);
        workoutExercise.setExercise(exercise);
        workoutExercise.setSets(dto.sets());
        workoutExercise.setReps(dto.reps());
        workoutExercise.setRestTime(dto.restTime());

        return workoutExercise;
    }

    public WorkoutExerciseResponseDTO toResponse(WorkoutExercise workoutExercise) {

        return new WorkoutExerciseResponseDTO(
                workoutExercise.getId(),
                workoutExercise.getWorkout().getId(),
                workoutExercise.getExercise().getId(),
                workoutExercise.getSets(),
                workoutExercise.getReps(),
                workoutExercise.getRestTime()
        );
    }
}