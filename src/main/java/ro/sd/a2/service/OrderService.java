package ro.sd.a2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.sd.a2.entity.Order;
import ro.sd.a2.repository.OrderRepository;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    /**
     * Method to get a list of all orders from the db
     * @return a list with all the orders from our database.
     */
    public List<Order> getAll() {
        return (List<Order>) orderRepository.findAll();
    }

    /**
     * Method to get an order by its id.
     * @param id keeps the auto-generated id that is assigned to each order individually. With it we determine which order we choose.
     * @return the client with the specified id
     */
    public Optional<Order> get(String id){
        return orderRepository.findById(id);
    }

    /**
     * Method to create a new order in the db.
     * @param order object containing the order information
     */
    public void create(Order order){
        orderRepository.save(order);
    }

    /**
     * Method to update an order from the db
     * @param id keeps the auto-generated id that is assigned to each order individually. With it we determine which order we choose to update.
     * @param order object containing the order information
     */
    public void update(String id, Order order){
        orderRepository.save(order);
    }

    /**
     * Method for deleting an order by its id from the db
     * @param id keeps the auto-generated id that is assigned to each order individually. With it we determine which order we choose to delete.
     */
    public void delete(String id){
        orderRepository.deleteById(id);
    }
}
