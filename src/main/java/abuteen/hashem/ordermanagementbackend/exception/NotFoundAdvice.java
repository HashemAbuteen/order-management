package abuteen.hashem.ordermanagementbackend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * The type Not found advice.
 */
@ControllerAdvice
public class NotFoundAdvice {

    /**
     * Product not found handler string.
     *
     * @param ex the ex
     * @return the string
     */
    @ResponseBody
    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String productNotFoundHandler (NotFoundException ex){
        return ex.getMessage();
    }
}
