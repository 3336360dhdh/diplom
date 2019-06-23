package communal.pay.entities;

import communal.pay.enums.BuntType;
import communal.pay.enums.CommunalType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "communal")
public class Communal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    @Column(name = "serial_number")
    private String serialNumber;
    private Long pay = 0L;
    @Column(name = "un_pay")
    private Long unPay = 0L;
    private CommunalType type;
    @Column(name = "bunt_type")
    private BuntType buntType;

}
