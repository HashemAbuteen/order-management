package abuteen.hashem.ordermanagementbackend.entity;


import abuteen.hashem.ordermanagementbackend.dto.ProductDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * The type Product.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name = "product_tbl")
public class Product implements Serializable {
    @Id
    @GeneratedValue
    private int id;

    private String slug;
    private String name;
    private String reference;
    private double price;
    private double vat;
    private boolean stockable;
    private boolean isActive;


}
