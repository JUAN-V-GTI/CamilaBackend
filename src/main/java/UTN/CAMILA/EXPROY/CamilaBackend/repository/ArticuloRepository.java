package UTN.CAMILA.EXPROY.CamilaBackend.repository;





import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import UTN.CAMILA.EXPROY.CamilaBackend.model.Articulo;



@Repository
public interface ArticuloRepository extends JpaRepository<Articulo, Long> {
    
    List<Articulo> findByProductoAndTallaAndColorAndModeloAndPrecioAndGenero(String producto, String talla, String color, String modelo, Double precio, String genero);
    List<Articulo> findByModeloContainingAndTallaContainingAndColorContaining(String modelo, String talla, String color);
}