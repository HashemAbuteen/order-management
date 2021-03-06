package abuteen.hashem.ordermanagementbackend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 * The type Product order.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table( name = "product_order_tbl")
public class ProductOrder implements Serializable {
    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    @JoinColumn(name = "productId" , referencedColumnName = "id")
    private Product product;

    private int quantity;
    private double price;
    private double vat;




}
