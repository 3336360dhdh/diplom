package communal.pay.services.impl;

import communal.pay.dtos.PayDto;
import communal.pay.entities.Communal;
import communal.pay.entities.History;
import communal.pay.entities.Price;
import communal.pay.enums.CommunalType;
import communal.pay.repositories.HistoryRepository;
import communal.pay.services.CommunalService;
import communal.pay.services.PayService;
import communal.pay.services.PriceService;
import org.hashids.Hashids;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class PayServiceImpl implements PayService {
    private HistoryRepository repository;
    private EntityManager entityManager;
    private CommunalService communalService;
    private PriceService priceService;
    private Hashids hashids;

    public PayServiceImpl(HistoryRepository repository, EntityManager entityManager, CommunalService communalService, PriceService priceService, Hashids hashids) {
        this.repository = repository;
        this.entityManager = entityManager;
        this.communalService = communalService;
        this.priceService = priceService;
        this.hashids = hashids;
    }

    @Override
    public History create(PayDto dto) {
        History history = new History();
        history.setSumPrice(dto.getSumPrice());
        history.setCommunalId(dto.getId());
        Communal communal = communalService.getCommunal(dto.getId());
        DateFormat dateFormat = new SimpleDateFormat("HH:mm dd-MM-yyyy");
        Date date = new Date();
        history.setDate(dateFormat.format(date));
        Long price = getPrice(communal.getType());
        Long bunt = (long) dto.getSumPrice() / price;
        history.setBunt(bunt);
        History histNew = repository.save(history);
        histNew.setCode(hashids.encode(histNew.getId()));
        return repository.save(histNew);
    }

    private Long getPrice(CommunalType type) {
        Price price = priceService.getPriceLast();
        switch (type) {

            case E_E:
                return price.getElectrPrice();

            case GAZ:
                return price.getGasPrice();
            case SUV:
                return price.getWaterPrice();

        }
        return price.getElectrPrice();
    }

    @Override
    public History getOneHistory(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public List<History> getList(Long id) {
        return repository.findAllByCommunalId(id);
    }
}
