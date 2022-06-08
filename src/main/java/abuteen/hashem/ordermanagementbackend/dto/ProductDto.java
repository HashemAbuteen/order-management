package abuteen.hashem.ordermanagementbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    private int id;

    private String slug;
    private String name;
    private String reference;
    private float price;
    private float vat;
    private boolean stockable;
}
