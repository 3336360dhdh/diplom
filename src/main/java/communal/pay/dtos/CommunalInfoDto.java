package communal.pay.dtos;

import communal.pay.enums.BuntType;
import communal.pay.enums.CommunalType;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
@Getter
@Setter
public class CommunalInfoDto implements Serializable {
    public CommunalInfoDto(String serialNumber, Long sum) {
        this.serialNumber = serialNumber;
        this.sum = sum;
    }

    private String serialNumber;
    private Long sum;
}
