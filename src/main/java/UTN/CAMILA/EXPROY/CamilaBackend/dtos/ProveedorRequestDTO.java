package UTN.CAMILA.EXPROY.CamilaBackend.dtos;

import lombok.Data;

@Data
public class ProveedorRequestDTO {
    private String name;
    private String firstname;
    private String lastname;
    private String numeroCuenta;
    private String phoneNumber;
    private String email;
    private String rol;
    private String empresa;
    private Boolean enabled;
}

