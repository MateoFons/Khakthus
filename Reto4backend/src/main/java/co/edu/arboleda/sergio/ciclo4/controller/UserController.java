
package co.edu.arboleda.sergio.ciclo4.controller;

import co.edu.arboleda.sergio.ciclo4.model.User;
import co.edu.arboleda.sergio.ciclo4.service.UserService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * Clase UserController metodos GET, POST, PUT, DELETE
 * @since 11-12-2021
 * @version 1.0
 * @author Grupo 4 subgrupo 2
 */
@RestController
@RequestMapping("/api/user")
@CrossOrigin("*")
public class UserController {
    
    /**
     * Permite inyectar unas dependencias con otras
     */
    @Autowired
    private UserService userService;
    
    /**
     * Obtiene el contenido que tiene
     * la tabla User en Mongo
     */
    @GetMapping("/all")
    public List<User> getAll() {
        return userService.getAll();
    }
    
    /**
     * Obtiene el contenido que tiene
     * la tabla User en Mongo utilizando el ID
     */    
    @GetMapping("/{id}")
    public Optional <User> getUser(@PathVariable("id") int id) {
        return userService.getUser(id);
    }
    
    /**
     * Envia el json creando un nuevo usuario
     * en la tabla User en Mongo
     */
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public User create(@RequestBody User user) {
        return userService.create(user);
    }
    
    /**
     * Modifica los datos de un usuario ya creado
     * en la tabla User en Mongo
     */
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public User update(@RequestBody User user) {
        return userService.update(user);
    }
    
    /**
     * Elimina los datos de un usuario que se encuentra
     * en la tabla User en Mongo
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id) {
        return userService.delete(id);
    }
    
    /**
     * Verifica si existe el email y password
     * en la tabla User en Mongo
     */
    @GetMapping("/{email}/{password}")
    public User authenticateUser(@PathVariable("email") String email, @PathVariable("password") String password) {
        return userService.authenticateUser(email, password);
    }
    
    /**
     * Verifica si existe el email
     * en la tabla User en Mongo
     */
    @GetMapping("/emailexist/{email}")
    public boolean emailExists(@PathVariable("email") String email) {
        return userService.emailExists(email);
    }
    
}
