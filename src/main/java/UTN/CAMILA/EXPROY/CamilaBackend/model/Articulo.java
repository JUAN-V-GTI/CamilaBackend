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
@Table(name = "articulo")
public class Articulo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String producto;

    private String talla;

    private String color;

    private String modelo;

    private Double precio;

    private String genero;

    private Boolean enabled;
    
    private LocalDate creationDate;

    private Long createdBy;

    private LocalDate lastUpdateDate;

    private Long lastUpdatedBy;

    private Long lastUpdateLogin;

}
