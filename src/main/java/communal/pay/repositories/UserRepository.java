package communal.pay.repositories;

import communal.pay.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    User findByPhoneAndPassword(String phone, String password);

    List<User> findAll();
    User findByCode(String code);
}
