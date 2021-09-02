package com.tpdan.msusuarios.exceptions;

public class UsuarioExistenteException extends BusinessRuleException {
    public UsuarioExistenteException(){
        super("El nombre de usuario ingresado no se encuentra disponible.");
    }
}
