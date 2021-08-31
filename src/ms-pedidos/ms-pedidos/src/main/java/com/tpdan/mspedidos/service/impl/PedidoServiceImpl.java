package com.tpdan.mspedidos.service.impl;

import com.tpdan.mspedidos.exceptions.BusinessRuleException;
import com.tpdan.mspedidos.model.DetallePedido;
import com.tpdan.mspedidos.model.Pedido;
import com.tpdan.mspedidos.repository.DetallePedidoRepository;
import com.tpdan.mspedidos.repository.PedidoRepository;
import com.tpdan.mspedidos.service.PedidoService;
import com.tpdan.mspedidos.validator.PedidoValidator;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoServiceImpl implements PedidoService {

    private final PedidoRepository pedidoRepository;
    private final DetallePedidoRepository detallePedidoRepository;
    private final PedidoValidator pedidoValidator;

    public PedidoServiceImpl(PedidoRepository pedidoRepository, DetallePedidoRepository detallePedidoRepository, PedidoValidator pedidoValidator){
        this.pedidoRepository = pedidoRepository;
        this.detallePedidoRepository = detallePedidoRepository;
        this.pedidoValidator = pedidoValidator;
    }

    @Override
    public List<Pedido> buscarTodos() {
        return pedidoRepository.findAll();
    }

    @Override
    public Optional<Pedido> buscarPedidoPorId(Integer id) {
        return pedidoRepository.findById(id);
    }

    @Override
    public Optional<List<Pedido>> buscarPedidosPorIdObra(Integer id) {
        return pedidoRepository.findByIdObra(id);
    }

    @Override
    public Optional<List<Pedido>> buscarPedidosPorCliente(Integer id, String cuit) {
        //TODO hacer esto
        return Optional.empty();
    }

    @Override
    public Optional<List<Pedido>> buscarPedidosPorEstado(String estado) {
        return pedidoRepository.buscarPedidoPorEstado(estado);
    }

    @Override
    public Optional<DetallePedido> buscarDetallePedidoPorId(Integer idPedido, Integer id) {
        if(pedidoRepository.existsById(idPedido)){
            return detallePedidoRepository.findById(id);
        }
        return Optional.empty();
    }

    @Override
    public Pedido crearPedido(Pedido nuevoPedido) throws BusinessRuleException {
        pedidoValidator.validarCreacion(nuevoPedido);
        return pedidoRepository.save(nuevoPedido);
    }

    @Override
    public DetallePedido crearDetallePedido(DetallePedido nuevoDetallePedido, Integer id) throws BusinessRuleException{
        pedidoValidator.validarCreacionDetalle(nuevoDetallePedido, id);
        nuevoDetallePedido.setPedido(buscarPedidoPorId(id).get());
        nuevoDetallePedido = detallePedidoRepository.save(nuevoDetallePedido);
        //TODO setear el producto
        return nuevoDetallePedido;
    }

    @Override
    public Pedido actualizarPedido(Pedido nuevoPedido) throws BusinessRuleException {
        pedidoValidator.validarActualizarPedido(nuevoPedido);
        return pedidoRepository.save(nuevoPedido);
    }

    @Override
    public DetallePedido actualizarDetallePedido(DetallePedido nuevoDetalle, Integer idPedido) throws BusinessRuleException{
        pedidoValidator.validarActualizarDetallePedido(nuevoDetalle, idPedido);
        nuevoDetalle.setPedido(buscarPedidoPorId(idPedido).get());
        nuevoDetalle = detallePedidoRepository.save(nuevoDetalle);
        //TODO buscar el producto
        return nuevoDetalle;
    }

    @Override
    public Pedido confirmarPedido(Integer id) throws BusinessRuleException {
        pedidoValidator.validarConfirmacion(id);
        Pedido pedido = buscarPedidoPorId(id).get();
        //TODO verificar stocks
        //TODO verificar saldo deudor
        return pedidoRepository.save(pedido);
    }

    @Override
    public void borrarPedido(Integer id) throws BusinessRuleException {
        pedidoValidator.validarBorrarPedido(id);
        pedidoRepository.deleteById(id);
    }

    @Override
    public void borrarDetallePedido(Integer idPedido, Integer id) throws BusinessRuleException {
        pedidoValidator.validarBorrarDetallePedido(idPedido, id);
        detallePedidoRepository.deleteById(id);
    }
}
