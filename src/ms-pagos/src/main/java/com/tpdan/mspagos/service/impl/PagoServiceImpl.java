package com.tpdan.mspagos.service.impl;

import com.tpdan.mspagos.exceptions.BusinessRuleException;
import com.tpdan.mspagos.model.Pago;
import com.tpdan.mspagos.model.dto.Cliente;
import com.tpdan.mspagos.model.dto.Pedido;
import com.tpdan.mspagos.repository.PagoRepository;
import com.tpdan.mspagos.service.ClienteService;
import com.tpdan.mspagos.service.PagoService;
import com.tpdan.mspagos.service.PedidoService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PagoServiceImpl implements PagoService {
    private final PagoRepository pagoRepository;
    private final ClienteService clienteService;
    private final PedidoService pedidoService;

    public PagoServiceImpl(PagoRepository pagoRepository,
                           ClienteService clienteService,
                           PedidoService pedidoService) {
        this.pagoRepository = pagoRepository;
        this.clienteService = clienteService;
        this.pedidoService = pedidoService;
    }

    @Override
    public List<Pago> buscarTodos() throws BusinessRuleException {
        List<Pago>pagos= pagoRepository.findAll();

        Map<String, List<Integer>> map = obtenerListasIds(pagos);
        inicializarPagos(pagos, clienteService.buscarClientesPorId(map.get("idsCliente")), pedidoService.buscarPedidosPorId(map.get("idsPedido")));

        return pagos;
    }

    @Override
    public Pago crearPago(Pago pago) {
        return pagoRepository.save(pago);
    }

    @Override
    public Optional<List<Pago>> buscarPorIdCliente(Integer clienteId) throws BusinessRuleException {
        Optional<List<Pago>>pagosOpt = pagoRepository.findAllByClienteId(clienteId);

        if(pagosOpt.isPresent()){
            Map<String, List<Integer>> map = obtenerListasIds(pagosOpt.get());
            inicializarPagos(pagosOpt.get(), clienteService.buscarClientesPorId(map.get("idsCliente")), pedidoService.buscarPedidosPorId(map.get("idsPedido")));
        }

        return pagosOpt;
    }

    private Map<String, List<Integer>> obtenerListasIds(final List<Pago> pagos){
        Set<Integer> idsCliente = new HashSet<>();
        Set<Integer> idsPedido = new HashSet<>();

        pagos.forEach(pago->{
            idsCliente.add(pago.getClienteId());
            idsPedido.add(pago.getPedidoId());
        });

        Map<String, List<Integer>> map = new HashMap<>();
        map.put("idsCliente", new ArrayList<>(idsCliente));
        map.put("idsPedido", new ArrayList<>(idsPedido));

        return map;
    }

    private void inicializarPagos(List<Pago>pagos, List<Cliente> clientes, List<Pedido> pedidos){
        for(Pago pago : pagos){
            pago.setCliente(clientes.stream().filter(c->Objects.equals(c.getId(), pago.getClienteId())).findFirst().orElseThrow());
            pago.setPedido(pedidos.stream().filter(p->Objects.equals(p.getId(), pago.getPedidoId())).findFirst().orElseThrow());
        }
    }
}
