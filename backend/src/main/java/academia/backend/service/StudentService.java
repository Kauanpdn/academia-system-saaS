package academia.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import academia.backend.dto.student.StudentRequestDTO;
import academia.backend.dto.student.StudentResponseDTO;
import academia.backend.entity.Academy;
import academia.backend.entity.Plan;
import academia.backend.entity.Student;
import academia.backend.mapper.StudentMapper;
import academia.backend.repository.AcademyRepository;
import academia.backend.repository.PlanRepository;
import academia.backend.repository.StudentRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentService {

        private final StudentRepository studentRepository;
        private final AcademyRepository academyRepository;
        private final PlanRepository planRepository;
        private final StudentMapper studentMapper;

        public StudentResponseDTO save(StudentRequestDTO dto) {

                Academy academy = academyRepository.findById(dto.academyId())
                                .orElseThrow(() -> new RuntimeException("Academia não encontrada"));

                Plan plan = planRepository.findById(dto.planId())
                                .orElseThrow(() -> new RuntimeException("Plano não encontrado"));

                Student student = studentMapper.toEntity(dto, academy, plan);

                return studentMapper.toResponse(studentRepository.save(student));
        }

        public List<StudentResponseDTO> findAll() {
                return studentRepository.findAll()
                                .stream()
                                .map(studentMapper::toResponse)
                                .toList();
        }

        public StudentResponseDTO findById(Integer id) {

                Student student = studentRepository.findById(id)
                                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));

                return studentMapper.toResponse(student);
        }

        public StudentResponseDTO update(Integer id, StudentRequestDTO dto) {

                Student student = studentRepository.findById(id)
                                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));

                Academy academy = academyRepository.findById(dto.academyId())
                                .orElseThrow(() -> new RuntimeException("Academia não encontrada"));

                Plan plan = planRepository.findById(dto.planId())
                                .orElseThrow(() -> new RuntimeException("Plano não encontrado"));

                student.setName(dto.name());
                student.setBirthDate(dto.birthDate());
                student.setAcademy(academy);
                student.setPlan(plan);

                return studentMapper.toResponse(studentRepository.save(student));
        }

        public void delete(Integer id) {
                studentRepository.deleteById(id);
        }
}