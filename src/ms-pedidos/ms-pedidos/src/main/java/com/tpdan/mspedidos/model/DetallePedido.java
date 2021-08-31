package com.tpdan.mspedidos.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.tpdan.mspedidos.model.dto.Producto;

import javax.persistence.*;

@Entity
@JsonIdentityInfo(scope = DetallePedido.class, generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class DetallePedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer cantidad;
    private Double precio;
    @Transient
    private Producto producto;
    private Integer productoId;
    @JsonIdentityReference(alwaysAsId = true)
    @ManyToOne
    private Pedido pedido;

    public DetallePedido() {
    }

    public DetallePedido(Integer id, Integer cantidad, Double precio, Producto producto, Integer productoId, Pedido pedido) {
        this.id = id;
        this.cantidad = cantidad;
        this.precio = precio;
        this.producto = producto;
        this.productoId = productoId;
        this.pedido = pedido;
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

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Integer getProductoId() {
        return productoId;
    }

    public void setProductoId(Integer productoId) {
        this.productoId = productoId;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
}
