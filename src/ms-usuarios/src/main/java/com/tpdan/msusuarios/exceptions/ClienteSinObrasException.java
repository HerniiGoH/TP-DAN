package com.tpdan.msusuarios.exceptions;

public class ClienteSinObrasException extends BusinessRuleException {
    public ClienteSinObrasException(){
        super("El cliente debe tener al menos una obra.");
    }
}
