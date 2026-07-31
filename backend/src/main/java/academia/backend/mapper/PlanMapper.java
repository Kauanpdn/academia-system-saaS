package academia.backend.mapper;

import org.springframework.stereotype.Component;

import academia.backend.dto.plan.PlanRequestDTO;
import academia.backend.dto.plan.PlanResponseDTO;
import academia.backend.entity.Academy;
import academia.backend.entity.Plan;

@Component
public class PlanMapper {

    public Plan toEntity(PlanRequestDTO dto, Academy academy) {

        Plan plan = new Plan();

        plan.setName(dto.name());
        plan.setPrice(dto.price());
        plan.setDuration(dto.duration());
        plan.setAcademy(academy);

        return plan;
    }

    public PlanResponseDTO toResponse(Plan plan) {

        return new PlanResponseDTO(
                plan.getId(),
                plan.getName(),
                plan.getPrice(),
                plan.getDuration(),
                plan.getAcademy().getId(),
                plan.getCreatedAt(),
                plan.getUpdatedAt()
        );
    }
}