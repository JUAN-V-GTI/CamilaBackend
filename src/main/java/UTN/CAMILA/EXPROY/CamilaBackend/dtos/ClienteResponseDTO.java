package UTN.CAMILA.EXPROY.CamilaBackend.dtos;

import java.sql.Date;

import lombok.Data;

@Data
public class ClienteResponseDTO {
    private Integer id;
    private String name;
    private String firstname;
    private String lastname;
    private String institution;
    private String phoneNumber;
    private String email;
    private String notes;
    private Boolean enabled;
    private Date creationDate;
    private Long createdBy;
    private Date lastUpdateDate;
    private Long lastUpdatedBy;
    private Long lastUpdateLogin;
}
