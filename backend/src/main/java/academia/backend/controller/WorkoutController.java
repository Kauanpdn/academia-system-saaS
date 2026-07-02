package academia.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import academia.backend.entity.Workout;
import academia.backend.service.WorkoutService;

@RestController
@RequestMapping("/workouts")
public class WorkoutController {
    
    @Autowired
    private WorkoutService workoutService;


    @GetMapping
    public List<Workout> findAll(){
        return workoutService.findAll();
    }

    @GetMapping("/{id}")
    public Workout findById(@PathVariable Integer id) {
        return workoutService.findById(id);
    }

    @PostMapping
    public Workout save(@RequestBody Workout workout) {
        return workoutService.save(workout);
    }

    @PutMapping("/{id}")
    public Workout update(@PathVariable Integer id, @RequestBody Workout workout) {
        return workoutService.update(id, workout);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        workoutService.delete(id);
    }
}
