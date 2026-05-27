package academia.backend.service;

import java.util.List;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import academia.backend.entity.Plan;
import academia.backend.repository.PlanRepository;

@Service
@RequiredArgsConstructor
public class PlanService {
    
    final private PlanRepository planRepository;

    public Plan save(Plan plan){
        return planRepository.save(plan);
    }

    public List<Plan> findAll(){
        return  planRepository.findAll();
    }

    public Plan findById(Integer id){
        return planRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Plano não encontrada"));
    }

    public Plan update(Integer id, Plan plan){
        Plan planExists = findById(id);

        planExists.setName(plan.getName());
        planExists.setPrice(plan.getPrice());
        planExists.setDuration(plan.getDuration());
        planExists.setAcademy(plan.getAcademy());

        return planRepository.save(planExists);
    }

    public void delete(Integer id){
        planRepository.deleteById(id);
    }
}
