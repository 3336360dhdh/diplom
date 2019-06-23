package communal.pay.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {

    public String code;
    public String fullName;
    public String phone;
    public String address;
    public String password;
    public String gas;
    public String water;
    public String electr;


}
