package communal.pay.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "price")
public class Price {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    @Column(name = "gas_price")
    private Long gasPrice;
    @Column(name = "water_price")
    private Long waterPrice;
    @Column(name = "electr_price")
    private Long electrPrice;
    private String date;

}
