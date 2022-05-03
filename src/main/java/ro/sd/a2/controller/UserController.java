package ro.sd.a2.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ro.sd.a2.entity.User;
import ro.sd.a2.service.UserService;

import java.util.List;
import java.util.Optional;

@RestController
//@RequestMapping(path = "/user")
public class UserController {

    //private static final Logger log = LoggerFactory.getLogger(UserController.class);

 /*   @Autowired
    private UserService userService;

        @RequestMapping(value = "/users")
        public List<User> getAllUsers() {
            return userService.getAllUsers();
        }

        @RequestMapping(value = "/users/{id}")
        public Optional<User> getUser(@PathVariable String id) {
            return userService.getUser(id);
        }

        @RequestMapping(value = "/users", method = RequestMethod.POST)
        public void addUser(@RequestBody User user) {
            userService.create(user);
        }

        @RequestMapping(value = "/users/{id}", method = RequestMethod.PUT)
        public void updateUser(@RequestBody User user, @PathVariable String id) {
            userService.update(id, user);
        }

        @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
        public void deleteUser(@PathVariable String id) {
            userService.delete(id);
        }*/
}
