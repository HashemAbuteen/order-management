package abuteen.hashem.ordermanagementbackend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customer_tbl")
public class Customer {
    @Id
    @GeneratedValue
    private int id;

    private String firstName;
    private String LastName;

    @Temporal(TemporalType.DATE)
    private Date bornAt;
}
