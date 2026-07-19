package academia.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import academia.backend.dto.user.UserRequestDTO;
import academia.backend.dto.user.UserResponseDTO;
import academia.backend.entity.Academy;
import academia.backend.entity.User;
import academia.backend.mapper.UserMapper;
import academia.backend.repository.AcademyRepository;
import academia.backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final AcademyRepository academyRepository;
    private final UserMapper userMapper;

    public UserResponseDTO save(UserRequestDTO dto) {

        Academy academy = academyRepository.findById(dto.academyId())
                .orElseThrow(() -> new RuntimeException("Academia não encontrada"));

        User user = new User();

        user.setName(dto.name());
        user.setEmail(dto.email());
        user.setPassword(dto.password()); // Depois será passwordEncoder.encode(...)
        user.setRole(dto.role());
        user.setAcademy(academy);

        User saved = userRepository.save(user);

        return userMapper.toResponse(saved);
    }

    public List<UserResponseDTO> findAll() {

        return userRepository.findAll()
                .stream()
                .map(userMapper::toResponse)
                .toList();
    }

    public UserResponseDTO findById(Integer id) {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        return userMapper.toResponse(user);
    }

    public UserResponseDTO update(Integer id, UserRequestDTO dto) {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        Academy academy = academyRepository.findById(dto.academyId())
                .orElseThrow(() -> new RuntimeException("Academia não encontrada"));

        user.setName(dto.name());
        user.setEmail(dto.email());
        user.setPassword(dto.password());
        user.setRole(dto.role());
        user.setAcademy(academy);

        User updated = userRepository.save(user);

        return userMapper.toResponse(updated);
    }

    public void delete(Integer id) {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        userRepository.delete(user);
    }
}