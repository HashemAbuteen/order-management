package abuteen.hashem.ordermanagementbackend.exception;

public class ChangeStockProductException extends RuntimeException{
    public ChangeStockProductException() {
        super("Can not change product for a stock");
    }
}
