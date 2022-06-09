package abuteen.hashem.ordermanagementbackend.exception;

public class ChangeUserNameException extends RuntimeException{
    public ChangeUserNameException(){
        super("Can not change username");
    }
}
