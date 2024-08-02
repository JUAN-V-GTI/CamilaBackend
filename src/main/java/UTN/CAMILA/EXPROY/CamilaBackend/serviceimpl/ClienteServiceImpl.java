package UTN.CAMILA.EXPROY.CamilaBackend.serviceimpl;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import UTN.CAMILA.EXPROY.CamilaBackend.dtos.ClienteRequestDTO;
import UTN.CAMILA.EXPROY.CamilaBackend.dtos.ClienteResponseDTO;
import UTN.CAMILA.EXPROY.CamilaBackend.model.Cliente;
import UTN.CAMILA.EXPROY.CamilaBackend.repository.ClienteRepo;
import UTN.CAMILA.EXPROY.CamilaBackend.service.ClienteService;
@Service
@RequiredArgsConstructor
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepo clienteRepo;
    private final ModelMapper modelMapper;

    @Override
    public ClienteResponseDTO createCliente(ClienteRequestDTO clienteRequestDTO) {
        Cliente cliente = modelMapper.map(clienteRequestDTO, Cliente.class);
        cliente.setEnabled(true); // Habilitar por defecto
        cliente.setCreationDate(LocalDate.now());
        Cliente savedCliente = clienteRepo.save(cliente);
        return modelMapper.map(savedCliente, ClienteResponseDTO.class);
    }

    @Override
    public ClienteResponseDTO updateCliente(Long id, ClienteRequestDTO clienteRequestDTO) {
        Cliente existingCliente = clienteRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cliente no encontrado"));
        modelMapper.map(clienteRequestDTO, existingCliente);
        existingCliente.setLastUpdateDate(LocalDate.now());
        Cliente updatedCliente = clienteRepo.save(existingCliente);
        return modelMapper.map(updatedCliente, ClienteResponseDTO.class);
    }

    @Override
    public ClienteResponseDTO getClienteById(Long id) {
        Cliente cliente = clienteRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cliente no encontrado"));
        return modelMapper.map(cliente, ClienteResponseDTO.class);
    }

@Override
    public void disableCliente(Long id) {
        Cliente cliente = clienteRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cliente no encontrado"));
        cliente.setEnabled(false);
        clienteRepo.save(cliente);
    }
    @Override
    public void enableCliente(Long id) {
        Cliente cliente = clienteRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cliente no encontrado"));
        cliente.setEnabled(true);
        clienteRepo.save(cliente);
    }
    @Override
public List<ClienteResponseDTO> getAllClientes() {
    List<Cliente> clientes = clienteRepo.findAll();
    return clientes.stream()
            .map(cliente -> modelMapper.map(cliente, ClienteResponseDTO.class))
            .collect(Collectors.toList());
}
    
}
