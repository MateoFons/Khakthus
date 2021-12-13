package Retos_Ciclo4.Retos_Ciclo4.repository;

import Retos_Ciclo4.Retos_Ciclo4.crud.OrderInterface;
import Retos_Ciclo4.Retos_Ciclo4.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Clase Crea el repositorio OrderRepository
 * @since 11-12-2021
 * @version 1.0
 * @author Grupo 4 subgrupo 2
 */
@Repository
public class OrderRepository {
    
    @Autowired
    private OrderInterface orderInterface;

    public List<Order> getAll() {
        return (List<Order>) orderInterface.findAll();
    }

    public Optional<Order> getOrder(int id) {
        return orderInterface.findById(id);
    }

    public Order create(Order order) {
        return orderInterface.save(order);
    }

    public void update(Order order) {
        orderInterface.save(order);
    }

    public void delete(Order order) {
        orderInterface.delete(order);
    }
    
    public Optional<Order> lastUserId(){
        return orderInterface.findTopByOrderByIdDesc();
    }
    
    public List<Order> findByZone(String zona) {
        return orderInterface.findByZone(zona);
    }
    
}
