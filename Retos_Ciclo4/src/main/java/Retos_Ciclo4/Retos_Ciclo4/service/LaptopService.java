package Retos_Ciclo4.Retos_Ciclo4.service;

import Retos_Ciclo4.Retos_Ciclo4.model.Laptop;
import Retos_Ciclo4.Retos_Ciclo4.model.User;
import Retos_Ciclo4.Retos_Ciclo4.repository.LaptopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LaptopService {
    @Autowired
    private LaptopRepository laptopRepository;

    public List<Laptop> getAll() {
        return laptopRepository.getAll();
    }

    public Optional<Laptop> getLaptop(Integer id) {
        return laptopRepository.getLaptop(id);
    }

    public Laptop create(Laptop laptop) {
        if (laptop.getId() == null) {
            laptop.setId(findLastId());
        }
        return laptopRepository.create(laptop);
    }

    public Laptop update(Laptop laptop) {
        if (laptop.getId() != null) {
            Optional<Laptop> laptopDb = laptopRepository.getLaptop(laptop.getId());
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
                laptopRepository.update(laptopDb.get());
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
            laptopRepository.delete(lap);
            return true;
        }).orElse(false);
        return aBoolean;
    }

    public Integer findLastId() {
        List<Laptop> laptops = (List<Laptop>) laptopRepository.getAll();
        Integer lastId = 0;
        for (Laptop laptop :laptops){
            Optional<Laptop> auxiliar = laptopRepository.getLaptop(laptop.getId());
            if (lastId < auxiliar.get().getId()) {
                lastId = auxiliar.get().getId();
            }
        }
        lastId += 1;
        return lastId;
    }
}
