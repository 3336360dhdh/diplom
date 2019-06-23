package communal.pay.repositories;

import communal.pay.entities.Communal;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommunalRepository extends CrudRepository<Communal, Long> {
    Communal getByCode(String code);


}
