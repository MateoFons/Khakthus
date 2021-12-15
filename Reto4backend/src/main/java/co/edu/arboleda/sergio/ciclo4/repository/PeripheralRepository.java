
package co.edu.arboleda.sergio.ciclo4.repository;

import co.edu.arboleda.sergio.ciclo4.interfaces.InterfacePeripheral;
import co.edu.arboleda.sergio.ciclo4.model.Peripheral;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Clase Crea el repositorio PeripheralRepository
 * @since 11-12-2021
 * @version 1.0
 * @author Grupo 4 subgrupo 2
 */
@Repository
public class PeripheralRepository {
    @Autowired
    private InterfacePeripheral repository;

    public List<Peripheral> getAll() {
        return repository.findAll();
    }

    public Optional<Peripheral> getClothe(String reference) {
        return repository.findById(reference);
    }
    public Peripheral create(Peripheral peripheral) {
        return repository.save(peripheral);
    }

    public void update(Peripheral peripheral) {
        repository.save(peripheral);
    }
    
    public void delete(Peripheral peripheral) {
        repository.delete(peripheral);
    }    
    
}
