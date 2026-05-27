package academia.backend.service;

import java.util.List;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import academia.backend.entity.Student;
import academia.backend.repository.StudentRepository;

@Service
@RequiredArgsConstructor
public class StudentService {
    
    private final StudentRepository studentRepository;

    public Student save(Student student){
        return studentRepository.save(student);
    }

    public List<Student> findAll(){
        return studentRepository.findAll();
    }

    public Student findById(Integer id){
        return studentRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Student não encontrada"));
    }

    public Student update(Integer id, Student student){
        
        Student studentExists = findById(id);

        studentExists.setName(studentExists.getName());
        studentExists.setBirthDate(studentExists.getBirthDate());
        studentExists.setAcademy(student.getAcademy());
        studentExists.setPlan(student.getPlan());

        return studentRepository.save(studentExists);
    }

    public void delete(Integer id){
        studentRepository.deleteById(id);
    }
}
