package abuteen.hashem.ordermanagementbackend.dto;

import abuteen.hashem.ordermanagementbackend.entity.Customer;
import abuteen.hashem.ordermanagementbackend.entity.ProductOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * The type Order dto.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {
    private int Id;

    private Date orderedAt;

    private Customer customer;

    private List<ProductOrder> productOrderList;
    private boolean deleted;
}
