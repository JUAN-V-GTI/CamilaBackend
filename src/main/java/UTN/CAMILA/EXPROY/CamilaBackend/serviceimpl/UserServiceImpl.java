package UTN.CAMILA.EXPROY.CamilaBackend.serviceimpl;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import UTN.CAMILA.EXPROY.CamilaBackend.model.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import UTN.CAMILA.EXPROY.CamilaBackend.dtos.LoginRequestDTO;
import UTN.CAMILA.EXPROY.CamilaBackend.dtos.RegisterRequestDTO;
import UTN.CAMILA.EXPROY.CamilaBackend.dtos.UserResponseDTO;

import UTN.CAMILA.EXPROY.CamilaBackend.repository.UserRepository;
import UTN.CAMILA.EXPROY.CamilaBackend.service.UserService;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper; 
    @Override
    public UserResponseDTO login(LoginRequestDTO loginRequestDTO) {
        Optional<User> userOptional = userRepository.findByUsername(loginRequestDTO.getUsername());
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            if (loginRequestDTO.getPassword().equals(user.getPassword())) {
                return modelMapper.map(user, UserResponseDTO.class);
            }
        }
        throw new RuntimeException("Invalid username or password");
    }

    @Override
    public UserResponseDTO register(RegisterRequestDTO registerRequestDTO) {
        if (userRepository.findByUsername(registerRequestDTO.getUsername()).isPresent()) {
            throw new RuntimeException("Username already exists");
        }
        User user = modelMapper.map(registerRequestDTO, User.class);
        user.setPassword(registerRequestDTO.getPassword());
        userRepository.save(user);
        return modelMapper.map(user, UserResponseDTO.class);
    }

    @Override
    public UserResponseDTO updateUser(Integer id, RegisterRequestDTO registerRequestDTO) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            modelMapper.map(registerRequestDTO, user);
            user.setPassword(registerRequestDTO.getPassword());
            userRepository.save(user);
            return modelMapper.map(user, UserResponseDTO.class);
        }
        throw new RuntimeException("User not found");
    }


    @Override
    public void disableUser(Integer id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<UserResponseDTO> search(String keyword) {
        Optional<User> users = userRepository.findByUsernameOrFirstname(keyword, keyword);
        return users.stream().map(user -> modelMapper.map(user, UserResponseDTO.class)).collect(Collectors.toList());
    }
}