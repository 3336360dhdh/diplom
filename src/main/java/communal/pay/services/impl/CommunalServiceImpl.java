package communal.pay.services.impl;

import communal.pay.dtos.CommunalInfoDto;
import communal.pay.entities.Communal;
import communal.pay.entities.Price;
import communal.pay.entities.User;
import communal.pay.repositories.CommunalRepository;
import communal.pay.repositories.PriceRepository;
import communal.pay.repositories.UserRepository;
import communal.pay.services.CommunalService;
import org.hashids.Hashids;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommunalServiceImpl implements CommunalService {
    private CommunalRepository communalRepository;
    private UserRepository userRepository;
    private Hashids hashids;
    private PriceRepository priceRepository;

    public CommunalServiceImpl(CommunalRepository communalRepository, UserRepository userRepository, Hashids hashids, PriceRepository priceRepository) {
        this.communalRepository = communalRepository;
        this.userRepository = userRepository;
        this.hashids = hashids;
        this.priceRepository = priceRepository;
    }

    @Override
    public Communal getCommunal(Long id) {
        return communalRepository.findById(id).get();
    }

    @Override
    public Communal getCommunal(String code) {
        return communalRepository.getByCode(code);
    }

    @Override
    public ArrayList<CommunalInfoDto> getInfoList(String code) {
        ArrayList<CommunalInfoDto> communalInfoDtos = new ArrayList<>();

        User user = userRepository.findByCode(code);
        List<Price> prices = priceRepository.findAll();

        Price price = prices.get(prices.size() - 1);

        Communal gaz = communalRepository.getByCode(hashids.encode(user.getGas_id()));

        communalInfoDtos.add(new CommunalInfoDto(gaz.getSerialNumber(), ((gaz.getPay() - gaz.getUnPay()) * price.getGasPrice())));

        Communal svet = communalRepository.getByCode(hashids.encode(user.getElectr_id()));
        communalInfoDtos.add(new CommunalInfoDto(svet.getSerialNumber(), ((svet.getPay() - svet.getUnPay()) * price.getElectrPrice())));

        Communal water = communalRepository.getByCode(hashids.encode(user.getWater_id()));
        communalInfoDtos.add(new CommunalInfoDto(water.getSerialNumber(), ((water.getPay() - water.getUnPay()) * price.getWaterPrice())));
        return communalInfoDtos;
    }


}
