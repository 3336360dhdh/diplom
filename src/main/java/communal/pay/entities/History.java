package communal.pay.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "history")
public class History {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private String date;
    @Column(name = "sum_price")
    private Long sumPrice;
    private Long bunt;
    @Column(name = "communal_id")
    private Long communalId;
}
