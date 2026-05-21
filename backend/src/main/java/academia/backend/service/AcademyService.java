package academia.backend.service;

import java.util.List;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import academia.backend.entity.Academy;
import academia.backend.repository.AcademyRepository;

@Service
@RequiredArgsConstructor
public class AcademyService {

    private final AcademyRepository academyRepository;

    public Academy save (Academy academy){
        return academyRepository.save(academy);
    }

    public List<Academy> findAll(){
        return academyRepository.findAll();
    }

    public Academy findById(Integer id){
        return academyRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Academia não encontrada"));
    }

    public Academy update(Integer id, Academy academy){

        Academy academyExists = findById(id);

        academyExists.setName(academyExists.getName());
        academyExists.setEmail(academyExists.getEmail());
        academyExists.setPhone(academyExists.getPhone());

        return academyRepository.save(academyExists);

    }

    public void delete(Integer id){
        academyRepository.deleteById(id);;
    }

}
