package UTN.CAMILA.EXPROY.CamilaBackend.service;



import java.util.List;

import UTN.CAMILA.EXPROY.CamilaBackend.dtos.ArticuloRequestDTO;
import UTN.CAMILA.EXPROY.CamilaBackend.dtos.ArticuloResponseDTO;

public interface ArticuloService {
    ArticuloResponseDTO save(ArticuloRequestDTO articuloRequestDTO);
    ArticuloResponseDTO update(ArticuloRequestDTO articuloRequestDTO);
    void enable(Integer id);
    void disable(Integer id);
    List<ArticuloResponseDTO> getAllArticulos();
}