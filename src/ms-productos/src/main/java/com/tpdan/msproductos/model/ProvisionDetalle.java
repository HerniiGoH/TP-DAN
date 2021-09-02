package com.tpdan.msproductos.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;

@Entity
@JsonIdentityInfo(scope = ProvisionDetalle.class, generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class ProvisionDetalle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer cantidad;
    @JsonIdentityReference(alwaysAsId = true)
    @ManyToOne
    private Provision provision;
    @OneToOne
    private Producto producto;

    public ProvisionDetalle() {
    }

    public ProvisionDetalle(Integer id, Integer cantidad, Provision provision, Producto producto) {
        this.id = id;
        this.cantidad = cantidad;
        this.provision = provision;
        this.producto = producto;
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

    public Provision getProvision() {
        return provision;
    }

    public void setProvision(Provision provision) {
        this.provision = provision;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
}
