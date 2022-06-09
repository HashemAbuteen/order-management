package abuteen.hashem.ordermanagementbackend.exception;

public class NotFoundException extends RuntimeException{
    public NotFoundException(){
        super("not found");
    }
}
