package abuteen.hashem.ordermanagementbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * The type Customer dto.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {
    private int id;
    private String userName;
    private String password;

    private String firstName;
    private String LastName;

    private Date bornAt;
    private boolean active;

}
