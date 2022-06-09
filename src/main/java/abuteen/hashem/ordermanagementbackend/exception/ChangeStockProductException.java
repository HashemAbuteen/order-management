package abuteen.hashem.ordermanagementbackend.exception;

/**
 * The type Change stock product exception.
 */
public class ChangeStockProductException extends RuntimeException{
    /**
     * Instantiates a new Change stock product exception.
     */
    public ChangeStockProductException() {
        super("Can not change product for a stock");
    }
}
