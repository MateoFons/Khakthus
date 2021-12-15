
package co.edu.arboleda.sergio.ciclo4.service;

import co.edu.arboleda.sergio.ciclo4.model.User;
import co.edu.arboleda.sergio.ciclo4.repository.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Clase Crea el UserService
 * @since 11-12-2021
 * @version 1.0
 * @author Grupo 4 subgrupo 2
 */
@Service
public class UserService {
    /**
     * creación de variable de tipo Repositorio con la anotación
     */
    @Autowired
    private UserRepository userRepository;
    
    /**
     * metodo para obtener todos los datos de la tabla user
     * @return List de clase User
     */
    public List<User> getAll() {
        return userRepository.getAll();
    }
    
    /**
     * metodo para obtener dato de la tabla User por Id
     * @param UserId
     * @return Optional de clase User
     */
    public Optional<User> getUser(int id) {
        
        return userRepository.getUser(id);
    }
    
    /**
     * metodo para crear el id en la tabla User
     * @param user
     * @return id de la clase User
     */
    public User create(User user) {
        
        //obtiene el maximo id existente en la coleccion
        Optional<User> userIdMaximo = userRepository.lastUserId();
        
        //si el id del Usaurio que se recibe como parametro es nulo, entonces valida el maximo id existente en base de datos
        if (user.getId() == null) {
            //valida el maximo id generado, si no hay ninguno aun el primer id sera 1
            if (userIdMaximo.isEmpty())
                user.setId(1);
            //si retorna informacion suma 1 al maximo id existente y lo asigna como el codigo del usuario
            else
                user.setId(userIdMaximo.get().getId() + 1);
        }
        
        Optional<User> e = userRepository.getUser(user.getId());
        if (e.isEmpty()) {
            if (emailExists(user.getEmail())==false){
                return userRepository.create(user);
            }else{
                return user;
            }
        }else{
            return user;
        }
    }
    
    /**
     * metodo para actualizar un dato de la tabla User
     * @param user
     * @return valor de la clase User
     */
    public User update(User user) {

        if (user.getId() != null) {
            Optional<User> userDb = userRepository.getUser(user.getId());
            if (!userDb.isEmpty()) {
                if (user.getIdentification() != null) {
                    userDb.get().setIdentification(user.getIdentification());
                }
                if (user.getName() != null) {
                    userDb.get().setName(user.getName());
                }
                if (user.getAddress() != null) {
                    userDb.get().setAddress(user.getAddress());
                }
                if (user.getCellPhone() != null) {
                    userDb.get().setCellPhone(user.getCellPhone());
                }
                if (user.getEmail() != null) {
                    userDb.get().setEmail(user.getEmail());
                }
                if (user.getPassword() != null) {
                    userDb.get().setPassword(user.getPassword());
                }
                if (user.getZone() != null) {
                    userDb.get().setZone(user.getZone());
                }
                
                userRepository.update(userDb.get());
                return userDb.get();
            } else {
                return user;
            }
        } else {
            return user;
        }
    }
    
    /**
     * metodo para borrar un dato de la tabla User por Id
     * @param userId
     * @return boolean
     */
    public boolean delete(int userId) {
        Boolean aBoolean = getUser(userId).map(user -> {
            userRepository.delete(user);
            return true;
        }).orElse(false);
        return aBoolean;
    }
    
    /**
     * metodo para consultar la existencia del email en la tabla User por Id
     * @return email
     */
    public boolean emailExists(String email) {
        return userRepository.emailExists(email);
    }
    
    /**
     * metodo para autenticar el email y password en la tabla User por Id
     * @return user
     */
    public User authenticateUser(String email, String password) {
        Optional<User> usuario = userRepository.authenticateUser(email, password);

        if (usuario.isEmpty()) {
            return new User();
        } else {
            return usuario.get();
        }
    }
    
}
