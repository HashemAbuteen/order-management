package abuteen.hashem.ordermanagementbackend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "order_tbl")
public class Order {
    @Id
    @GeneratedValue
    private int Id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date orderedAt;

    @ManyToOne
    @JoinColumn(name = "customerId" , referencedColumnName = "id")
    private Customer customer;

    @OneToMany
    private List<ProductOrder> productOrder;
}
