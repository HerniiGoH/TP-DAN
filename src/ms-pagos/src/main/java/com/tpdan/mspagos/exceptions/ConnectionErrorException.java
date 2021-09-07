package com.tpdan.mspagos.exceptions;

public class ConnectionErrorException extends BusinessRuleException{
    public ConnectionErrorException() {
        super("No se pudo conectar con el servicio solicitado");
    }
}
