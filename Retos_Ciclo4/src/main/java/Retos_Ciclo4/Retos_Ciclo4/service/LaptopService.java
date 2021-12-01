package Retos_Ciclo4.Retos_Ciclo4.service;

import Retos_Ciclo4.Retos_Ciclo4.model.Laptop;
import Retos_Ciclo4.Retos_Ciclo4.repository.LaptopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LaptopService {
    @Autowired
    private LaptopRepository laptopRepositoryUwU;

    public List<Laptop> getAll() {
        return laptopRepositoryUwU.getAll();
    }

    public Optional<Laptop> getLaptop(Integer id) {
        return laptopRepositoryUwU.getLaptop(id);
    }

    public Laptop create(Laptop laptop) {
        if (laptop.getId() == null) {
            return laptop;
        } else {
            return laptopRepositoryUwU.create(laptop);
        }
    }

    public Laptop update(Laptop laptop) {
        if (laptop.getId() != null) {
            Optional<Laptop> laptopDb = laptopRepositoryUwU.getLaptop(laptop.getId());
            if (!laptopDb.isEmpty()) {
                if (laptop.getBrand() != null) {
                    laptopDb.get().setBrand(laptop.getBrand());
                }
                if (laptop.getModel() != null) {
                    laptopDb.get().setModel(laptop.getModel());
                }
                if (laptop.getProcesor() != null) {
                    laptopDb.get().setProcesor(laptop.getProcesor());
                }
                if (laptop.getOs() != null) {
                    laptopDb.get().setOs(laptop.getOs());
                }
                if (laptop.getDescription() != null) {
                    laptopDb.get().setDescription(laptop.getDescription());
                }
                if (laptop.getMemory() != null) {
                    laptopDb.get().setMemory(laptop.getMemory());
                }
                if (laptop.getHardDrive() != null) {
                    laptopDb.get().setHardDrive(laptop.getHardDrive());
                }
                if (laptop.getPrice() != 0.0) {
                    laptopDb.get().setPrice(laptop.getPrice());
                }
                if (laptop.getQuantity() != 0) {
                    laptopDb.get().setQuantity(laptop.getQuantity());
                }
                if (laptop.getPhotography() != null) {
                    laptopDb.get().setPhotography(laptop.getPhotography());
                }
                laptopDb.get().setAvailability(laptop.isAvailability());
                laptopRepositoryUwU.update(laptopDb.get());
                return laptopDb.get();
            } else {
                return laptop;
            }
        } else {
            return laptop;
        }
    }

    public boolean delete(Integer id) {
        Boolean aBoolean = getLaptop(id).map(lap -> {
            laptopRepositoryUwU.delete(lap);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
