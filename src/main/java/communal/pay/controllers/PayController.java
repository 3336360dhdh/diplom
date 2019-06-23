package communal.pay.controllers;

import communal.pay.dtos.PayDto;
import communal.pay.entities.History;
import communal.pay.services.PayService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("pay")
public class PayController {
    private PayService payService;

    public PayController(PayService payService) {
        this.payService = payService;
    }

    @GetMapping
    private History getHistory(@RequestParam Long id) {
        return payService.getOneHistory(id);
    }

    @GetMapping("list")
    private List<History> getListHistory(@RequestParam Long communalId) {
        return payService.getList(communalId);
    }

    @PostMapping
    private History createPay(@RequestBody PayDto dto) {
        return payService.create(dto);
    }

}
