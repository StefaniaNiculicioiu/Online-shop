package ro.sd.a2.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ro.sd.a2.dto.ClientCreationDTO;
import ro.sd.a2.service.ClientService;

@Controller
@RequestMapping(path = "/registration")
public class RegisterController {

    private static final Logger log = LoggerFactory.getLogger(RegisterController.class);
    private final ClientService clientService;

    @Autowired
    public RegisterController(ClientService clientService) {
        this.clientService = clientService;
    }

    /**
     * Post method to process the registration of a new user
     * @param clientCreationDTO object containing product information from frontend form input fields
     * @return ModelAndView object that returns Register.html template
     */
    @RequestMapping(value = "/process_register", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView processRegister(ClientCreationDTO clientCreationDTO) {
        clientService.insertClient(clientCreationDTO);
        ModelAndView mav = new ModelAndView();
        mav.setViewName("Register");
        return mav;
    }

    /**

     * @return the Register.html page
     */
    @GetMapping("/register")
    public ModelAndView registerPage() {

        ModelAndView mav = new ModelAndView();
        mav.setViewName("Register");
        return mav;
    }

    /**
     * @param clientCreationDTO object containing product information from frontend form input fields
     * @return string and a status that shows if the registration of the new user went well.
     */
    @PostMapping(value = "/register")
    public ResponseEntity<String> register(@RequestBody ClientCreationDTO clientCreationDTO) {
        clientService.insertClient(clientCreationDTO);
        return new ResponseEntity<String>("Client registered successfully", HttpStatus.OK);
    }
}