package com.tpdan.msproductos.exceptions;

public class ProductoInexistenteException extends BusinessRuleException{
    public ProductoInexistenteException(){
        super("El producto solicitado no existe.");
    }
}
