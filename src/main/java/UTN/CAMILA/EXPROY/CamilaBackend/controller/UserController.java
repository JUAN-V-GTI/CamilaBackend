package UTN.CAMILA.EXPROY.CamilaBackend.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import UTN.CAMILA.EXPROY.CamilaBackend.dtos.LoginRequestDTO;
import UTN.CAMILA.EXPROY.CamilaBackend.dtos.RegisterRequestDTO;
import UTN.CAMILA.EXPROY.CamilaBackend.dtos.UserResponseDTO;
import UTN.CAMILA.EXPROY.CamilaBackend.service.UserService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/users")
// @CrossOrigin(origins = "http://192.168.100.3:8080")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "login")
    public UserResponseDTO login(@RequestBody LoginRequestDTO loginRequestDTO) {
        return userService.login(loginRequestDTO);
    }

    @PostMapping("/register")
    public UserResponseDTO register(@RequestBody RegisterRequestDTO registerRequestDTO) {
        return userService.register(registerRequestDTO);
    }
    @PutMapping("update/{id}")
    public UserResponseDTO update(@PathVariable Integer id, @RequestBody RegisterRequestDTO registerRequestDTO) {
        return userService.updateUser(id, registerRequestDTO);
    }

    @DeleteMapping("desable/{id}")
    public void disable(@PathVariable Integer id) {
        userService.disableUser(id);
    }

    @GetMapping("search/{keyword}")
    public List<UserResponseDTO> search(@PathVariable String keyword) {
        return userService.search(keyword);
    }
}