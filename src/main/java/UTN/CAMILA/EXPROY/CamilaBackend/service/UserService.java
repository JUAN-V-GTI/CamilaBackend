package UTN.CAMILA.EXPROY.CamilaBackend.service;



import java.util.List;

import UTN.CAMILA.EXPROY.CamilaBackend.dtos.LoginRequestDTO;
import UTN.CAMILA.EXPROY.CamilaBackend.dtos.RegisterRequestDTO;
import UTN.CAMILA.EXPROY.CamilaBackend.dtos.UserResponseDTO;

public interface UserService {
    UserResponseDTO login(LoginRequestDTO loginRequestDTO);
    UserResponseDTO register(RegisterRequestDTO registerRequestDTO);
    UserResponseDTO updateUser(Integer id, RegisterRequestDTO registerRequestDTO);
    void disableUser(Integer id);
    List<UserResponseDTO> search(String keyword);
}
