package com.tpdan.msproductos.model.dto;

public class DetallePedido {
    private Integer id;
    private Integer cantidad;
    private Integer productoId;

    public DetallePedido() {
    }

    public DetallePedido(Integer id, Integer cantidad, Integer productoId) {
        this.id = id;
        this.cantidad = cantidad;
        this.productoId = productoId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Integer getProductoId() {
        return productoId;
    }

    public void setProductoId(Integer productoId) {
        this.productoId = productoId;
    }
}
