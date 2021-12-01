package Retos_Ciclo4.Retos_Ciclo4.crud;

import Retos_Ciclo4.Retos_Ciclo4.model.Laptop;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LaptopInterface extends MongoRepository <Laptop, Integer> {

}
