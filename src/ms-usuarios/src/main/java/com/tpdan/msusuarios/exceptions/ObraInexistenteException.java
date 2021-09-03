package com.tpdan.msusuarios.exceptions;

public class ObraInexistenteException extends BusinessRuleException{
    public ObraInexistenteException(){
        super("La obra solicitada no existe.");
    }
}
