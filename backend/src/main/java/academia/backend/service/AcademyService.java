package academia.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;


import academia.backend.dto.academy.AcademyRequestDTO;
import academia.backend.dto.academy.AcademyResponseDTO;
import academia.backend.entity.Academy;
import academia.backend.mapper.AcademyMapper;
import academia.backend.repository.AcademyRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AcademyService {

    private final AcademyRepository academyRepository;
    private final AcademyMapper academyMapper;

    public AcademyResponseDTO save(AcademyRequestDTO dto) {

        Academy academy = academyMapper.toEntity(dto);

        Academy saved = academyRepository.save(academy);

        return academyMapper.toResponse(saved);
    }

    public List<AcademyResponseDTO> findAll() {

        return academyRepository.findAll()
                .stream()
                .map(academyMapper::toResponse)
                .toList();
    }

    public AcademyResponseDTO findById(Integer id) {

        Academy academy = academyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Academia não encontrada"));

        return academyMapper.toResponse(academy);
    }

    public AcademyResponseDTO update(Integer id, AcademyRequestDTO dto) {

        Academy academy = academyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Academia não encontrada"));

        academy.setName(dto.name());
        academy.setEmail(dto.email());
        academy.setPhone(dto.phone());

        Academy updated = academyRepository.save(academy);

        return academyMapper.toResponse(updated);
    }

    public void delete(Integer id) {

        Academy academy = academyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Academia não encontrada")); 
                academyRepository.delete(academy);
    }

}
