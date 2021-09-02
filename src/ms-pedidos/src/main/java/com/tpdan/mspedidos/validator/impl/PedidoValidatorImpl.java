package com.tpdan.mspedidos.validator.impl;

import com.tpdan.mspedidos.exceptions.*;
import com.tpdan.mspedidos.model.DetallePedido;
import com.tpdan.mspedidos.model.Pedido;
import com.tpdan.mspedidos.model.enumerations.EstadoPedido;
import com.tpdan.mspedidos.service.PedidoService;
import com.tpdan.mspedidos.validator.PedidoValidator;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Optional;

@Component
public class PedidoValidatorImpl implements PedidoValidator {

    private final PedidoService pedidoService;

    public PedidoValidatorImpl(@Lazy PedidoService pedidoService){
        this.pedidoService = pedidoService;
    }

    @Override
    public void validarCreacion(Pedido pedido) throws BusinessRuleException {
        if(pedido.getObraId() == null || pedido.getObra() == null){
            throw new PedidoSinObraException();
        }
        if(pedido.getDetallePedido() == null || pedido.getDetallePedido().isEmpty()){
            throw new PedidoSinDetalleException();
        }
        for(DetallePedido detallePedido : pedido.getDetallePedido()){
            if(detallePedido.getProductoId()==null || detallePedido.getProducto()==null || detallePedido.getCantidad()==null || detallePedido.getCantidad()==0){
                throw new DetalleSinProductosException();
            }
        }
    }

    @Override
    public void validarCreacionDetalle(DetallePedido detallePedido, Integer id) throws BusinessRuleException {
        Optional<Pedido> pedidoOptional = pedidoService.buscarPedidoPorId(id);
        if(pedidoOptional.isEmpty()){
            throw new PedidoInexistenteException();
        }
        if(!pedidoOptional.get().getEstadoPedido().equals(EstadoPedido.NUEVO)){
            throw new PedidoNoModificableException();
        }
        if(detallePedido.getProductoId()==null || detallePedido.getProducto()==null || detallePedido.getCantidad()==null || detallePedido.getCantidad()==0){
            throw new DetalleSinProductosException();
        }
    }

    @Override
    public void validarActualizarPedido(Pedido pedido) throws BusinessRuleException {
        if(!pedido.getEstadoPedido().equals(EstadoPedido.NUEVO)){
            throw new PedidoNoModificableException();
        }
    }

    @Override
    public void validarActualizarDetallePedido(DetallePedido detallePedido, Integer id) throws BusinessRuleException {
        Optional<Pedido> pedidoOptional = pedidoService.buscarPedidoPorId(id);
        if(pedidoOptional.isEmpty()){
            throw new PedidoInexistenteException();
        }
        if(!pedidoOptional.get().getEstadoPedido().equals(EstadoPedido.NUEVO)){
            throw new PedidoNoModificableException();
        }
        if(detallePedido.getProductoId()==null || detallePedido.getProducto()==null || detallePedido.getCantidad()==null || detallePedido.getCantidad()==0){
            throw new DetalleSinProductosException();
        }
    }

    @Override
    public void validarBorrarPedido(Integer id) throws BusinessRuleException {
        Optional<Pedido> pedidoOptional = pedidoService.buscarPedidoPorId(id);
        if(pedidoOptional.isEmpty()){
            throw new PedidoInexistenteException();
        }
        if(!pedidoOptional.get().getEstadoPedido().equals(EstadoPedido.NUEVO)){
            throw new PedidoNoModificableException();
        }
    }

    @Override
    public void validarBorrarDetallePedido(Integer idPedido, Integer id) throws BusinessRuleException {
        Optional<Pedido> pedidoOptional = pedidoService.buscarPedidoPorId(id);
        if(pedidoOptional.isEmpty()){
            throw new PedidoInexistenteException();
        }
        if(!pedidoOptional.get().getEstadoPedido().equals(EstadoPedido.NUEVO)){
            throw new PedidoNoModificableException();
        }
        if(pedidoOptional.get().getDetallePedido().stream().anyMatch(detallePedido -> Objects.equals(detallePedido.getId(), id))) {
            throw new PedidoInexistenteException();
        }
    }

    @Override
    public void validarConfirmacion(Integer id) throws BusinessRuleException {
        Optional<Pedido> pedidoOptional = pedidoService.buscarPedidoPorId(id);
        if(pedidoOptional.isEmpty()){
            throw new PedidoInexistenteException();
        }
        if(!pedidoOptional.get().getEstadoPedido().equals(EstadoPedido.NUEVO)){
            throw new PedidoNoModificableException();
        }
    }
}
