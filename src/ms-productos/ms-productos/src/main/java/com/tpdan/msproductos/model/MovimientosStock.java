package com.tpdan.msproductos.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.tpdan.msproductos.model.dto.DetallePedido;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@JsonIdentityInfo(scope = MovimientosStock.class, generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class MovimientosStock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer cantidadEntrada;
    private Integer cantidadSalida;
    private LocalDateTime Fecha;
    @OneToOne
    private Producto producto;
    @OneToOne
    private ProvisionDetalle provisionDetalle;
    @Transient
    private DetallePedido detallePedido;
    private Integer detallePedidoId;

    public MovimientosStock() {
    }

    public MovimientosStock(Integer id, Integer cantidadEntrada, Integer cantidadSalida, LocalDateTime fecha, Producto producto, ProvisionDetalle provisionDetalle, DetallePedido detallePedido, Integer detallePedidoId) {
        this.id = id;
        this.cantidadEntrada = cantidadEntrada;
        this.cantidadSalida = cantidadSalida;
        Fecha = fecha;
        this.producto = producto;
        this.provisionDetalle = provisionDetalle;
        this.detallePedido = detallePedido;
        this.detallePedidoId = detallePedidoId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCantidadEntrada() {
        return cantidadEntrada;
    }

    public void setCantidadEntrada(Integer cantidadEntrada) {
        this.cantidadEntrada = cantidadEntrada;
    }

    public Integer getCantidadSalida() {
        return cantidadSalida;
    }

    public void setCantidadSalida(Integer cantidadSalida) {
        this.cantidadSalida = cantidadSalida;
    }

    public LocalDateTime getFecha() {
        return Fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        Fecha = fecha;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public ProvisionDetalle getProvisionDetalle() {
        return provisionDetalle;
    }

    public void setProvisionDetalle(ProvisionDetalle provisionDetalle) {
        this.provisionDetalle = provisionDetalle;
    }

    public DetallePedido getDetallePedido() {
        return detallePedido;
    }

    public void setDetallePedido(DetallePedido detallePedido) {
        this.detallePedido = detallePedido;
    }

    public Integer getDetallePedidoId() {
        return detallePedidoId;
    }

    public void setDetallePedidoId(Integer detallePedidoId) {
        this.detallePedidoId = detallePedidoId;
    }
}
