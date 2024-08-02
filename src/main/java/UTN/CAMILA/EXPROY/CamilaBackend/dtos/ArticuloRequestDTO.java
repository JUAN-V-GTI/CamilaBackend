package UTN.CAMILA.EXPROY.CamilaBackend.dtos;

import lombok.Data;

@Data
public class ArticuloRequestDTO {
    private Integer id;

    private String producto;

    private String talla;

    private String color;

    private String modelo;

    private Double precio;

    private String genero;

    private Boolean enabled;
}