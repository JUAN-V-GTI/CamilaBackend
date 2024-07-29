package UTN.CAMILA.EXPROY.CamilaBackend.dtos;
import lombok.Data;

@Data
public class ClienteRequestDTO {
    private Long id;
    private String name;
    private String firstname;
    private String lastname;
    private String institution;
    private String phoneNumber;
    private String email;
    private String notes;
    private Boolean enabled;
    
}
