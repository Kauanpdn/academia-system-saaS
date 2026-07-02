package academia.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import academia.backend.entity.Exercise;
import academia.backend.service.ExerciseService;


@RestController
@RequestMapping("/exercises")
public class ExerciseController {

    @Autowired
    private ExerciseService exerciseService;


    @GetMapping
    public List<Exercise> findAll(){
        return exerciseService.findAll();
    }

    @GetMapping("/{id}")
    public Exercise findById(@PathVariable Integer id) {
        return exerciseService.findById(id);
    }

    @PostMapping
    public Exercise save(@RequestBody Exercise exercise) {
        return exerciseService.save(exercise);
    }

    @PutMapping("/{id}")
    public Exercise update(@PathVariable Integer id,
            @RequestBody Exercise exercise) {
        return exerciseService.update(id, exercise);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        exerciseService.delete(id);
    }

}
