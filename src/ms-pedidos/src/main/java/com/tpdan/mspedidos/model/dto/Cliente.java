package com.tpdan.mspedidos.model.dto;

public class Cliente {
    private Integer id;
    private String razonSocial;
    private String cuit;
    private String mail;
    private Double maximoCuentaCorriente;
    private Boolean habilitadoOnline;

    public Cliente() {
    }

    public Cliente(Integer id, String razonSocial, String cuit, String mail, Double maximoCuentaCorriente, Boolean habilitadoOnline) {
        this.id = id;
        this.razonSocial = razonSocial;
        this.cuit = cuit;
        this.mail = mail;
        this.maximoCuentaCorriente = maximoCuentaCorriente;
        this.habilitadoOnline = habilitadoOnline;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getCuit() {
        return cuit;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Double getMaximoCuentaCorriente() {
        return maximoCuentaCorriente;
    }

    public void setMaximoCuentaCorriente(Double maximoCuentaCorriente) {
        this.maximoCuentaCorriente = maximoCuentaCorriente;
    }

    public Boolean getHabilitadoOnline() {
        return habilitadoOnline;
    }

    public void setHabilitadoOnline(Boolean habilitadoOnline) {
        this.habilitadoOnline = habilitadoOnline;
    }
}
