package ciclo4.service;

import ciclo4.model.User;
import ciclo4.repository.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * @author Grupo desarrollo
 */
@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;
    
    /**
     * Metodo para listar todos los usuarios
     * @return lista de usuarios
     */
    public List<User> getAll(){
        return userRepository.getAll();
    }
    
    /**
     * Metodo para buscar usuario por id
     * @param id
     * @return usuario
     */
    public Optional<User> getUser(int id){
        return userRepository.getUser(id);
    }
    
    /**
     * Metodo para guardar registro de un usuario
     * @param user
     * @return usuario
     */
    public User registrar(User user){
        if(user.getId() == null){
            if(existeEmail(user.getEmail()) == false){
                return userRepository.save(user);
            }else{
                return user;
            }
        }else{
            return user;
        }
    }
    
    /**
     * Metodo para autenticar credenciales de usuario
     * @param email
     * @param password
     * @return usuario
     */
    public boolean existeEmail(String email){
        return userRepository.existeEmail(email);
    }
    
    /**
     * Metodo para validar si existe un usuario por el correo
     * @param email
     * @return boolean
     */
    public User autenticarUsuario(String email, String password){
        Optional<User> usuario = userRepository.autenticarUsuario(email, password);
        
        if(usuario.isEmpty()){
            return new User(email, password, "NO DEFINIDO");
        }else{
            return usuario.get();
        }
    } 
}