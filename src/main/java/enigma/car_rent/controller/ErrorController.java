package enigma.car_rent.controller;

import enigma.car_rent.utils.Res;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.UnexpectedTypeException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorController {
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<?> handleConstraintViolation(ConstraintViolationException e) {
        String message = e.getMessage();
        HttpStatus status = HttpStatus.BAD_REQUEST;

        if (e.getMessage().contains("name")) {
            message = "name cannot be blank";
        } else if (e.getMessage().contains("balance")) {
            message = "balance cannot be null";
        }

        return Res.renderJson(null, message, status);
    }


    @ExceptionHandler(UnexpectedTypeException.class)
    public ResponseEntity<?> handleUnexpectedType(UnexpectedTypeException e) {
        String message = e.getMessage();
        HttpStatus status = HttpStatus.BAD_REQUEST;

        if (e.getMessage().contains("name")) {
            message = "name cannot be blank";
        }
        return Res.renderJson(null, message, status);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<?> handleRuntime(RuntimeException e) {
        String message = e.getMessage();
        HttpStatus status = HttpStatus.BAD_REQUEST;

        if (e.getMessage().contains("user with id")) {
            message = "User not found";
        } else if (e.getMessage().contains("car with id")) {
            message = "Car not found";
            {
            }
            return Res.renderJson(null, message, status);
        }
        return Res.renderJson(null, message, status);
    }
}
