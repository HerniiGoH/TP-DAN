package com.tpdan.mspedidos.service.impl;

import com.tpdan.mspedidos.exceptions.BusinessRuleException;
import com.tpdan.mspedidos.exceptions.PedidoInexistenteException;
import com.tpdan.mspedidos.exceptions.RiesgoBCRAException;
import com.tpdan.mspedidos.model.DetallePedido;
import com.tpdan.mspedidos.model.Pedido;
import com.tpdan.mspedidos.model.dto.Cliente;
import com.tpdan.mspedidos.model.dto.Obra;
import com.tpdan.mspedidos.model.dto.Producto;
import com.tpdan.mspedidos.model.dto.RiesgoBCRA;
import com.tpdan.mspedidos.model.enumerations.EstadoPedido;
import com.tpdan.mspedidos.repository.DetallePedidoRepository;
import com.tpdan.mspedidos.repository.PedidoRepository;
import com.tpdan.mspedidos.service.*;
import com.tpdan.mspedidos.validator.PedidoValidator;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class PedidoServiceImpl implements PedidoService {

    private final PedidoRepository pedidoRepository;
    private final DetallePedidoRepository detallePedidoRepository;
    private final PedidoValidator pedidoValidator;
    private final ClienteService clienteService;
    private final ProductoService productoService;
    private final BCRAService bcraService;
    private final RabbitService rabbitService;

    public PedidoServiceImpl(PedidoRepository pedidoRepository,
                             DetallePedidoRepository detallePedidoRepository,
                             PedidoValidator pedidoValidator,
                             ClienteService clienteService,
                             ProductoService productoService,
                             BCRAService bcraService,
                             RabbitService rabbitService){
        this.pedidoRepository = pedidoRepository;
        this.detallePedidoRepository = detallePedidoRepository;
        this.pedidoValidator = pedidoValidator;
        this.clienteService = clienteService;
        this.productoService = productoService;
        this.bcraService = bcraService;
        this.rabbitService = rabbitService;
    }

    @Override
    public List<Pedido> buscarTodos() throws BusinessRuleException{
        List<Pedido> pedidosEncontrados = pedidoRepository.findAll();

        Map<String, List<Integer>> map = obtenerListasIds(pedidosEncontrados);
        inicializarListaPedidos(pedidosEncontrados, clienteService.buscarObrasPorId(map.get("idsObra")), productoService.buscarProductosPorId(map.get("ids")));

        return pedidosEncontrados;
    }

    @Override
    public Optional<Pedido> buscarPedidoPorId(Integer id) throws BusinessRuleException {

        Optional<Pedido> pedidoEncontrado = pedidoRepository.findById(id);

        if(pedidoEncontrado.isPresent()){

            Map<String, List<Integer>> map = obtenerListasIds(List.of(pedidoEncontrado.get()));
            inicializarListaPedidos(List.of(pedidoEncontrado.get()), clienteService.buscarObrasPorId(map.get("idsObra")), productoService.buscarProductosPorId(map.get("ids")));
        }
        return pedidoEncontrado;
    }

    @Override
    public Optional<List<Pedido>> buscarPedidosPorIdObra(Integer id) throws BusinessRuleException {

        Optional<List<Pedido>> pedidosEncontradosOpt = pedidoRepository.findByIdObra(id);

        if(pedidosEncontradosOpt.isPresent()){
            Map<String, List<Integer>> map = obtenerListasIds(pedidosEncontradosOpt.get());
            inicializarListaPedidos(pedidosEncontradosOpt.get(), clienteService.buscarObrasPorId(map.get("idsObra")), productoService.buscarProductosPorId(map.get("ids")));

        }

        return pedidosEncontradosOpt;
    }

    @Override
    public Optional<List<Pedido>> buscarPedidosPorCliente(Integer id, String cuit) throws BusinessRuleException {
        List<Obra> obras = clienteService.buscarObrasPorCliente(id, cuit);

        Optional<List<Pedido>> pedidosEncontradosOpt = pedidoRepository.findPedidosByObraIdIsIn(obras.stream().map(Obra::getId).collect(Collectors.toUnmodifiableList()));

        if(pedidosEncontradosOpt.isPresent()){
            Map<String, List<Integer>> map = obtenerListasIds(pedidosEncontradosOpt.get());
            inicializarListaPedidos(pedidosEncontradosOpt.get(), obras, productoService.buscarProductosPorId(map.get("ids")));
        }

        return pedidosEncontradosOpt;
    }

    @Override
    public Optional<List<Pedido>> buscarPedidosPorEstado(String estado) throws BusinessRuleException {
        Optional<List<Pedido>> pedidosEncontradosOpt = pedidoRepository.buscarPedidoPorEstado(estado);
            if(pedidosEncontradosOpt.isPresent()){
                Map<String, List<Integer>> map = obtenerListasIds(pedidosEncontradosOpt.get());
                inicializarListaPedidos(pedidosEncontradosOpt.get(), clienteService.buscarObrasPorId(map.get("idsObra")), productoService.buscarProductosPorId(map.get("ids")));

            }
        return pedidosEncontradosOpt;
    }

    @Override
    public Optional<DetallePedido> buscarDetallePedidoPorId(Integer idPedido, Integer id) throws BusinessRuleException {
        if(pedidoRepository.existsById(idPedido)){
            Optional<DetallePedido> detallePedidoOptional = detallePedidoRepository.findById(id);

            if(detallePedidoOptional.isPresent()){
                List<Integer> ids = new ArrayList<>(1);
                ids.add(detallePedidoOptional.get().getProductoId());
                detallePedidoOptional.get().setProducto(productoService.buscarProductosPorId(ids).get(0));
            }

            return detallePedidoOptional;
        }
        throw new PedidoInexistenteException();
    }

    @Override
    public Pedido crearPedido(Pedido nuevoPedido) throws BusinessRuleException {
        pedidoValidator.validarCreacion(nuevoPedido);
        return pedidoRepository.save(nuevoPedido);
    }

    @Override
    public DetallePedido crearDetallePedido(DetallePedido nuevoDetallePedido, Integer id) throws BusinessRuleException{
        Pedido pedido = pedidoValidator.validarCreacionDetalle(nuevoDetallePedido, id);
        nuevoDetallePedido.setPedido(pedido);
        return detallePedidoRepository.save(nuevoDetallePedido);
    }

    @Override
    public Pedido actualizarPedido(Pedido nuevoPedido) throws BusinessRuleException {
        pedidoValidator.validarActualizarPedido(nuevoPedido);
        return pedidoRepository.save(nuevoPedido);
    }

    @Override
    public DetallePedido actualizarDetallePedido(DetallePedido nuevoDetalle, Integer idPedido) throws BusinessRuleException{
        Pedido pedido = pedidoValidator.validarActualizarDetallePedido(nuevoDetalle, idPedido);
        nuevoDetalle.setPedido(pedido);
        return detallePedidoRepository.save(nuevoDetalle);
    }

    @Override
    public Pedido confirmarPedido(Integer id) throws BusinessRuleException {
        Pedido pedido = pedidoValidator.validarConfirmacion(id);
        if(!productoService.buscarProductosSinStock(pedido.getDetallePedido()).isEmpty()){
            pedido.setEstadoPedido(EstadoPedido.PENDIENTE);
        }else{
            Cliente cliente = clienteService.buscarClientePorIdObra(pedido.getObraId());
            if(cliente.getMaximoCuentaCorriente().compareTo(pedido.getPrecio())<0){
                if(!bcraService.obtenerRiesgoPorCliente(cliente.getCuit()).equals(RiesgoBCRA.RIESGO_BAJO)){
                    //TODO ver si rechazamos el pedido y lo guardamos
                    throw new RiesgoBCRAException();
                }
            }
            pedido.setEstadoPedido(EstadoPedido.ACEPTADO);
            rabbitService.enviarMensaje(pedido.getDetallePedido());
        }
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

    private void inicializarListaPedidos(List<Pedido> pedidos, List<Obra> obras, List<Producto> productos){
        for(Pedido pedido : pedidos){
            pedido.setObra(obras.stream().filter(o-> Objects.equals(o.getId(), pedido.getObraId())).findFirst().get());
            pedido.getDetallePedido().forEach(dp-> dp.setProducto(productos.stream().filter(p -> Objects.equals(p.getId(), dp.getProductoId())).findFirst().get()));
        }
    }

    private Map<String, List<Integer>> obtenerListasIds(final List<Pedido> pedidos){
        Set<Integer> ids = new HashSet<>();
        Set<Integer> idsObra = new HashSet<>();

        pedidos.forEach(pedido -> {
            idsObra.add(pedido.getObraId());
            pedido.getDetallePedido().forEach(detallePedido -> ids.add(detallePedido.getProductoId()));
        });
        Map<String, List<Integer>> map = new HashMap<>();
        map.put("ids", new ArrayList<>(ids));
        map.put("idsObra", new ArrayList<>(idsObra));

        return map;
    }
}
