package abuteen.hashem.ordermanagementbackend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table( name = "product_order_tbl")
public class productOrder implements Serializable {
    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    @JoinColumn(name = "productId" , referencedColumnName = "id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "orderId" , referencedColumnName = "id")
    private Order order;

    private int quantity;
    private float price;
    private float vat;




}
