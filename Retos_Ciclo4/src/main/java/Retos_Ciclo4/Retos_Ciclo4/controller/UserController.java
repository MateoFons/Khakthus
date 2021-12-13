package Retos_Ciclo4.Retos_Ciclo4.controller;

import Retos_Ciclo4.Retos_Ciclo4.model.User;
import Retos_Ciclo4.Retos_Ciclo4.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
