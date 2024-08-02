package UTN.CAMILA.EXPROY.CamilaBackend.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "proveedor")
public class Proveedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String firstname;

    private String lastname;

    private String numeroCuenta;

    private String phoneNumber;

    private String email;

    private Boolean enabled;

    private String rol;

    private String empresa;
    
    private LocalDate creationDate;

    private Long createdBy;

    private LocalDate lastUpdateDate;

    private Long lastUpdatedBy;

    private Long lastUpdateLogin;

}
