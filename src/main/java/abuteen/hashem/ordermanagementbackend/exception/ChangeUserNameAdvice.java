package abuteen.hashem.ordermanagementbackend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * The type Change user name advice.
 */
@ControllerAdvice
public class ChangeUserNameAdvice {
    /**
     * Change user name exception handler string.
     *
     * @param ex the ex
     * @return the string
     */
    @ResponseBody
    @ExceptionHandler(ChangeUserNameException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    String  ChangeUserNameExceptionHandler(ChangeUserNameException ex){
        return ex.getMessage();
    }
}
