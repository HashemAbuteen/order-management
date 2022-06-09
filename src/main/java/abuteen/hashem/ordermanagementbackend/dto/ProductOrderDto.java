package abuteen.hashem.ordermanagementbackend.dto;

import abuteen.hashem.ordermanagementbackend.entity.Order;
import abuteen.hashem.ordermanagementbackend.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductOrderDto {
    private int id;

    private Product product;

    private int quantity;
    private double price;
    private double vat;
}
