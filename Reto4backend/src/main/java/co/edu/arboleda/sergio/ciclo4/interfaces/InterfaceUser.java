
package co.edu.arboleda.sergio.ciclo4.interfaces;

import co.edu.arboleda.sergio.ciclo4.model.User;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Crea el repositorio InterfaceUser
 * @since 11-12-2021
 * @version 1.0
 * @author Grupo 4 subgrupo 2
 */
public interface InterfaceUser extends MongoRepository<User, Integer>  {
    Optional<User> findByEmail(String email);
    Optional<User> findByEmailAndPassword(String email,String password);  
    
    //Para seleccionar el usuario con el id maximo
    Optional<User> findTopByOrderByIdDesc();
}
