package academia.backend.dto.workoutExercise;

public record WorkoutExerciseResponseDTO(

        Integer id,
        Integer workoutId,
        Integer exerciseId,
        Integer sets,
        Integer reps,
        Integer restTime

) {}