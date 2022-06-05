package abuteen.hashem.ordermanagementbackend.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

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
    private float price;
    private float vat;
    private boolean stockable;

}
