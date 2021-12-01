package Retos_Ciclo4.Retos_Ciclo4.controller;

import Retos_Ciclo4.Retos_Ciclo4.model.Peripheral;
import Retos_Ciclo4.Retos_Ciclo4.service.PeripheralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/peripheral")
@CrossOrigin("*")
public class PeripheralController {
    @Autowired
    private PeripheralService peripheralService;

    @GetMapping("/all")
    public List<Peripheral> getAll() {
        return peripheralService.getAll();
    }

    @GetMapping("/{reference}")
    public Optional<Peripheral> getPeripheral(@PathVariable("reference") String reference) {
        return peripheralService.getPeripheral(reference);
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

    @DeleteMapping("/all")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAll() {
        peripheralService.deleteAll();
    }
}