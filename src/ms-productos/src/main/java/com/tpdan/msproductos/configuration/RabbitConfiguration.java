package com.tpdan.msproductos.configuration;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfiguration {

    public static String DIRECT_EXCHANGE_NAME;
    public static String NOMBRE_COLA;
    public static String ROUTING_KEY;

    @Value("${rabbit.direct-exchange-name}")
    public void setDirectExchangeName(String directExchangeName) {
        DIRECT_EXCHANGE_NAME = directExchangeName;
    }

    @Value("${rabbit.nombre-cola}")
    public void setNombreCola(String nombreCola) {
        NOMBRE_COLA = nombreCola;
    }

    @Value("${rabbit.routing-key}")
    public void setRoutingKey(String routingKey) {
        ROUTING_KEY = routingKey;
    }

    @Bean
    Queue queue() {
        return new Queue(NOMBRE_COLA, true);
    }

    @Bean
    DirectExchange exchange() {
        return new DirectExchange(DIRECT_EXCHANGE_NAME);
    }

    @Bean
    Binding binding(Queue queue, DirectExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY);
    }

    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}
