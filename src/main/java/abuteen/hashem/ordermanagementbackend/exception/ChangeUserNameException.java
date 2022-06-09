package abuteen.hashem.ordermanagementbackend.exception;

/**
 * The type Change user name exception.
 */
public class ChangeUserNameException extends RuntimeException{
    /**
     * Instantiates a new Change user name exception.
     */
    public ChangeUserNameException(){
        super("Can not change username");
    }
}
