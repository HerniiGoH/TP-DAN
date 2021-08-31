package com.tpdan.msusuarios.exceptions;

import com.tpdan.msusuarios.exceptions.BusinessRuleException;

public class ClienteSinTipoDeObraException extends BusinessRuleException {
    public ClienteSinTipoDeObraException(){
        super("El cliente debe sus obras con su tipo de obra.");
    }
}
