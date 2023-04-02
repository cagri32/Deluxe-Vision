package com.backend.deluxevision.controller;

import com.backend.deluxevision.model.User;
import com.backend.deluxevision.service.UserService;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> user = userService.getAllUsers();
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<User> getUserByUserName(@PathVariable("id") String userName) throws ChangeSetPersister.NotFoundException {
        User user = userService.getUserByUserName(userName);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        User newUser = userService.addUser(user);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        userService.updateUser(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }
/*
	@PutMapping("/update/{id}")
	public ResponseEntity<User> updateUser(@RequestBody User user, Long id) throws NotFoundException {
		User newUser = userService.updateUser(user, id);
		return new ResponseEntity<>(newUser, HttpStatus.OK);
	}
*/

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") String userName) {
        userService.deleteUserByUserName(userName);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
