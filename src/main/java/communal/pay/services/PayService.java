package communal.pay.services;

import communal.pay.dtos.PayDto;
import communal.pay.entities.History;

import java.util.List;

public interface PayService {

    History create(PayDto dto);

    History getOneHistory(Long id);

    List<History> getList(Long id);
}
