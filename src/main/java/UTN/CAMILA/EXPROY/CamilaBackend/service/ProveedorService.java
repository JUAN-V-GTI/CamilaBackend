package UTN.CAMILA.EXPROY.CamilaBackend.service;

import UTN.CAMILA.EXPROY.CamilaBackend.dtos.ProveedorRequestDTO;
import UTN.CAMILA.EXPROY.CamilaBackend.dtos.ProveedorResponseDTO;

public interface ProveedorService {
    ProveedorResponseDTO createProveedor(ProveedorRequestDTO proveedorRequestDTO);

    ProveedorResponseDTO updateProveedor(Long id, ProveedorRequestDTO proveedorRequestDTO);

    void disableProveedor(Long id);

    ProveedorResponseDTO getProveedorById(Long id);

    void enableProveedor(Long id);
}
