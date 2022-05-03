package ro.sd.a2.controller;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ro.sd.a2.entity.Client;
import ro.sd.a2.service.ClientService;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(path = "/clients")
public class ClientController {

    Logger log = LoggerFactory.getLogger(ClientController.class);

    @Autowired
    ClientService clientService;

    /**
     * Method to get a client by his id.
     * @param id path variable that is to get an object from the db identified with that id.
     * @return the client with the specified id
     */
    @GetMapping(value = "/{id}")
    public Optional<Client> getUser(@PathVariable String id) {
        return clientService.get(id);
    }

    /**
     * Method to update a client from the db
     * @param client object containing the client information
     * @param id path variable that is to get an object from the db identified with that id.
     */
    @PutMapping(value = "/{id}")
    public void updateUser(@RequestBody Client client, @PathVariable String id) {
        clientService.update(id, client);
    }

    /**
     * Method to delete a client by his id from the db
     * @param id path variable that is to get an object from the db identified with that id.
     */
    @DeleteMapping(value = "/{id}")
    public void deleteUser(@PathVariable String id) {
        clientService.delete(id);
    }

    @GetMapping("/home-page")
    public ModelAndView getClientHomePage() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("Home-page");
        return mav;
    }

    @GetMapping("/viewMenu")
    public ModelAndView getMenuView() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("Menu");
        return mav;
    }

    @GetMapping("/viewCart")
    public ModelAndView getCartView() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("Cart");
        return mav;
    }

}
