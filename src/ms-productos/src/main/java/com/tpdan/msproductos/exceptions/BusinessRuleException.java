package com.tpdan.msproductos.exceptions;

public class BusinessRuleException extends Exception{
    public BusinessRuleException(String errorMessage){
        super(errorMessage);
    }
}
