package abuteen.hashem.ordermanagementbackend.security;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The type Update password request.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdatePasswordRequest {
    /**
     * The Old pass.
     */
    String oldPass;
    /**
     * The New pass.
     */
    String newPass;
}
