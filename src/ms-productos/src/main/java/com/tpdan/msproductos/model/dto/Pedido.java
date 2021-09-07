package com.tpdan.msproductos.model.dto;

import java.util.List;

public class Pedido {
    private Integer id;
    private Double costo;
    private List<DetallePedido> detallePedido;

    public Pedido() {
    }

    public Pedido(Integer id, Double costo, List<DetallePedido> detallePedido) {
        this.id = id;
        this.costo = costo;
        this.detallePedido = detallePedido;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getCosto() {
        return costo;
    }

    public void setCosto(Double costo) {
        this.costo = costo;
    }

    public List<DetallePedido> getDetallePedido() {
        return detallePedido;
    }

    public void setDetallePedido(List<DetallePedido> detallePedido) {
        this.detallePedido = detallePedido;
    }
}
