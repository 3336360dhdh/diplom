package communal.pay.controllers;

import communal.pay.dtos.PriceDto;
import communal.pay.entities.Price;
import communal.pay.services.PriceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("price")
public class PriceController {
    private PriceService priceService;


    public PriceController(PriceService priceService) {
        this.priceService = priceService;
    }


    @GetMapping
    private Price getPrice(Long id) {
        return priceService.getPrice(id);
    }


    @GetMapping("current")
    private Price getCurrent() {
        return priceService.getPriceLast();
    }

    @GetMapping("all")
    private List<Price> getAllPrice() {
        return priceService.getPriceList();
    }

    @PostMapping
    private Price createPrice(@RequestBody  PriceDto dto) {
        return priceService.create(dto);

    }
}
