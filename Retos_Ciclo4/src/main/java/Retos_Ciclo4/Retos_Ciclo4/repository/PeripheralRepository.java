package Retos_Ciclo4.Retos_Ciclo4.repository;

import Retos_Ciclo4.Retos_Ciclo4.crud.PeripheralInterface;
import Retos_Ciclo4.Retos_Ciclo4.model.Peripheral;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PeripheralRepository {
    @Autowired
    private PeripheralInterface peripheralInterface;

    public List<Peripheral> getAll() {
        return peripheralInterface.findAll();
    }

    public Optional<Peripheral> getPeripheral(String reference) {
        return peripheralInterface.findById(reference);
    }

    public Peripheral create(Peripheral peripheral) {
        return peripheralInterface.save(peripheral);
    }

    public void update(Peripheral peripheral) {
        peripheralInterface.save(peripheral);
    }

    public void delete(Peripheral peripheral) {
        peripheralInterface.delete(peripheral);
    }

    public void deleteAll() {
        peripheralInterface.deleteAll();
    }
}