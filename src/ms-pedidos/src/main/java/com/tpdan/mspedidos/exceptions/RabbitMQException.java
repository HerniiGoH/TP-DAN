package com.tpdan.mspedidos.exceptions;

public class RabbitMQException extends BusinessRuleException{
    public RabbitMQException(){
        super("La cola de mensajes no se encuentra disponible.");
    }
}
