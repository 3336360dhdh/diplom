package communal.pay.controllers;

import communal.pay.dtos.CommunalInfoDto;
import communal.pay.entities.Communal;
import communal.pay.services.CommunalService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("communal")
public class CommunalController {
    private CommunalService communalService;

    public CommunalController(CommunalService communalService) {
        this.communalService = communalService;
    }

    @GetMapping
    private Communal getCommunal(@RequestParam Long id) {
        return communalService.getCommunal(id);

    }

    @GetMapping("/info")
    private ArrayList<CommunalInfoDto> getInfoList(@RequestParam String code) {
        return communalService.getInfoList (code);
    }

}
