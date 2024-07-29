package UTN.CAMILA.EXPROY.CamilaBackend.dtos;

import lombok.Data;

@Data
public class UserResponseDTO {
    private Integer id;
    private String username;
    private String firstname;
    private String lastname;
    private String sex;
    private String rfc;
    private String phoneNumber;
    private String role;
}
