package abuteen.hashem.ordermanagementbackend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * The type Change stock product advice.
 */
@ControllerAdvice
public class ChangeStockProductAdvice {
    /**
     * Change stock product exception handler string.
     *
     * @param ex the ex
     * @return the string
     */
    @ResponseBody
    @ExceptionHandler(ChangeStockProductException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    String ChangeStockProductExceptionHandler(ChangeStockProductException ex){
        return ex.getMessage();
    }
}
