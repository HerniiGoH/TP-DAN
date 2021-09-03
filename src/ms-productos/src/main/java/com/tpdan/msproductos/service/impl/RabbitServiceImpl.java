package com.tpdan.msproductos.service.impl;

import com.tpdan.msproductos.exceptions.BusinessRuleException;
import com.tpdan.msproductos.model.dto.Pedido;
import com.tpdan.msproductos.service.ProductoService;
import com.tpdan.msproductos.service.RabbitService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class RabbitServiceImpl implements RabbitService {
    private final ProductoService productoService;

    public RabbitServiceImpl(ProductoService productoService) {
        this.productoService = productoService;
    }

    @RabbitListener(queues = "COLA_PEDIDOS")
    public void recibirMensaje(Pedido pedido) throws BusinessRuleException {
        productoService.generarMovimientoStock(pedido);
    }
}
