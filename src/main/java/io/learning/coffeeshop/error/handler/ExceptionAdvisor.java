package io.learning.coffeeshop.error.handler;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.CONFLICT;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.NOT_FOUND;

import javax.validation.ConstraintViolationException;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.mapping.MappingException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import io.learning.coffeeshop.apierror.ApiError;
import io.learning.coffeeshop.exception.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@RestControllerAdvice
@Slf4j
public class ExceptionAdvisor extends DefaultExceptionAdvisor {

    /**
     * Handles {@link EntityNotFoundException}. Thrown when entity not found in database.
     * 
     * @param ex
     * @return the ApiError object
     */
    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(NOT_FOUND)
    public Mono<ApiError> handleEntityNotFoundException(EntityNotFoundException ex) {
        log.error("Error: {}", ex);
        return Mono.just(new ApiError(NOT_FOUND, ex.getMessage()));
    }

    /**
     * Handle {@link DataIntegrityViolationException}, inspects the cause for different DB causes.
     * 
     * @param ex
     *            the DataIntegrityViolationException
     * @return the ApiError object
     */
    @ExceptionHandler(DataIntegrityViolationException.class)
    @ResponseStatus(BAD_REQUEST)
    public Mono<ApiError> handleDataIntegrityViolationException(DataIntegrityViolationException ex) {
        log.error("Error: {}", ex);
        if (ex.getCause() instanceof ConstraintViolationException) {
            return Mono.just(new ApiError(CONFLICT, "Database error"));
        }
        return Mono.just(new ApiError(INTERNAL_SERVER_ERROR, ex.getRootCause().getMessage()));
    }

    /**
     * Handles {@link MappingException}. Thrown when JPA mapping fails.
     * 
     * @param ex
     * @return the ApiError object
     */
    @ExceptionHandler(MappingException.class)
    @ResponseStatus(INTERNAL_SERVER_ERROR)
    public Mono<ApiError> handleMappingException(MappingException ex) {
        log.error("Error: {}", ex);
        return Mono.just(new ApiError(INTERNAL_SERVER_ERROR, ex.getMessage()));
    }

}
