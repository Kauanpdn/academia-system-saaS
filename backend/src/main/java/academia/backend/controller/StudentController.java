package academia.backend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import academia.backend.dto.student.StudentRequestDTO;
import academia.backend.dto.student.StudentResponseDTO;
import academia.backend.service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    public List<StudentResponseDTO> findAll() {
        return studentService.findAll();
    }

    @GetMapping("/{id}")
    public StudentResponseDTO findById(@PathVariable Integer id) {
        return studentService.findById(id);
    }

    @PostMapping
    public StudentResponseDTO save(@Valid @RequestBody StudentRequestDTO dto) {
        return studentService.save(dto);
    }

    @PutMapping("/{id}")
    public StudentResponseDTO update(
            @PathVariable Integer id,
            @Valid @RequestBody StudentRequestDTO dto) {

        return studentService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        studentService.delete(id);
    }
}