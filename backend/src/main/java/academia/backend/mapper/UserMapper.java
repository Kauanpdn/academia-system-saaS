package academia.backend.mapper;

import org.springframework.stereotype.Component;

import academia.backend.dto.user.UserRequestDTO;
import academia.backend.dto.user.UserResponseDTO;
import academia.backend.entity.Academy;
import academia.backend.entity.User;

@Component
public class UserMapper {

        public User toEntity(UserRequestDTO dto, Academy academy) {

                User user = new User();

                user.setName(dto.name());
                user.setEmail(dto.email());
                user.setPassword(dto.password());
                user.setRole(dto.role());
                user.setAcademy(academy);

                return user;
        }

        public UserResponseDTO toResponse(User user) {

                return new UserResponseDTO(
                                user.getId(),
                                user.getName(),
                                user.getEmail(),
                                user.getRole(),
                                user.getAcademy().getId(),
                                user.getCreatedAt(),
                                user.getUpdatedAt());
        }
}