package com.tpdan.mspagos.model;

import javax.persistence.*;

@Entity
public class Efectivo extends FormaPago {
    private Integer nroRecibo;

    public Efectivo(Integer id, String observacion, Integer nroRecibo) {
        super(id, observacion);
        this.nroRecibo = nroRecibo;
    }

    public Efectivo(Integer nroRecibo) {
        this.nroRecibo = nroRecibo;
    }

    public Efectivo(){}

    public Integer getNroRecibo() {return nroRecibo;}

    public void setNroRecibo(Integer nroRecibo) {this.nroRecibo = nroRecibo;}
}