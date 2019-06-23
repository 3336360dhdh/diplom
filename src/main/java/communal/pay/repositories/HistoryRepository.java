package communal.pay.repositories;

import communal.pay.entities.History;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HistoryRepository extends CrudRepository<History, Long> {

    List<History> findAllByCommunalId(Long id);

    History findByCode(String code);
}
