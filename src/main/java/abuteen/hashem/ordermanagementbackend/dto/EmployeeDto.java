package abuteen.hashem.ordermanagementbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The type Employee dto.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {
    private int id;
    private String name;
    private String userName;
    private String password;
}
