package UTN.CAMILA.EXPROY.CamilaBackend.serviceimpl;
import java.time.LocalDate;
import java.util.List;

import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import UTN.CAMILA.EXPROY.CamilaBackend.dtos.ArticuloRequestDTO;
import UTN.CAMILA.EXPROY.CamilaBackend.dtos.ArticuloResponseDTO;
import UTN.CAMILA.EXPROY.CamilaBackend.model.Articulo;
import UTN.CAMILA.EXPROY.CamilaBackend.repository.ArticuloRepository;
import UTN.CAMILA.EXPROY.CamilaBackend.service.ArticuloService;
import jakarta.persistence.EntityNotFoundException;
@Service
public class ArticuloServiceImpl implements ArticuloService {
    
    @Autowired
    private ArticuloRepository articuloRepository;
    
    @Autowired
    private ModelMapper modelMapper;
    
    @Override
    public ArticuloResponseDTO save(ArticuloRequestDTO articuloRequestDTO) {
        Articulo articulo = modelMapper.map(articuloRequestDTO, Articulo.class);
        articulo.setEnabled(true);
        articulo.setCreationDate(LocalDate.now()); // <--- Change here
        Articulo saveArticulo = articuloRepository.save(articulo);
        return modelMapper.map(saveArticulo, ArticuloResponseDTO.class);
    }
    
    @Override
    public ArticuloResponseDTO update(Long id, ArticuloRequestDTO articuloRequestDTO) {
        Articulo existingArticulo = articuloRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Producto no encontrado"));
        modelMapper.map(articuloRequestDTO, existingArticulo);
        existingArticulo.setLastUpdateDate(LocalDate.now()); // <--- Change here
        Articulo updatedArticulo = articuloRepository.save(existingArticulo);
        return modelMapper.map(updatedArticulo, ArticuloResponseDTO.class);
    }
    @Override
    public void enable(Long id) {
        Articulo articulo = articuloRepository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Producto no encontrado"));
        articulo.setEnabled(true);
        articuloRepository.save(articulo);
    }
    
    @Override
    public void disable(Long  id) {
        Articulo articulo = articuloRepository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Producto no encontrado"));
        articulo.setEnabled(false);
        articuloRepository.save(articulo);
    }
    
    @Override
	public ArticuloResponseDTO getAllArticuloById(Long id) {
	Articulo articulo = articuloRepository.findById(id)
    .orElseThrow(() -> new EntityNotFoundException("Producto no encontrado"));
    return modelMapper.map(articulo, ArticuloResponseDTO.class);
	}

    @Override
    public List<ArticuloResponseDTO> getAllArticulo() {
       List<Articulo> articulos = articuloRepository.findAll();
       return articulos.stream()
       .map(articulo -> modelMapper.map(articulo, ArticuloResponseDTO.class))
       .collect(Collectors.toList());
    }
    @Override
    public List<ArticuloResponseDTO> searchArticulos(String modelo, String talla, String color) {
        List<Articulo> articulos = articuloRepository.findByModeloContainingAndTallaContainingAndColorContaining(modelo, talla, color);
        return articulos.stream()
                .map(articulo -> modelMapper.map(articulo, ArticuloResponseDTO.class))
                .collect(Collectors.toList());
    }

	
}