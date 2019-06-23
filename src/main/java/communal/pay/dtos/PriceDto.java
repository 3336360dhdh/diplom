package communal.pay.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PriceDto {


    private Long gasPrice;
    private Long waterPrice;
    private Long electrPrice;


}
