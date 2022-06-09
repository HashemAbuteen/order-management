package abuteen.hashem.ordermanagementbackend.exception;

/**
 * The type User name is taken exception.
 */
public class UserNameIsTakenException extends RuntimeException{
    /**
     * Instantiates a new User name is taken exception.
     */
    public UserNameIsTakenException(){
        super("UserName is Taken");
    }
}
