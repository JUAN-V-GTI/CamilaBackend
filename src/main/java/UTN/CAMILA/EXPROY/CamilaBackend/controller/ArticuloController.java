package UTN.CAMILA.EXPROY.CamilaBackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import UTN.CAMILA.EXPROY.CamilaBackend.dtos.ArticuloRequestDTO;
import UTN.CAMILA.EXPROY.CamilaBackend.dtos.ArticuloResponseDTO;
import UTN.CAMILA.EXPROY.CamilaBackend.service.ArticuloService;

@RestController
@CrossOrigin(origins = "http://192.168.100.2:8083")
@RequestMapping("/api/productos")
public class ArticuloController {
    
    @Autowired
    private ArticuloService articuloService;
    
    @PostMapping ("save/producto")
    public ResponseEntity <ArticuloResponseDTO> save(@RequestBody ArticuloRequestDTO articuloRequestDTO) {
        ArticuloResponseDTO responseDTO = articuloService.save(articuloRequestDTO);
        return new ResponseEntity<> (responseDTO, HttpStatus.CREATED);
    }
    
    @PutMapping("update/{id}")
    public ResponseEntity <ArticuloResponseDTO> update(@PathVariable Long id,
    @RequestBody ArticuloRequestDTO articuloRequestDTO) {
        ArticuloResponseDTO responseDTO = articuloService.update(id, articuloRequestDTO);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
    
    @PutMapping("/enable/{id}")
    public ResponseEntity <Void> enable(@PathVariable Long id) {
        articuloService.enable(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        
    }
    
    @PutMapping("disable/{id}")
    public ResponseEntity <Void> disable (@PathVariable Long id) {
      articuloService.disable(id);
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        
    }
    
    @GetMapping("/lista/all")
    public ResponseEntity<List<ArticuloResponseDTO>> getAllArticulo() {
    List<ArticuloResponseDTO> responseDTOs = articuloService.getAllArticulo();
    return new ResponseEntity<>(responseDTOs, HttpStatus.OK);
}

@GetMapping("search/{id}")
public ResponseEntity<ArticuloResponseDTO> getArticuloById(@PathVariable Long id) {
    ArticuloResponseDTO responseDTO = articuloService.getAllArticuloById(id);
    return new ResponseEntity<>(responseDTO, HttpStatus.OK);
}
@GetMapping("/search/filter")
    public ResponseEntity<List<ArticuloResponseDTO>> searchArticulos(
        @RequestParam(required = false, defaultValue = "") String modelo,
        @RequestParam(required = false, defaultValue = "") String talla,
        @RequestParam(required = false, defaultValue = "") String color) {
        
        List<ArticuloResponseDTO> responseDTOs = articuloService.searchArticulos(modelo, talla, color);
        return new ResponseEntity<>(responseDTOs, HttpStatus.OK);
    }
    }
