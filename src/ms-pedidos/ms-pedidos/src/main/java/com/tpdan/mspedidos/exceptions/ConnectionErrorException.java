package com.tpdan.mspedidos.exceptions;

public class ConnectionErrorException extends BusinessRuleException{
    public ConnectionErrorException(){
        super("El servicio solicitado no se encuentra disponible.");
    }
}
