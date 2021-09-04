package com.tpdan.msproductos.model.dto;

import java.util.List;

public class Pedido {
    private List<DetallePedido> detallePedido;

    public Pedido() {
    }

    public Pedido(List<DetallePedido> detallePedido) {
        this.detallePedido = detallePedido;
    }

    public List<DetallePedido> getDetallePedido() {
        return detallePedido;
    }

    public void setDetallePedido(List<DetallePedido> detallePedido) {
        this.detallePedido = detallePedido;
    }
}
