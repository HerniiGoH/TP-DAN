package com.tpdan.msusuarios.exceptions;

public class ClienteInexistenteException extends BusinessRuleException{
    public ClienteInexistenteException(){
        super("El cliente solicitado no existe.");
    }
}
