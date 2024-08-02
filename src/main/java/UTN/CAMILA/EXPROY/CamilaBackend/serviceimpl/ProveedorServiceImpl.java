package UTN.CAMILA.EXPROY.CamilaBackend.serviceimpl;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import UTN.CAMILA.EXPROY.CamilaBackend.dtos.ProveedorRequestDTO;
import UTN.CAMILA.EXPROY.CamilaBackend.dtos.ProveedorResponseDTO;
import UTN.CAMILA.EXPROY.CamilaBackend.model.Proveedor;
import UTN.CAMILA.EXPROY.CamilaBackend.repository.ProveedorRepo;
import UTN.CAMILA.EXPROY.CamilaBackend.service.ProveedorService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProveedorServiceImpl implements ProveedorService {

    private final ProveedorRepo proveedorRepo;
    private final ModelMapper modelMapper;

    @Override
    public ProveedorResponseDTO createProveedor(ProveedorRequestDTO proveedorRequestDTO) {
        Proveedor proveedor = modelMapper.map(proveedorRequestDTO, Proveedor.class);
        proveedor.setEnabled(true); // Habilitar por defecto
        proveedor.setCreationDate(LocalDate.now());
        Proveedor savedProveedor = proveedorRepo.save(proveedor);
        return modelMapper.map(savedProveedor, ProveedorResponseDTO.class);
    }

    @Override
    public ProveedorResponseDTO updateProveedor(Long id, ProveedorRequestDTO proveedorRequestDTO) {
        Proveedor existingProveedor = proveedorRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Proveedor no encontrado"));
        modelMapper.map(proveedorRequestDTO, existingProveedor);
        existingProveedor.setLastUpdateDate(LocalDate.now());
        Proveedor updatedProveedor = proveedorRepo.save(existingProveedor);
        return modelMapper.map(updatedProveedor, ProveedorResponseDTO.class);
    }

    @Override
    public void disableProveedor(Long id) {
        Proveedor proveedor = proveedorRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Proveedor no encontrado"));
        proveedor.setEnabled(false);
        proveedorRepo.save(proveedor);
    }

    @Override
    public ProveedorResponseDTO getProveedorById(Long id) {
        Proveedor proveedor = proveedorRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Proveedor no encontrado"));
        return modelMapper.map(proveedor, ProveedorResponseDTO.class);
    }

    @Override
    public void enableProveedor(Long id) {
        Proveedor proveedor = proveedorRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Proveedor  no encontrado"));
        proveedor.setEnabled(true);
        proveedorRepo.save(proveedor);
    }

    @Override
    public List<ProveedorResponseDTO> getAllProveedor() {
        List<Proveedor> proveedores = proveedorRepo.findAll();
        return proveedores.stream()
                .map(p -> modelMapper.map(p, ProveedorResponseDTO.class))
                .collect(Collectors.toList());
    }
    
}
