package com.tpdan.msusuarios.exceptions.exceptionHandler;

import com.tpdan.msusuarios.exceptions.BusinessRuleException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class BusinessExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(BusinessRuleException.class)
    protected ResponseEntity<Object> manageThrownException(BusinessRuleException businessRuleException, WebRequest webRequest){
        return handleExceptionInternal(businessRuleException, businessRuleException.getMessage(), new HttpHeaders(), HttpStatus.BAD_REQUEST, webRequest);
    }
}
