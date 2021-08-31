package com.tpdan.mspedidos.service;

import com.tpdan.mspedidos.exceptions.BusinessRuleException;
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
    Pedido crearPedido(Pedido nuevoPedido) throws BusinessRuleException;
    DetallePedido crearDetallePedido(DetallePedido nuevoDetallePedido, Integer id) throws BusinessRuleException;
    Pedido actualizarPedido(Pedido nuevoPedido) throws BusinessRuleException;
    DetallePedido actualizarDetallePedido(DetallePedido nuevoDetalle, Integer idPedido) throws BusinessRuleException;
    Pedido confirmarPedido(Integer id) throws BusinessRuleException;
    void borrarPedido(Integer id) throws BusinessRuleException;
    void borrarDetallePedido(Integer idPedido, Integer id) throws BusinessRuleException;
}
