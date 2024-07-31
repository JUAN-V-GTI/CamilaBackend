package UTN.CAMILA.EXPROY.CamilaBackend.dtos;

import lombok.Data;

@Data
public class ArticuloRequestDTO {
    private Integer id;

    private String producto;

    private String talla;

    private String color;

    private String modelo;

    private String precio;

    private String genero;

    private Boolean enabled;
}