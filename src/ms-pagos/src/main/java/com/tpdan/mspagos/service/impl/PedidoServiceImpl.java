package com.tpdan.mspagos.service.impl;

import com.tpdan.mspagos.exceptions.BusinessRuleException;
import com.tpdan.mspagos.model.dto.Cliente;
import com.tpdan.mspagos.model.dto.Pedido;
import com.tpdan.mspagos.service.PedidoService;
import com.tpdan.mspagos.service.WebClientService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PedidoServiceImpl implements PedidoService{
    private final WebClientService webClientService;

    @Value("${pedidos.buscar-pedido-por-id}")
    private String URL_PEDIDO;
    @Value("${pedidos.buscar-lista-pedidos-por-id}")
    private String URL_LISTA_PEDIDOS;

    public PedidoServiceImpl(WebClientService webClientService) {
        this.webClientService = webClientService;
    }

    @Override
    public Pedido buscarPedidoPorId(Integer id) throws BusinessRuleException {
        return webClientService.get(Pedido.class, URL_PEDIDO, new HashMap<>(), id);
    }

    @Override
    public List<Pedido> buscarPedidosPorId(List<Integer> ids) throws BusinessRuleException {
        Map<String, Object> mapIds = new HashMap<>();
        mapIds.put("idsPedido", StringUtils.collectionToCommaDelimitedString(ids));
        return Arrays.asList(webClientService.get(Pedido[].class, URL_LISTA_PEDIDOS, mapIds));
    }
}
