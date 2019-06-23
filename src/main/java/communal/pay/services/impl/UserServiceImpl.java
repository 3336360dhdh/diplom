package communal.pay.services.impl;

import communal.pay.dtos.UserDto;
import communal.pay.entities.Communal;
import communal.pay.entities.User;
import communal.pay.enums.BuntType;
import communal.pay.enums.CommunalType;
import communal.pay.repositories.CommunalRepository;
import communal.pay.repositories.UserRepository;
import communal.pay.services.UserService;
import org.hashids.Hashids;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private CommunalRepository communalRepository;
    private Hashids hashids;

    public UserServiceImpl(UserRepository userRepository, CommunalRepository communalRepository, Hashids hashids) {
        this.userRepository = userRepository;
        this.communalRepository = communalRepository;
        this.hashids = hashids;
    }

    @Override
    public User createUser(UserDto user) {


        User newUser = new User();
        newUser.setFullName(user.getFullName());
        newUser.setAddress(user.getAddress());
        newUser.setPassword(user.getPassword());
        newUser.setPhone(user.getPhone());
        User newUser2 = userRepository.save(newUser);
        String code = hashids.encode(newUser2.getId());
        newUser2.setCode(code);
        Communal gas = createCommunal(user.getGas(), CommunalType.GAZ, newUser2);
        Communal eE = createCommunal(user.getElectr(), CommunalType.E_E, newUser2);
        Communal water = createCommunal(user.getWater(), CommunalType.SUV, newUser2);

        newUser2.setGas_id(gas.getId());
        newUser2.setElectr_id(eE.getId());
        newUser2.setWater_id(water.getId());
        return userRepository.save(newUser2);


    }

    private Communal createCommunal(String serial, CommunalType type, User user) {
        Communal communal = new Communal();
        communal.setSerialNumber(serial);
        communal.setType(type);
        if (type.name().equals(CommunalType.E_E.name()))
            communal.setBuntType(BuntType.KW);
        else
            communal.setBuntType(BuntType.KUB);

        Communal comm = communalRepository.save(communal);
        String code = hashids.encode(comm.getId());
        comm.setCode(code);
        return communalRepository.save(comm);
    }

    @Override
    public User getUser(String phone, String password) {
        return userRepository.findByPhoneAndPassword(phone, password);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
