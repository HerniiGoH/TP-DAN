package com.tpdan.msusuarios.exceptions;

public class ConnectionErrorException extends BusinessRuleException{
    public ConnectionErrorException(){
        super("No es posible conectarse con el servicio solicitado.");
    }
}
