package com.tpdan.msproductos.service.impl;

import com.tpdan.msproductos.exceptions.BusinessRuleException;
import com.tpdan.msproductos.model.dto.DetallePedido;
import com.tpdan.msproductos.model.dto.Pedido;
import com.tpdan.msproductos.service.ProductoService;
import com.tpdan.msproductos.service.RabbitService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RabbitServiceImpl implements RabbitService {
    private final ProductoService productoService;

    public RabbitServiceImpl(ProductoService productoService) {
        this.productoService = productoService;
    }

    @RabbitListener(queues = "${rabbit.nombre-cola}")
    public void recibirMensaje(List<DetallePedido> detallePedidoList) throws BusinessRuleException {
        productoService.generarMovimientoStock(detallePedidoList);
    }
}
