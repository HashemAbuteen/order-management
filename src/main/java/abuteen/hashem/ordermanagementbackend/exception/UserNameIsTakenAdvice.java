package abuteen.hashem.ordermanagementbackend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class UserNameIsTakenAdvice {
    @ResponseBody
    @ExceptionHandler(UserNameIsTakenException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    String UserNameIsTakenExceptionHandler(UserNameIsTakenException ex){
        return ex.getMessage();
    }
}
