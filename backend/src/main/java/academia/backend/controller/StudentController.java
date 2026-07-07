package academia.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import academia.backend.entity.Student;
import academia.backend.service.StudentService;

@RestController
@RequestMapping("/Students")
public class StudentController {
    
    @Autowired
    private StudentService studentService;

    @GetMapping
    public List<Student> findAll(){
        return studentService.findAll();
    }

    @GetMapping("/{id}")
    public Student findById(@PathVariable Integer id){
        return studentService.findById(id);
    }

    @PostMapping()
    public Student save(@PathVariable Student student){
        return studentService.save(student);
    }

    @PutMapping("/{id}")
    public Student update(@PathVariable Integer id, @RequestBody Student student){
        return studentService.update(id, student);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        studentService.delete(id);
    }
}
