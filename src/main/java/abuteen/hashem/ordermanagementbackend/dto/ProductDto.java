package abuteen.hashem.ordermanagementbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The type Product dto.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    private int id;

    private String slug;
    private String name;
    private String reference;
    private double price;
    private double vat;
    private boolean stockable;
    private boolean isActive;
}
