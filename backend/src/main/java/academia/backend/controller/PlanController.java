package academia.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import academia.backend.entity.Plan;
import academia.backend.service.PlanService;

@RestController
@RequestMapping("/Plans")
public class PlanController {

    @Autowired
    private PlanService planService;


    @GetMapping
    public List<Plan> findAll() {
        return planService.findAll();
    }

    @GetMapping("/{id}")
    public Plan findById(@PathVariable Integer id) {
        return planService.findById(id);
    }

    @PostMapping
    public Plan save(@RequestBody Plan plan) {
        return planService.save(plan);
    }

    @PutMapping("/{id}")
    public Plan update(@PathVariable Integer id, @RequestBody Plan plan) {
        return planService.update(id, plan);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        planService.delete(id);
    }

}
