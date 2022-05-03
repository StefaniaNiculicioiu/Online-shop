package ro.sd.a2.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import ro.sd.a2.dto.ClientTableRowDTO;
import ro.sd.a2.service.AdminService;
import ro.sd.a2.service.ClientService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/admin")
public class AdminController {

    private static final Logger log = LoggerFactory.getLogger(AdminController.class);
    private final AdminService adminService;
    private final ClientService clientService;

    @Autowired
    public AdminController(AdminService adminService, ClientService clientService) {
        this.adminService = adminService;
        this.clientService = clientService;
    }

    /**
     * Method for retrieving all users from db as DTOs to be displayed in front-end component
     * @return ModelAndView object that returns Users.html template
     */
    @GetMapping("/allUsers")
    public ModelAndView getAllUsers() {
        List<ClientTableRowDTO> clientTableRowDTOList = clientService.findAll();
        ModelAndView mav = new ModelAndView();
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("clientsTableData", clientTableRowDTOList);
        mav.addAllObjects(model);
        mav.setViewName("Users");
        return mav;
    }

    /**
     * @return the Business management page for the admin.
     */
    @GetMapping("/business")
    public ModelAndView manageReports() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("Business");
        return mav;
    }

    /**
     * @return the administrative home page for the admin.
     */
    @GetMapping("/home")
    public ModelAndView getHomePage() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("Home");
        return mav;
    }

    @GetMapping("/viewOrders")
    public ModelAndView getOrdersView() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("Orders");
        return mav;
    }
}
