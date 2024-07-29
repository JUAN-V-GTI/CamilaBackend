package UTN.CAMILA.EXPROY.CamilaBackend.dtos;

import lombok.Data;

@Data
public class RegisterRequestDTO {
    private String username;
    private String firstname;
    private String lastname;
    private String sex; // Valid values: "hombre", "mujer"
    private String rfc;
    private String phoneNumber;
    private String password;
    private String role; // Valid values: "admin", "vendedor"
}