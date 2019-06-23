package communal.pay.services;


import communal.pay.dtos.CommunalInfoDto;
import communal.pay.entities.Communal;

import java.util.ArrayList;
import java.util.List;

public interface CommunalService {
    public Communal getCommunal(Long id);

    public Communal getCommunal(String code);

    ArrayList<CommunalInfoDto> getInfoList(String code);


}
