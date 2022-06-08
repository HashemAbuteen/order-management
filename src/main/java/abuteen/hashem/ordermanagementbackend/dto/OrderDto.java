package abuteen.hashem.ordermanagementbackend.dto;

import abuteen.hashem.ordermanagementbackend.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {
    private int Id;

    private Date orderedAt;

    private Customer customer;
}
