package com.tpdan.mspagos.exceptions;

public class BusinessRuleException extends Exception{
    public BusinessRuleException(String errorMessage){
        super(errorMessage);
    }
}
