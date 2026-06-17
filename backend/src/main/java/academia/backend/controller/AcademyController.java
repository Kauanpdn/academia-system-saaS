package academia.backend.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import academia.backend.entity.Academy;
import academia.backend.service.AcademyService;

@RestController
@RequestMapping("/academies")
public class AcademyController {

    
    @Autowired
    private AcademyService academyService;

    @GetMapping
    public List<Academy> findAll() {
        return academyService.findAll();
    }
    
    @GetMapping("/{id}")
    public Academy findById(@PathVariable Integer id){
        return academyService.findById(id);
    }

    @PostMapping()
    public Academy save(@RequestBody Academy academy){
        return academyService.save(academy);
    }

    @PutMapping("/{id}")
    public Academy upadate(@PathVariable Integer id, @RequestBody Academy academy){
        return academyService.update(id, academy);
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        academyService.delete(id);
    }

}
