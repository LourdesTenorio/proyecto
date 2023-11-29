
package com.cibertec.Proyecto.McDonalds.ApiVentas.exception;


import com.cibertec.Proyecto.McDonalds.ApiVentas.dto.ErrorResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorResponseDto> handlerEntityNotFound(EntityNotFoundException ex){
        var httpStatus = HttpStatus.NOT_FOUND;
        var errorResponse = new ErrorResponseDto(httpStatus, ex.getMessage(),ex.toString());
        return new ResponseEntity<>(errorResponse,httpStatus);
    }
}
