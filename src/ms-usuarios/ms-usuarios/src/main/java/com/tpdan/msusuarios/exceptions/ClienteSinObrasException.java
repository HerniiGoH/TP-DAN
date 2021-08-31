package com.tpdan.msusuarios.exceptions;

import com.tpdan.msusuarios.exceptions.BusinessRuleException;

public class ClienteSinObrasException extends BusinessRuleException {
    public ClienteSinObrasException(){
        super("El cliente debe tener al menos una obra.");
    }
}
