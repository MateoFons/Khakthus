package Retos_Ciclo4.Retos_Ciclo4.crud;


import Retos_Ciclo4.Retos_Ciclo4.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

/**
 * Crea el repositorio InterfaceOrder
 * @since 11-12-2021
 * @version 1.0
 * @author Grupo 4 subgrupo 2
 */
public interface OrderInterface extends MongoRepository<Order, Integer> {
    
    //Retorna las ordenes de pedido que coincidad con la zona recibida como parametro
    @Query("{'salesMan.zone': ?0}")
    List<Order> findByZone(final String zone);
    
    //Retorna las ordenes x estado
    @Query("{status: ?0}")
    List<Order> findByStatus(final String status);
    
    //Para seleccionar la orden con el id maximo
    Optional<Order> findTopByOrderByIdDesc();
    
}
