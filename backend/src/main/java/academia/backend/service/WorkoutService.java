package academia.backend.service;

import java.util.List;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import academia.backend.entity.Workout;
import academia.backend.repository.WorkoutRepository;

@Service
@RequiredArgsConstructor
public class WorkoutService {
    
    

    private final WorkoutRepository workoutRepository;

    public Workout save(Workout workout) {
        return workoutRepository.save(workout);
    }

    public List<Workout> findAll() {
        return workoutRepository.findAll();
    }

    public Workout findById(Integer id) {
        return workoutRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Treino não encontrado"));
    }

    public Workout update(Integer id, Workout workout) {

        Workout workoutExists = findById(id);

        workoutExists.setName(workout.getName());
        workoutExists.setDescription(workout.getDescription());
        workoutExists.setStudent(workout.getStudent());

        return workoutRepository.save(workoutExists);
    }

    public void delete(Integer id) {
        workoutRepository.deleteById(id);
    }

}
