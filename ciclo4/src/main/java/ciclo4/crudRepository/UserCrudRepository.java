package ciclo4.crudRepository;

import ciclo4.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;


/**
 * 
 * @author Grupo desarrollo
 */

public interface UserCrudRepository extends CrudRepository<User, Integer> {
    
    /**
     * Metodo para encontrar usuario por el correo
     * lo usamos para validar usuario existe
     * @param email
     * @return implementacion
     */
    Optional<User> findByEmail(String email);
    
    /**
     * Metodo para encontrar un usuario por correo y password
     * lo usamos para validar credencial usuario
     * @param email
     * @param password
     * @return implementacion
     */
    Optional<User> findByEmailAndPassword (String email, String password);
}
