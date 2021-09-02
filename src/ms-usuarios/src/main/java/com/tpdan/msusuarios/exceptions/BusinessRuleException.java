package com.tpdan.msusuarios.exceptions;

public class BusinessRuleException extends Exception{
    public BusinessRuleException(String errorMessage){
        super(errorMessage);
    }
}
