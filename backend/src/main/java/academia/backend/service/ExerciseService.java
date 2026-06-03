package academia.backend.service;

import java.util.List;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import academia.backend.entity.Exercise;
import academia.backend.repository.ExerciseRepository;


@Service
@RequiredArgsConstructor
public class ExerciseService {

    private final ExerciseRepository exerciseRepository;

    public Exercise save(Exercise exercise) {
        return exerciseRepository.save(exercise);
    }

    public List<Exercise> findAll() {
        return exerciseRepository.findAll();
    }

    public Exercise findById(Integer id) {
        return exerciseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Exercício não encontrado"));
    }

    public Exercise update(Integer id, Exercise exercise) {

        Exercise exerciseExists = findById(id);

        exerciseExists.setName(exercise.getName());
        exerciseExists.setMuscleGroup(exercise.getMuscleGroup());

        return exerciseRepository.save(exerciseExists);
    }

    public void delete(Integer id) {
        exerciseRepository.deleteById(id);
    }
}