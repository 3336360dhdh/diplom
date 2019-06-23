package communal.pay.services.impl;

import communal.pay.dtos.PriceDto;
import communal.pay.entities.Price;
import communal.pay.repositories.PriceRepository;
import communal.pay.services.PriceService;
import org.hashids.Hashids;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class PriceServiceImpl implements PriceService {
    private PriceRepository priceRepository;
    private Hashids hashids;

    public PriceServiceImpl(PriceRepository priceRepository, Hashids hashids) {
        this.priceRepository = priceRepository;
        this.hashids = hashids;
    }

    @Override
    public Price create(PriceDto dto) {
        Price price = new Price();
        DateFormat dateFormat = new SimpleDateFormat("HH:mm dd-MM-yyyy");
        Date date = new Date();
        price.setDate(dateFormat.format(date));
        price.setElectrPrice(dto.getElectrPrice());
        price.setGasPrice(dto.getGasPrice());
        price.setWaterPrice(dto.getWaterPrice());
        Price priceNew = priceRepository.save(price);
        priceNew.setCode(hashids.encode(priceNew.getId()));
        return priceRepository.save(priceNew);
    }

    @Override
    public Price getPriceLast() {
        List<Price> prices = priceRepository.findAll();
        return prices.get(prices.size() - 1);
    }

    @Override
    public Price getPrice(Long id) {
        return priceRepository.findById(id).get();
    }

    @Override
    public List<Price> getPriceList() {
        return priceRepository.findAll();
    }
}
