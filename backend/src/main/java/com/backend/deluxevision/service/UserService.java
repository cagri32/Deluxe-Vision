package com.backend.deluxevision.service;

import com.backend.deluxevision.model.Glasses;
import com.backend.deluxevision.model.User;
import com.backend.deluxevision.repo.UserRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    private final UserRepo userRepo;

    @Autowired
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public User addUser(User user) {
        user.setUserName(user.getUserName());
        return userRepo.save(user);
    }

    public List<User> getAllUsers() {
        return userRepo.findAll();
    }


    public void updateUser(User updatedUser) {
        // find the users with the same name
        Optional<User> optionalUser = userRepo.getUserByUserName(updatedUser.getUserName());

        if (optionalUser.isPresent()) {
            // replace the old glasses with the one that comes in the parameter using set functions
            User oldUser = optionalUser.get();
            oldUser.setRole(updatedUser.getRole());
            oldUser.setEmail(updatedUser.getEmail());
            oldUser.setBillingAddress(updatedUser.getBillingAddress());
            oldUser.setMailingAddress(updatedUser.getMailingAddress());
            oldUser.setUserName(updatedUser.getUserName());

            userRepo.save(oldUser);
        }
    }

    public User getUserByUserName(String userName) throws ChangeSetPersister.NotFoundException {
        /*
         * return glassesRepo.findGlassesById(id) .orElseThrow(() -> new
         * GlassesNotFoundException("Glasses by id " + id + " was not found"));
         */
        Optional<User> userOptional = userRepo.getUserByUserName(userName);
        User user = userOptional.orElseThrow(() -> new ChangeSetPersister.NotFoundException());
        return user;

    }


    @Transactional
    public void deleteUserByUserName(String userName) {
        userRepo.deleteUserByUserName(userName);
    }

}
