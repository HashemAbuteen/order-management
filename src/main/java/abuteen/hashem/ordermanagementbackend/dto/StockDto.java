package abuteen.hashem.ordermanagementbackend.dto;

import abuteen.hashem.ordermanagementbackend.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/**
 * The type Stock dto.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StockDto {
    private int id;

    private ProductDto productDto;

    private int quantity;

    private Date updatedAt;
}
