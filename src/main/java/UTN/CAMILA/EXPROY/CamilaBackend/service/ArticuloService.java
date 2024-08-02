package UTN.CAMILA.EXPROY.CamilaBackend.service;

import java.util.List;

import UTN.CAMILA.EXPROY.CamilaBackend.dtos.ArticuloRequestDTO;
import UTN.CAMILA.EXPROY.CamilaBackend.dtos.ArticuloResponseDTO;

public interface ArticuloService {
    ArticuloResponseDTO save(ArticuloRequestDTO articuloRequestDTO);

    ArticuloResponseDTO update(Long id, ArticuloRequestDTO articuloRequestDTO);

    void disable(Long id);

    void enable(Long id);

    List<ArticuloResponseDTO> getAllArticulo();
    ArticuloResponseDTO getAllArticuloById(Long id);
    List<ArticuloResponseDTO> searchArticulos(String modelo, String talla, String color);
}