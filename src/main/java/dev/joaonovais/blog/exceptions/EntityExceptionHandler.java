package dev.joaonovais.blog.exceptions;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class EntityExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<StandardError> entityNotFound(EntityNotFoundException e, HttpServletRequest request) {
        StandardError err = createError(
                HttpStatus.NOT_FOUND.value(),
                "Entity not found",
                e.getMessage(),
                request.getRequestURI()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
    }

    private StandardError createError(Integer status, String error, String message, String path) {
        StandardError err = new StandardError();
        err.setTimestamp(Instant.now());
        err.setStatus(status);
        err.setError(error);
        err.setMessage(message);
        err.setPath(path);
        return err;
    }

}
