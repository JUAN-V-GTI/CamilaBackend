package UTN.CAMILA.EXPROY.CamilaBackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import UTN.CAMILA.EXPROY.CamilaBackend.model.Cliente;

public interface ClienteRepo extends JpaRepository<Cliente, Long> {

}
