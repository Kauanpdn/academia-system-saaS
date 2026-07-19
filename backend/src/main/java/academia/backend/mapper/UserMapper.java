package academia.backend.mapper;


import org.springframework.stereotype.Component;

import academia.backend.dto.user.UserResponseDTO;
import academia.backend.entity.User;


@Component
public class UserMapper {
    
        public UserResponseDTO toResponse(User user){

        return new UserResponseDTO(

                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getRole(),
                user.getAcademy().getId(),
                user.getCreatedAt(),
                user.getUpdatedAt()

        );

    }

}
