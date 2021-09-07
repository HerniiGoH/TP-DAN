package com.tpdan.mspagos.model;

import com.fasterxml.jackson.annotation.*;
import com.tpdan.mspagos.model.dto.Cliente;
import com.tpdan.mspagos.model.dto.Pedido;

import javax.persistence.*;
import java.time.Instant;

@Entity
@JsonIdentityInfo(scope= Pago.class,generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Pago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Instant fechaPago;
    @OneToOne
    private FormaPago formaPago;
    @Transient
    private Cliente cliente;
    private Integer clienteId;
    @Transient
    private Pedido pedido;
    private Integer pedidoId;

    public Pago() {
    }

    public Pago(Integer id, Instant fechaPago, FormaPago formaPago, Cliente cliente, Integer clienteId, Pedido pedido, Integer pedidoId) {
        this.id = id;
        this.fechaPago = fechaPago;
        this.formaPago = formaPago;
        this.cliente = cliente;
        this.clienteId = clienteId;
        this.pedido = pedido;
        this.pedidoId = pedidoId;
    }

    public Integer getId() {return id;}

    public void setId(Integer id) {this.id = id;}

    public Instant getFechaPago() { return fechaPago;}

    public void setFechaPago(Instant fechaPago) {this.fechaPago = fechaPago; }

    public FormaPago getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(FormaPago formaPago) {
        this.formaPago = formaPago;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Integer getClienteId() {
        return clienteId;
    }

    public void setClienteId(Integer idCliente) {
        this.clienteId = idCliente;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Integer getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(Integer idPedido) {
        this.pedidoId = idPedido;
    }
}
