package academia.backend.mapper;

import org.springframework.stereotype.Component;

import academia.backend.dto.academy.AcademyRequestDTO;
import academia.backend.dto.academy.AcademyResponseDTO;
import academia.backend.entity.Academy;

@Component
public class AcademyMapper {
    
    public Academy toEntity(AcademyRequestDTO dto) {

        Academy academy = new Academy();

        academy.setName(dto.name());
        academy.setEmail(dto.email());
        academy.setPhone(dto.phone());

        return academy;
    }

    public AcademyResponseDTO toResponse(Academy academy) {

        return new AcademyResponseDTO(
                academy.getId(),
                academy.getName(),
                academy.getEmail(),
                academy.getPhone(),
                academy.getCreatedAt(),
                academy.getUpdatedAt()
        );
    }    

}
