package com.tpdan.mspedidos.service;

import com.tpdan.mspedidos.model.DetallePedido;
import com.tpdan.mspedidos.model.Pedido;

import java.util.List;
import java.util.Optional;

public interface PedidoService {
    List<Pedido> buscarTodos();
    Optional<Pedido> buscarPedidoPorId(Integer id);
    Optional<List<Pedido>> buscarPedidosPorIdObra(Integer id);
    Optional<List<Pedido>> buscarPedidosPorCliente(Integer id, String cuit);
    Optional<List<Pedido>> buscarPedidosPorEstado(String estado);
    Optional<DetallePedido> buscarDetallePedidoPorId(Integer idPedido, Integer id);
    Pedido crearPedido(Pedido nuevoPedido);
    DetallePedido crearDetallePedido(DetallePedido nuevoDetallePedido, Integer id);
    Pedido actualizarPedido(Pedido nuevoPedido);
    DetallePedido actualizarDetallePedido(DetallePedido nuevoDetalle, Integer idPedido);
    Optional<Pedido> actualizarEstadoPedido(Integer id, String estado);
    void borrarPedido(Integer id);
    void borrarDetallePedido(Integer idPedido, Integer id);
}
