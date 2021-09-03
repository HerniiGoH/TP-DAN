package com.tpdan.mspedidos.service.impl;

import com.tpdan.mspedidos.configuration.RabbitConfiguration;
import com.tpdan.mspedidos.exceptions.BusinessRuleException;
import com.tpdan.mspedidos.exceptions.RabbitMQException;
import com.tpdan.mspedidos.service.RabbitService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class RabbitServiceImpl implements RabbitService {
    private final RabbitTemplate rabbitTemplate;

    public RabbitServiceImpl(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public void enviarMensaje(Object mensaje) throws BusinessRuleException {
        try{
            rabbitTemplate.convertAndSend(RabbitConfiguration.DIRECT_EXCHANGE_NAME, RabbitConfiguration.ROUTING_KEY, mensaje);
        }catch(Exception e){
            throw new RabbitMQException();
        }
    }
}
