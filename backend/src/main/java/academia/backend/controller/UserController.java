package academia.backend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import academia.backend.dto.user.UserRequestDTO;
import academia.backend.dto.user.UserResponseDTO;
import academia.backend.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<UserResponseDTO> findAll() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public UserResponseDTO findById(@PathVariable Integer id) {
        return userService.findById(id);
    }

    @PostMapping
    public UserResponseDTO save(@Valid @RequestBody UserRequestDTO dto) {
        return userService.save(dto);
    }

    @PutMapping("/{id}")
    public UserResponseDTO update(
            @PathVariable Integer id,
            @Valid @RequestBody UserRequestDTO dto) {

        return userService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        userService.delete(id);
    }
}