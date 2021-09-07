package com.tpdan.mspagos.model.dto;

import java.util.List;

public class Pedido {
    private Integer id;
    private Double precio;
    List<DetallePedido> detallePedidos;

    public Pedido() {
    }

    public Pedido(Integer id, Double precio, List<DetallePedido> detallePedidos) {
        this.id = id;
        this.precio = precio;
        this.detallePedidos = detallePedidos;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public List<DetallePedido> getDetallePedidos() {
        return detallePedidos;
    }

    public void setDetallePedidos(List<DetallePedido> detallePedidos) {
        this.detallePedidos = detallePedidos;
    }
}
