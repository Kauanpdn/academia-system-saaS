package academia.backend.service;

import java.util.List;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import academia.backend.entity.WorkoutExercise;
import academia.backend.repository.WorkoutExerciseRepository;


@Service
@RequiredArgsConstructor
public class WorkoutExerciseService {

    private final WorkoutExerciseRepository workoutExerciseRepository;

    public WorkoutExercise save(WorkoutExercise workoutExercise) {
        return workoutExerciseRepository.save(workoutExercise);
    }

    public List<WorkoutExercise> findAll() {
        return workoutExerciseRepository.findAll();
    }

    public WorkoutExercise findById(Integer id) {
        return workoutExerciseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("WorkoutExercise não encontrado"));
    }

    public WorkoutExercise update(Integer id, WorkoutExercise workoutExercise) {

        WorkoutExercise workoutExerciseExists = findById(id);

        workoutExerciseExists.setWorkout(workoutExercise.getWorkout());
        workoutExerciseExists.setExercise(workoutExercise.getExercise());
        workoutExerciseExists.setSets(workoutExercise.getSets());
        workoutExerciseExists.setReps(workoutExercise.getReps());
        workoutExerciseExists.setRestTime(workoutExercise.getRestTime());

        return workoutExerciseRepository.save(workoutExerciseExists);
    }

    public void delete(Integer id) {
        workoutExerciseRepository.deleteById(id);
    }
}