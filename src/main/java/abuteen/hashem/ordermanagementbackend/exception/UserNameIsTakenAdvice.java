package abuteen.hashem.ordermanagementbackend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * The type User name is taken advice.
 */
@ControllerAdvice
public class UserNameIsTakenAdvice {
    /**
     * User name is taken exception handler string.
     *
     * @param ex the ex
     * @return the string
     */
    @ResponseBody
    @ExceptionHandler(UserNameIsTakenException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    String UserNameIsTakenExceptionHandler(UserNameIsTakenException ex){
        return ex.getMessage();
    }
}
