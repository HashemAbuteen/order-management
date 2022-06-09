package abuteen.hashem.ordermanagementbackend.exception;

public class IncorrectUsernameOrPasswordException extends RuntimeException{
    public IncorrectUsernameOrPasswordException() {
        super("Incorrect username or password");
    }
}
