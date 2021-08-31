package com.tpdan.msusuarios.exceptions;

import com.tpdan.msusuarios.exceptions.BusinessRuleException;

public class UsuarioExistenteException extends BusinessRuleException {
    public UsuarioExistenteException(){
        super("El nombre de usuario ingresado no se encuentra disponible.");
    }
}
