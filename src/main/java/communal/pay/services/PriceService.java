package communal.pay.services;

import communal.pay.dtos.PriceDto;
import communal.pay.entities.Price;

import java.util.List;

public interface PriceService {

    Price create(PriceDto dto);

    Price getPriceLast();

    Price getPrice(Long id);

    List<Price> getPriceList();

}
