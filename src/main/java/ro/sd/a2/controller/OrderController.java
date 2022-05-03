package ro.sd.a2.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ro.sd.a2.entity.Order;
import ro.sd.a2.service.OrderService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/orders")
public class OrderController {

    Logger log = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    public OrderService orderService;

    /**
     * Method that gets all the orders from the db
     * @return a list with the orders from the db
     */
    @GetMapping(value = "/")
    public List<Order> getAll() {
        return orderService.getAll();
    }

    /**
     * Method to get an order by its id.
     * @param id path variable that is to get an object from the db identified with that id.
     * @return an order type of object
     */
    @GetMapping(value = "/{id}")
    public Optional<Order> get(@PathVariable String id) {
        return orderService.get(id);
    }

    /**
     * Method to add a new order in the db.
     * @param order object containing the order information
     */
    @PostMapping(value = "/")
    public void addOrder(@RequestBody Order order) {
        orderService.create(order);
    }

    /**
     * Method to update an order from the db
     * @param order object containing the order information
     * @param id path variable that is to get an object from the db identified with that id.
     */
    @PatchMapping(value = "/{id}")
    public void updateOrder(@RequestBody Order order, @PathVariable String id) {
        orderService.update(id, order);
    }

    /**
     * Method for deleting an order by its id from the db
     * @param id path variable that is to get an object from the db identified with that id.
     */
    @DeleteMapping(value = "/{id}")
    public void deleteOrder(@PathVariable String id) {
        orderService.delete(id);
    }

}
