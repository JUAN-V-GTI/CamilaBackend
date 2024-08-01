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
import org.springframework.web.bind.annotation.RestController;
import UTN.CAMILA.EXPROY.CamilaBackend.dtos.ArticuloRequestDTO;
import UTN.CAMILA.EXPROY.CamilaBackend.dtos.ArticuloResponseDTO;
import UTN.CAMILA.EXPROY.CamilaBackend.service.ArticuloService;

@RestController
@CrossOrigin(origins = "http://192.168.100.2:8083")
@RequestMapping("/api/articulos")
public class ArticuloController {
    
    @Autowired
    private ArticuloService articuloService;
    
    @PostMapping ("save/articulo")
    public ArticuloResponseDTO save(@RequestBody ArticuloRequestDTO articuloRequestDTO) {
        return articuloService.save(articuloRequestDTO);
    }
    
    @PutMapping("/update")
    public ArticuloResponseDTO update(@RequestBody ArticuloRequestDTO articuloRequestDTO) {
        return articuloService.update(articuloRequestDTO);
    }
    
    @PutMapping("/enable/{id}")
    public void enable(@PathVariable Integer id) {
        articuloService.enable(id);
    }
    
    @PutMapping("disable/{id}")
    public void disable(@PathVariable Integer id) {
        articuloService.disable(id);
    }
    
    @GetMapping("/lista/all")
    public ResponseEntity<List<ArticuloResponseDTO>> getAllArticulo() {
    List<ArticuloResponseDTO> responseDTOs = articuloService.getAllArticulos();
    return new ResponseEntity<>(responseDTOs, HttpStatus.OK);
}
    }
