package com.tpdan.msproductos.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@JsonIdentityInfo(scope = Provision.class, generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Provision {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDateTime fechaProvision;
    @OneToMany(mappedBy = "provision")
    private List<ProvisionDetalle> provisionDetalle;

    public Provision() {
    }

    public Provision(Integer id, LocalDateTime fechaProvision, List<ProvisionDetalle> provisionDetalle) {
        this.id = id;
        this.fechaProvision = fechaProvision;
        this.provisionDetalle = provisionDetalle;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getFechaProvision() {
        return fechaProvision;
    }

    public void setFechaProvision(LocalDateTime fechaProvision) {
        this.fechaProvision = fechaProvision;
    }

    public List<ProvisionDetalle> getProvisionDetalle() {
        return provisionDetalle;
    }

    public void setProvisionDetalle(List<ProvisionDetalle> provisionDetalle) {
        this.provisionDetalle = provisionDetalle;
    }
}
