package org.example.infrastructure.handler;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.log4j.Log4j2;
import org.example.entity.exception.NoContentException;
import org.hibernate.engine.jdbc.spi.SqlExceptionHelper.StandardWarningHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Log4j2
public class GlobalExceptionHandler {

    private static final String CAUSE = "Cause: {} : {}";

    /**
     * 400 - Bad Request
     */
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ExceptionHandler(NoContentException.class)
    public StandardWarningHandler handleNoContentException(NoContentException e,
                                                           HttpServletRequest req) {
        logger(e);
        return new StandardWarningHandler(e.getMessage());
    }


    /**
     * 400 - Bad Request
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public StandardError handleMissingServletRequestParameterException(MissingServletRequestParameterException e,
                                                                       HttpServletRequest req) {
        logger(e);
        return new StandardError(HttpStatus.BAD_REQUEST.value(), e.getMessage(), e.getMessage(), req.getRequestURI());
    }

    /**
     * 400 - Bad Request
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public StandardError handleHttpMessageNotReadableException(HttpMessageNotReadableException e,
                                                               HttpServletRequest req) {

        logger(e);

        return new StandardError(HttpStatus.BAD_REQUEST.value(), e.getMessage(), "Bad Request", req.getRequestURI());
    }

    /**
     * 400 - Bad Request
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public StandardError handleMethodArgumentNotValidException(MethodArgumentNotValidException e,
                                                               HttpServletRequest req) {

        logger(e);

        BindingResult result = e.getBindingResult();
        FieldError error = result.getFieldError();
        String field = error != null ? error.getField() : "";
        String message = error != null ? error.getDefaultMessage() : "";

        return new StandardError(HttpStatus.BAD_REQUEST.value(),
                String.format("%s:%s", field, message), field,
                req.getRequestURI());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(IllegalArgumentException.class)
    public StandardError standardErrorHandleAssertionException(IllegalArgumentException e, HttpServletRequest req) {

        logger(e);

        return new StandardError(HttpStatus.BAD_REQUEST.value(), e.getMessage(), "Error", req.getRequestURI());
    }

    @ExceptionHandler(BindException.class)
    public ResponseEntity<StandardError> validation(BindException e, HttpServletRequest req) {
        logger(e);

        ValidationError validationError = new ValidationError(HttpStatus.UNPROCESSABLE_ENTITY.value(),
                "Erro de validação", "Erro de validação", req.getRequestURI());
        for (FieldError f : e.getBindingResult().getFieldErrors()) {
            validationError.addError(f.getField(), f.getDefaultMessage());
        }
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(validationError);
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(RuntimeException.class)
    public StandardError generic(RuntimeException e, HttpServletRequest req) {

        logger(e);

        return new StandardError(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage(), "Error", req.getRequestURI());
    }

    private static void logger(Exception e) {
        log.error(CAUSE, e, e.getMessage());

        e.printStackTrace();
    }

}