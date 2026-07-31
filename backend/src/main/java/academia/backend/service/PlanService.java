package academia.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import academia.backend.dto.plan.PlanRequestDTO;
import academia.backend.dto.plan.PlanResponseDTO;
import academia.backend.entity.Academy;
import academia.backend.entity.Plan;
import academia.backend.mapper.PlanMapper;
import academia.backend.repository.AcademyRepository;
import academia.backend.repository.PlanRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PlanService {

    private final PlanRepository planRepository;
    private final AcademyRepository academyRepository;
    private final PlanMapper planMapper;

    public PlanResponseDTO save(PlanRequestDTO dto) {

        Academy academy = academyRepository.findById(dto.academyId())
                .orElseThrow(() -> new RuntimeException("Academia não encontrada"));

        Plan plan = planMapper.toEntity(dto, academy);

        return planMapper.toResponse(planRepository.save(plan));
    }

    public List<PlanResponseDTO> findAll() {
        return planRepository.findAll()
                .stream()
                .map(planMapper::toResponse)
                .toList();
    }

    public PlanResponseDTO findById(Integer id) {

        Plan plan = planRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Plano não encontrado"));

        return planMapper.toResponse(plan);
    }

    public PlanResponseDTO update(Integer id, PlanRequestDTO dto) {

        Plan plan = planRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Plano não encontrado"));

        Academy academy = academyRepository.findById(dto.academyId())
                .orElseThrow(() -> new RuntimeException("Academia não encontrada"));

        plan.setName(dto.name());
        plan.setPrice(dto.price());
        plan.setDuration(dto.duration());
        plan.setAcademy(academy);

        return planMapper.toResponse(planRepository.save(plan));
    }

    public void delete(Integer id) {
        planRepository.deleteById(id);
    }
}