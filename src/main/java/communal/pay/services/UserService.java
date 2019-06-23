package communal.pay.services;

import communal.pay.dtos.UserDto;
import communal.pay.entities.User;

import java.util.List;

public interface UserService {
    User createUser(UserDto user);

    User getUser(String phone, String password);
    List<User> getAllUsers();
}
