package Retos_Ciclo4.Retos_Ciclo4.service;

import Retos_Ciclo4.Retos_Ciclo4.model.Peripheral;
import Retos_Ciclo4.Retos_Ciclo4.repository.PeripheralRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PeripheralService {
    @Autowired
    private PeripheralRepository peripheralRepository;

    public List<Peripheral> getAll() {
        return peripheralRepository.getAll();
    }

    public Optional<Peripheral> getPeripheral(String reference) {
        return peripheralRepository.getPeripheral(reference);
    }

    public Peripheral create(Peripheral peripheral) {
        if (peripheral.getReference() == null) {
            return peripheral;
        } else {
            return peripheralRepository.create(peripheral);
        }
    }

    public Peripheral update(Peripheral peripheral) {
        if (peripheral.getReference() != null) {
            Optional<Peripheral> PeripheralDb = peripheralRepository.getPeripheral(peripheral.getReference());
            if (!PeripheralDb.isEmpty()) {
                if (peripheral.getBrand() != null) {
                    PeripheralDb.get().setBrand(peripheral.getBrand());
                }
                if (peripheral.getCategory() != null) {
                    PeripheralDb.get().setCategory(peripheral.getCategory());
                }
                if (peripheral.getDescription() != null) {
                    PeripheralDb.get().setDescription(peripheral.getDescription());
                }
                if (peripheral.getPrice() != 0.0) {
                    PeripheralDb.get().setPrice(peripheral.getPrice());
                }
                if (peripheral.getQuantity() != 0) {
                    PeripheralDb.get().setQuantity(peripheral.getQuantity());
                }
                if (peripheral.getPhotography() != null) {
                    PeripheralDb.get().setPhotography(peripheral.getPhotography());
                }
                PeripheralDb.get().setAvailability(peripheral.isAvailability());
                peripheralRepository.update(PeripheralDb.get());
                return PeripheralDb.get();
            } else {
                return peripheral;
            }
        } else {
            return peripheral;
        }
    }

    public boolean delete(String reference) {
        Boolean aBoolean = getPeripheral(reference).map(lap -> {
            peripheralRepository.delete(lap);
            return true;
        }).orElse(false);
        return aBoolean;
    }

    public void deleteAll() {
        peripheralRepository.deleteAll();
    }
}