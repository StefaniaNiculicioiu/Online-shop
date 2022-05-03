package ro.sd.a2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.sd.a2.entity.User;
import ro.sd.a2.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    /**
     * Method to get a list of all users from the db
     * @return a list with all the users from our database.
     */
    public List<User> getAllUsers() {
        return (List<User>) userRepository.findAll();
    }

    /**
     * Method to get an user by his id.
     * @param id keeps the auto-generated id that is assigned to each client individually. With it we determine which client we choose.
     * @return the order with the specified id
     */
    public Optional<User> getUser(String id){
        return userRepository.findById(id);
    }

    /**
     * Method to create a new user in the db.
     * @param user object containing the user information
     */
    public void create(User user){
        userRepository.save(user);
    }

    /**
     * Method to update an user from the db
     * @param id keeps the auto-generated id that is assigned to each user individually. With it we determine which user we choose to update.
     * @param user object containing the user information
     */
    public void update(String id, User user){
        userRepository.save(user);
    }

    /**
     * Method for deleting an user by its id from the db
     * @param id keeps the auto-generated id that is assigned to each user individually. With it we determine which user we choose to delete.
     */
    public void delete(String id){
        userRepository.deleteById(id);
    }
}
