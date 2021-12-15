
package co.edu.arboleda.sergio.ciclo4.controller;

import co.edu.arboleda.sergio.ciclo4.model.Peripheral;
import co.edu.arboleda.sergio.ciclo4.service.PeripheralService;
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
 * Clase PeripheralController metodos GET, POST, PUT, DELETE
 * @since 11-12-2021
 * @version 1.0
 * @author Grupo 4 subgrupo 2
 */
@RestController
@RequestMapping("/api/peripherals")
@CrossOrigin("*")
public class PeripheralController {
    
    @Autowired
    private PeripheralService peripheralService;
       
    @GetMapping("/all")
    public List<Peripheral> getAll() {
        return peripheralService.getAll();
    }
    
    @GetMapping("/{reference}")
    public Optional<Peripheral> getClothe(@PathVariable("reference") String reference) {
        return peripheralService.getClothe(reference);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Peripheral create(@RequestBody Peripheral gadget) {
        return peripheralService.create(gadget);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Peripheral update(@RequestBody Peripheral gadget) {
        return peripheralService.update(gadget);
    }

    @DeleteMapping("/{reference}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("reference") String reference) {
        return peripheralService.delete(reference);
    } 
    
}
