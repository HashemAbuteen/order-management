package abuteen.hashem.ordermanagementbackend.exception;

public class UserNameIsTakenException extends RuntimeException{
    public UserNameIsTakenException(){
        super("UserName is Taken");
    }
}
