package Retos_Ciclo4.Retos_Ciclo4.crud;

import Retos_Ciclo4.Retos_Ciclo4.model.Peripheral;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PeripheralInterface extends MongoRepository <Peripheral, String> {

}
