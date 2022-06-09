package abuteen.hashem.ordermanagementbackend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/**
 * The type Stock.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "stock_tbl")
public class Stock {
    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    @JoinColumn(name = "productId" , referencedColumnName = "id")
    private Product product;

    private int quantity;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
}
