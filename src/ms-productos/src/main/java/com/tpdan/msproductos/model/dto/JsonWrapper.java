package com.tpdan.msproductos.model.dto;

import java.util.List;

public class JsonWrapper {
    private List<DetallePedido> detallePedido;

    public JsonWrapper() {
    }

    public JsonWrapper(List<DetallePedido> detallePedido) {
        this.detallePedido = detallePedido;
    }

    public List<DetallePedido> getDetallePedido() {
        return detallePedido;
    }

    public void setDetallePedido(List<DetallePedido> detallePedido) {
        this.detallePedido = detallePedido;
    }
}
