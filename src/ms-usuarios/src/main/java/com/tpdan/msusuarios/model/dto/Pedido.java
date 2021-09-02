package com.tpdan.msusuarios.model.dto;

import java.time.LocalDateTime;

public class Pedido {
    Integer id;
    EstadoPedido estado;
    LocalDateTime fechaPedido;
    Integer obraId;

    public Pedido() {
    }

    public Pedido(Integer id, EstadoPedido estado, LocalDateTime fechaPedido, Integer obraId) {
        this.id = id;
        this.estado = estado;
        this.fechaPedido = fechaPedido;
        this.obraId = obraId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public EstadoPedido getEstado() {
        return estado;
    }

    public void setEstado(EstadoPedido estado) {
        this.estado = estado;
    }

    public LocalDateTime getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(LocalDateTime fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public Integer getObraId() {
        return obraId;
    }

    public void setObraId(Integer obraId) {
        this.obraId = obraId;
    }
}
