package communal.pay.controllers;

import communal.pay.dtos.UserDto;
import communal.pay.entities.User;
import communal.pay.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("user")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("all-users")
    private ArrayList<User> getAllUsers() {

        return new ArrayList<>(userService.getAllUsers());
    }

    @GetMapping
    private ResponseEntity<User> getUser(@RequestParam String phone, @RequestParam String password) {

        User user = userService.getUser(phone, password);
        if (user != null) return new ResponseEntity<>(user, HttpStatus.OK);
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

    @PostMapping
    private void createUser(@RequestBody UserDto user) {
        userService.createUser(user);

    }

}
