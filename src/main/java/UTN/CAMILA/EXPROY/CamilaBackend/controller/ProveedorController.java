package UTN.CAMILA.EXPROY.CamilaBackend.controller;

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

import UTN.CAMILA.EXPROY.CamilaBackend.dtos.ProveedorRequestDTO;
import UTN.CAMILA.EXPROY.CamilaBackend.dtos.ProveedorResponseDTO;
import UTN.CAMILA.EXPROY.CamilaBackend.service.ProveedorService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/proveedor")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://192.168.100.2:8083")
public class ProveedorController {

    private final ProveedorService proveedorService;

    @PostMapping("save/proveedor")
    public ResponseEntity<ProveedorResponseDTO> createProveedor(@RequestBody ProveedorRequestDTO proveedorRequestDTO) {
        ProveedorResponseDTO responseDTO = proveedorService.createProveedor(proveedorRequestDTO);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<ProveedorResponseDTO> updateProveedor(@PathVariable Long id,
            @RequestBody ProveedorRequestDTO proveedorRequestDTO) {
        ProveedorResponseDTO responseDTO = proveedorService.updateProveedor(id, proveedorRequestDTO);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @PutMapping("disable/{id}")
    public ResponseEntity<Void> disableProveedor(@PathVariable Long id) {
        proveedorService.disableProveedor(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("search/{id}")
    public ResponseEntity<ProveedorResponseDTO> getProveedorById(@PathVariable Long id) {
        ProveedorResponseDTO responseDTO = proveedorService.getProveedorById(id);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @PutMapping("/enable/{id}")
    public ResponseEntity<Void> enableProveedor(@PathVariable Long id) {
        proveedorService.enableProveedor(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
