package Retos_Ciclo4.Retos_Ciclo4.crud;

import Retos_Ciclo4.Retos_Ciclo4.model.Laptop;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface LaptopInterface extends MongoRepository <Laptop, Integer> {
    public List<Laptop> findByPrice(double price);
    public List<Laptop> findByDescriptionContainingIgnoreCase(String description);
}
