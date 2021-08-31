package com.tpdan.mspedidos.service.impl;

import com.tpdan.mspedidos.model.DetallePedido;
import com.tpdan.mspedidos.model.Pedido;
import com.tpdan.mspedidos.repository.DetallePedidoRepository;
import com.tpdan.mspedidos.repository.PedidoRepository;
import com.tpdan.mspedidos.service.PedidoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoServiceImpl implements PedidoService {

    private final PedidoRepository pedidoRepository;
    private final DetallePedidoRepository detallePedidoRepository;

    public PedidoServiceImpl(PedidoRepository pedidoRepository, DetallePedidoRepository detallePedidoRepository){
        this.pedidoRepository = pedidoRepository;
        this.detallePedidoRepository = detallePedidoRepository;
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
    public Pedido crearPedido(Pedido nuevoPedido) {
        //TODO validaciones
        return pedidoRepository.save(nuevoPedido);
    }

    @Override
    public DetallePedido crearDetallePedido(DetallePedido nuevoDetallePedido, Integer id) {
        Optional<Pedido> pedidoOptional = pedidoRepository.findById(id);
        //TODO validar crear detalle
        if(pedidoOptional.isPresent()){
            nuevoDetallePedido.setPedido(pedidoOptional.get());
            nuevoDetallePedido = detallePedidoRepository.save(nuevoDetallePedido);
            //TODO setear el producto
            return nuevoDetallePedido;
        }
        return null;
    }

    @Override
    public Pedido actualizarPedido(Pedido nuevoPedido) {
        return pedidoRepository.save(nuevoPedido);
    }

    @Override
    public DetallePedido actualizarDetallePedido(DetallePedido nuevoDetalle, Integer idPedido) {
        Optional<Pedido> pedidoOptional = pedidoRepository.findById(idPedido);
        //TODO validar actualizar detalle
        if(pedidoOptional.isPresent()){
            nuevoDetalle.setPedido(pedidoOptional.get());
            nuevoDetalle = detallePedidoRepository.save(nuevoDetalle);
            //TODO buscar el producto
            return nuevoDetalle;
        }
        return null;
    }

    @Override
    public Optional<Pedido> actualizarEstadoPedido(Integer id, String estado) {

        return Optional.empty();
    }

    @Override
    public void borrarPedido(Integer id) {
        //TODO validar borrar pedido
        pedidoRepository.deleteById(id);
    }

    @Override
    public void borrarDetallePedido(Integer idPedido, Integer id) {
        Optional<Pedido> pedidoOptional = pedidoRepository.findById(idPedido);
        //TODO validar borrar detalle
        if(pedidoOptional.isPresent()){
            detallePedidoRepository.deleteById(id);
        }
    }
}
