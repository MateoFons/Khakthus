
package co.edu.arboleda.sergio.ciclo4.interfaces;

import co.edu.arboleda.sergio.ciclo4.model.Peripheral;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Crea el repositorio InterfacePeripheral
 * @since 11-12-2021
 * @version 1.0
 * @author Grupo 4 subgrupo 2
 */
public interface InterfacePeripheral extends MongoRepository<Peripheral, String>  {
    
}
