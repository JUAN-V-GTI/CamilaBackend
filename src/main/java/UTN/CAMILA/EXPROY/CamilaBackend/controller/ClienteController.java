package UTN.CAMILA.EXPROY.CamilaBackend.controller;
import java.util.List;

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

import UTN.CAMILA.EXPROY.CamilaBackend.dtos.ClienteRequestDTO;
import UTN.CAMILA.EXPROY.CamilaBackend.dtos.ClienteResponseDTO;
import UTN.CAMILA.EXPROY.CamilaBackend.service.ClienteService;
import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/api/clientes")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://192.168.100.2:8083")
public class ClienteController {

    private final ClienteService clienteService;

    @PostMapping("save/client")
    public ResponseEntity<ClienteResponseDTO> createCliente(@RequestBody ClienteRequestDTO clienteRequestDTO) {
        ClienteResponseDTO responseDTO = clienteService.createCliente(clienteRequestDTO);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<ClienteResponseDTO> updateCliente(@PathVariable Long id, @RequestBody ClienteRequestDTO clienteRequestDTO) {
        ClienteResponseDTO responseDTO = clienteService.updateCliente(id, clienteRequestDTO);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @PutMapping("disable/{id}")
    public ResponseEntity<Void> disableCliente(@PathVariable Long id) {
        clienteService.disableCliente(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("search/{id}")
    public ResponseEntity<ClienteResponseDTO> getClienteById(@PathVariable Long id) {
        ClienteResponseDTO responseDTO = clienteService.getClienteById(id);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @PutMapping("/enable/{id}")
    public ResponseEntity<Void> enableCliente(@PathVariable Long id) {
        clienteService.enableCliente(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("/lista/all")
public ResponseEntity<List<ClienteResponseDTO>> getAllClientes() {
    List<ClienteResponseDTO> responseDTOs = clienteService.getAllClientes();
    return new ResponseEntity<>(responseDTOs, HttpStatus.OK);
}
    
}
