package ciclo4.repository;

import ciclo4.crudRepository.UserCrudRepository;
import ciclo4.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * 
 * @author Grupo desarrollo
 */

@Repository
public class UserRepository {
    
    @Autowired
    private UserCrudRepository userCrudRepository;
    
    /**
     * Metodo para listar todos los usuarios
     * @return lista de usuarios
     */
    public List<User> getAll(){
        return (List<User>) userCrudRepository.findAll();
    }
    
    /**
     * Metodo para buscar usuario por id
     * @param id
     * @return usuario
     */
    public Optional<User> getUser(int id) {
        return userCrudRepository.findById(id);
    }
    
    /**
     * Metodo para guardar registro de un usuario
     * @param user
     * @return usuario
     */
    public User save(User user){
        return userCrudRepository.save(user);
    }
    
    /**
     * Metodo para validar si existe un usuario por el correo
     * @param email
     * @return boolean
     */
    public boolean existeEmail(String email){
        Optional<User> usuario = userCrudRepository.findByEmail(email);
        return !usuario.isEmpty();
    }
    
    /**
     * Metodo para autenticar credenciales de usuario
     * @param email
     * @param password
     * @return usuario
     */
    public Optional<User> autenticarUsuario(String email, String password){
        return userCrudRepository.findByEmailAndPassword(email, password);
    }
}
