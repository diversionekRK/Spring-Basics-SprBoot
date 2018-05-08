package exception;

import org.springframework.dao.DataAccessException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Created by Div on 2018-05-07.
 */

@ControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(DataAccessException.class)
    public String handleDatabaseException(DataAccessException ex) {
        return "error";
    }

    @ExceptionHandler(AccessDeniedException.class)
    public String handleDatabaseException(AccessDeniedException ex) {
        return "accessdenied";
    }
}