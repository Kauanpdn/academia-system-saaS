package academia.backend.mapper;

import org.springframework.stereotype.Component;

import academia.backend.dto.student.StudentRequestDTO;
import academia.backend.dto.student.StudentResponseDTO;
import academia.backend.entity.Academy;
import academia.backend.entity.Plan;
import academia.backend.entity.Student;

@Component
public class StudentMapper {

    public Student toEntity(
            StudentRequestDTO dto,
            Academy academy,
            Plan plan) {

        Student student = new Student();

        student.setName(dto.name());
        student.setBirthDate(dto.birthDate());
        student.setAcademy(academy);
        student.setPlan(plan);

        return student;
    }

    public StudentResponseDTO toResponse(Student student) {

        return new StudentResponseDTO(
                student.getId(),
                student.getName(),
                student.getBirthDate(),
                student.getAcademy().getId(),
                student.getPlan().getId(),
                student.getCreatedAt(),
                student.getUpdatedAt()
        );
    }
}