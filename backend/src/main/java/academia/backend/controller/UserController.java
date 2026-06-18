package academia.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import academia.backend.entity.User;
import academia.backend.service.UserService;

@RestController
@RequestMapping("/Users")
public class UserController {
    
    @Autowired
    private UserService userService; 

    @GetMapping
    public List<User> findAll(){
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public User findById(@PathVariable Integer id){
        return userService.findById(id);
    }

    @PostMapping()
    public User save(@PathVariable User user){
        return userService.save(user);
    }

    @PutMapping("/{id}")
    public User update(@PathVariable Integer id, @RequestBody User user){
        return userService.update(id, user);
    }

    @DeleteMapping("/{id}")
    public void delete (@PathVariable Integer id){
        userService.delete(id);
    }
}
