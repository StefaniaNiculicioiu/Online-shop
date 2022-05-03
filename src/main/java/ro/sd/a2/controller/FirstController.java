package ro.sd.a2.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import ro.sd.a2.entity.User;
import ro.sd.a2.service.UserService;
import ro.sd.a2.utils.UserRole;

import java.util.UUID;


@Controller
public class FirstController {

    private static final Logger log = LoggerFactory.getLogger(FirstController.class);

    private UserService userService = new UserService();

    @GetMapping("/profile")
    public ModelAndView showProfile() {
        //validation if needed
        //shall we log a little?
        ModelAndView mav = new ModelAndView();

        User user = new User(UUID.randomUUID().toString(),"Bubu","Bu","buu","buu","buu","000", UserRole.ROLE_CLIENT);
        mav.addObject("fullUserObj", user);
        mav.addObject("numeStudent", user.getFirstName());
        // adaugi x obiecte
        mav.setViewName("profile");
        //log the final outcome: Success y?
        return mav;
    }

}
