package abuteen.hashem.ordermanagementbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {
    private int id;

    private String firstName;
    private String LastName;

    private Date bornAt;

}
