
package co.edu.arboleda.sergio.ciclo4.service;

import co.edu.arboleda.sergio.ciclo4.model.Peripheral;
import co.edu.arboleda.sergio.ciclo4.repository.PeripheralRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

/**
 * Clase Crea el PeripheralService
 * @since 11-12-2021
 * @version 1.0
 * @author Grupo 4 subgrupo 2
 */
@Service
public class PeripheralService {
    @Autowired
    private PeripheralRepository clotheRepository;
    
    @Autowired
    private MongoTemplate mongoTemplate;

    public List<Peripheral> getAll() {
        return clotheRepository.getAll();
    }

    public Optional<Peripheral> getClothe(String reference) {
        return clotheRepository.getClothe(reference);
    }

    public Peripheral create(Peripheral peripheral) {
        if (peripheral.getReference() == null) {
            return peripheral;
        } else {
            return clotheRepository.create(peripheral);
        }
    }

    public Peripheral update(Peripheral peripheral) {

        if (peripheral.getReference() != null) {
            Optional<Peripheral> peripheralDb = clotheRepository.getClothe(peripheral.getReference());
            if (!peripheralDb.isEmpty()) {
                
                if (peripheral.getBrand()!= null) {
                    peripheralDb.get().setBrand(peripheral.getBrand());
                }
                
                if (peripheral.getCategory() != null) {
                    peripheralDb.get().setCategory(peripheral.getCategory());
                }
                
                if (peripheral.getDescription() != null) {
                    peripheralDb.get().setDescription(peripheral.getDescription());
                }
                if (peripheral.getPrice() != 0.0) {
                    peripheralDb.get().setPrice(peripheral.getPrice());
                }
                if (peripheral.getQuantity() != 0) {
                    peripheralDb.get().setQuantity(peripheral.getQuantity());
                }
                if (peripheral.getPhotography() != null) {
                    peripheralDb.get().setPhotography(peripheral.getPhotography());
                }
                peripheralDb.get().setAvailability(peripheral.isAvailability());
                clotheRepository.update(peripheralDb.get());
                return peripheralDb.get();
            } else {
                return peripheral;
            }
        } else {
            return peripheral;
        }
    }

    public boolean delete(String reference) {
        Boolean aBoolean = getClothe(reference).map(accesory -> {
            clotheRepository.delete(accesory);
            return true;
        }).orElse(false);
        return aBoolean;
    }    
}
