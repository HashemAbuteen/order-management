package abuteen.hashem.ordermanagementbackend.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * The type Incorrect username or password advice.
 */
@ControllerAdvice
public class IncorrectUsernameOrPasswordAdvice {

    /**
     * Incorrect username or password handler string.
     *
     * @param ex the ex
     * @return the string
     */
    @ResponseBody
    @ExceptionHandler(IncorrectUsernameOrPasswordException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    String incorrectUsernameOrPasswordHandler (IncorrectUsernameOrPasswordException ex){
        return ex.getMessage();
    }

}