package Retos_Ciclo44.crud;

import Retos_Ciclo44.model.Laptop;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LaptopInterface extends MongoRepository <Laptop, Integer> {

}
