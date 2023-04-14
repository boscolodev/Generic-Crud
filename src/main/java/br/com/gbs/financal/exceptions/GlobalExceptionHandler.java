package br.com.gbs.financal.exceptions;

import br.com.gbs.financal.model.dto.ApiError;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DataBaseException.class)
    public ApiError databaseError(DataBaseException e, HttpServletRequest request){
        return ApiError.builder()
                .error("Resource not found")
                .mensage(e.getMessage())
                .path(request.getRequestURI())
                .timestamp(Instant.now())
                .status(HttpStatus.NOT_FOUND.value())
                .build();
    }
}
