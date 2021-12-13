package Retos_Ciclo4.Retos_Ciclo4.repository;


import Retos_Ciclo4.Retos_Ciclo4.crud.OrderInterface;
import Retos_Ciclo4.Retos_Ciclo4.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


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

    //Ordenes de pedido asociadas a los asesores de una zona
    public List<Order> findByZone(String zona) {
        return orderInterface.findByZone(zona);
    }

}
