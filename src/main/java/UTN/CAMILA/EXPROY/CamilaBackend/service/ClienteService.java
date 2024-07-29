package UTN.CAMILA.EXPROY.CamilaBackend.service;

import java.util.List;

import UTN.CAMILA.EXPROY.CamilaBackend.dtos.ClienteRequestDTO;
import UTN.CAMILA.EXPROY.CamilaBackend.dtos.ClienteResponseDTO;

public interface ClienteService {
    ClienteResponseDTO createCliente(ClienteRequestDTO clienteRequestDTO);
    ClienteResponseDTO updateCliente(Long id, ClienteRequestDTO clienteRequestDTO);
    void disableCliente(Long id);
    ClienteResponseDTO getClienteById(Long id);
    void enableCliente(Long id);
    List<ClienteResponseDTO> getAllClientes();
}
