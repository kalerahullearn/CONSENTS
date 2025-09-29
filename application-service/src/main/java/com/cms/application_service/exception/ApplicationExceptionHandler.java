package com.cms.application_service.exception;


import com.cms.dto.ResponseEvent;
import com.cms.exception.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Arrays;

@ControllerAdvice
public class ApplicationExceptionHandler {

    @ExceptionHandler(exception = EntityNotFoundException.class)
    public ResponseEntity<ResponseEvent> handleEntityNotFoundException(EntityNotFoundException ex){
        return ResponseEntity.ok(ResponseEvent.builder()
                .statusCode(404)
                .success(false)
                .errors(Arrays.asList(ex.getMessage()))
                .build());
    }
}
