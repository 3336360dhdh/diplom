package communal.pay.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    @Column(name = "full_name")
    private String fullName;
    private String phone;
    private String address;
    private String password;
    private Long gas_id;

    private Long water_id;

    private Long electr_id;


}
