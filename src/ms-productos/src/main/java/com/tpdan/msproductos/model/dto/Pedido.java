package com.tpdan.msproductos.model.dto;

import java.util.List;

public class Pedido {
    private Integer id;
    private List<DetallePedido> detallePedido;

    public Pedido() {
    }

    public Pedido(Integer id, List<DetallePedido> detallePedido) {
        this.id = id;
        this.detallePedido = detallePedido;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<DetallePedido> getDetallePedido() {
        return detallePedido;
    }

    public void setDetallePedido(List<DetallePedido> detallePedido) {
        this.detallePedido = detallePedido;
    }
}
