package abuteen.hashem.ordermanagementbackend.security;

public class IncorrectUsernameOrPasswordException extends RuntimeException{
    public IncorrectUsernameOrPasswordException() {
        super("Incorrect username or password");
    }
}
