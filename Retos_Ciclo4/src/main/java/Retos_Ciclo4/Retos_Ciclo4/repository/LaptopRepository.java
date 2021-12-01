package Retos_Ciclo44.repository;

import Retos_Ciclo44.crud.LaptopInterface;
import Retos_Ciclo44.model.Laptop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class LaptopRepository {
    @Autowired
    private LaptopInterface laptopInterface;

    public List<Laptop> getAll() {
        return laptopInterface.findAll();
    }

    public Optional<Laptop> getLaptop(Integer id) {
        return laptopInterface.findById(id);
    }

    public Laptop create(Laptop laptop) {
        return laptopInterface.save(laptop);
    }

    public void update(Laptop laptop) {
        laptopInterface.save(laptop);
    }

    public void delete(Laptop laptop) {
        laptopInterface.delete(laptop);
    }
}