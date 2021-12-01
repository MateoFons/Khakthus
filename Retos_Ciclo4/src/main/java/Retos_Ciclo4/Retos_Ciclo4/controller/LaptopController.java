package Retos_Ciclo44.controller;

import Retos_Ciclo44.model.Laptop;
import Retos_Ciclo44.service.LaptopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/laptop")
@CrossOrigin("*")
public class LaptopController {
    @Autowired
    private LaptopService laptopService;

    @GetMapping("/all")
    public List<Laptop> getAll() {
        return laptopService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Laptop> getClothe(@PathVariable("reference") Integer id) {
        return laptopService.getLaptop(id);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Laptop create(@RequestBody Laptop gadget) {
        return laptopService.create(gadget);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Laptop update(@RequestBody Laptop gadget) {
        return laptopService.update(gadget);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") Integer id) {
        return laptopService.delete(id );
    }
}
