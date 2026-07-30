package academia.backend.dto.workoutExercise;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record WorkoutExerciseRequestDTO(

        @NotNull(message = "O treino é obrigatório")
        Integer workoutId,

        @NotNull(message = "O exercício é obrigatório")
        Integer exerciseId,

        @NotNull(message = "O número de séries é obrigatório")
        @Positive(message = "As séries devem ser maiores que zero")
        Integer sets,

        @NotNull(message = "O número de repetições é obrigatório")
        @Positive(message = "As repetições devem ser maiores que zero")
        Integer reps,

        @NotNull(message = "O tempo de descanso é obrigatório")
        @Positive(message = "O tempo de descanso deve ser maior que zero")
        Integer restTime

) {}