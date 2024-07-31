package UTN.CAMILA.EXPROY.CamilaBackend.serviceimpl;
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
@Service
public class ArticuloServiceImpl implements ArticuloService {
    
    @Autowired
    private ArticuloRepository articuloRepository;
    
    @Autowired
    private ModelMapper modelMapper;
    
    @Override
    public ArticuloResponseDTO save(ArticuloRequestDTO articuloRequestDTO) {
        Articulo articulo = modelMapper.map(articuloRequestDTO, Articulo.class);
        articulo = articuloRepository.save(articulo);
        return modelMapper.map(articulo, ArticuloResponseDTO.class);
    }
    
    @Override
    public ArticuloResponseDTO update(ArticuloRequestDTO articuloRequestDTO) {
        Articulo articulo = articuloRepository.findById(articuloRequestDTO.getId()).orElseThrow();
        articulo = modelMapper.map(articuloRequestDTO, Articulo.class);
        articulo = articuloRepository.save(articulo);
        return modelMapper.map(articulo, ArticuloResponseDTO.class);
    }
    
    @Override
    public void enable(Integer id) {
        Articulo articulo = articuloRepository.findById(id).orElseThrow();
        articulo.setEnabled(true);
        articuloRepository.save(articulo);
    }
    
    @Override
    public void disable(Integer id) {
        Articulo articulo = articuloRepository.findById(id).orElseThrow();
        articulo.setEnabled(false);
        articuloRepository.save(articulo);
    }
    
    

    @Override
    public List<ArticuloResponseDTO> getAllArticulos() {
       List<Articulo> articulos = articuloRepository.findAll();
       return articulos.stream()
       .map(articulo -> modelMapper.map(articulo, ArticuloResponseDTO.class))
       .collect(Collectors.toList());
    }
}