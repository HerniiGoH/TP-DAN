package com.tpdan.mspedidos.exceptions;

public class BusinessRuleException extends Exception{
    public BusinessRuleException(String errorMessage) {
        super(errorMessage);
    }
}
