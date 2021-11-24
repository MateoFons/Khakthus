package ciclo4.controller;

import ciclo4.model.User;
import ciclo4.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * 
 * @author grupo desarrollo
 */
@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class UserController {
    
    /**
     * instancia de la clase servicio
     */
    @Autowired
    private UserService userService;
    
    /**
     * Metodo para obtener una lista de todos los usuarios
     * @return Lista de todos los usuarios
     */
    @GetMapping("/all")
    public List<User> getAll(){
        return userService.getAll();
    }
    
    /**
     * Metodo registrar usuario
     * @param user
     * @return usuario
     */
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public User registrar(@RequestBody User user){
        return userService.registrar(user);
    }
    
    /**
     * 
     * @param email
     * @param password
     * @return boolean
     */
    @GetMapping("/{email}/{password}")
    public User autenticarUsuario(@PathVariable("email") String email,
                                  @PathVariable("password") String password){
        return userService.autenticarUsuario(email, password);
    }
    
    /**
     * Metodo que valida usuarios por correo
     * @param email
     * @return boolean
     */
    @GetMapping("/{email}")
    public boolean existeEmail(@PathVariable("email") String email){
        return userService.existeEmail(email);
    }
}
