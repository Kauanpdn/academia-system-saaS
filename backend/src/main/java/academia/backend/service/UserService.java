package academia.backend.service;

import org.springframework.stereotype.Service;
import java.util.List;
import lombok.RequiredArgsConstructor;

import academia.backend.entity.User;
import academia.backend.repository.UserRepository;


@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User save(User user){
        return userRepository.save(user);
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findById(Integer id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
    }

    public User update(Integer id, User user){

        User userExists = findById(id);

        userExists.setName(user.getName());
        userExists.setEmail(user.getEmail());
        userExists.setPassword(user.getPassword());
        userExists.setRole(user.getRole());
        userExists.setAcademy(user.getAcademy());

        return userRepository.save(userExists);

    }

    public void delete(Integer id){
        userRepository.deleteById(id);
    }

}
