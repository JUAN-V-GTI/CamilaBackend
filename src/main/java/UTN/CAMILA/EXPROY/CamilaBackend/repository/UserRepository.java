package UTN.CAMILA.EXPROY.CamilaBackend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import UTN.CAMILA.EXPROY.CamilaBackend.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUsername(String username);
    Optional<User> findByUsernameOrFirstname(String username, String firstname);
}