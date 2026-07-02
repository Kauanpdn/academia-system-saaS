package academia.backend.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import academia.backend.entity.WorkoutExercise;
import academia.backend.service.WorkoutExerciseService;

@RestController
@RequestMapping("/workout-exercises")
public class WorkoutExerciseController {
    
    
    @Autowired
    private WorkoutExerciseService workoutExerciseService;


    @GetMapping
    public List <WorkoutExercise> findAll(){
        return workoutExerciseService.findAll();
    }

    @GetMapping("/{id}")
    public WorkoutExercise findById(@PathVariable Integer id) {
        return workoutExerciseService.findById(id);
    }

    @PostMapping
    public WorkoutExercise save(@RequestBody WorkoutExercise workoutExercise) {
        return workoutExerciseService.save(workoutExercise);
    }

    @PutMapping("/{id}")
    public WorkoutExercise update(@PathVariable Integer id, @RequestBody WorkoutExercise workoutExercise) {
        return workoutExerciseService.update(id, workoutExercise);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        workoutExerciseService.delete(id);
    }
}
