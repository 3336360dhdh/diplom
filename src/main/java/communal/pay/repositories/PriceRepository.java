package communal.pay.repositories;

import communal.pay.entities.Price;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PriceRepository extends CrudRepository<Price, Long> {
List<Price> findAll();

}
