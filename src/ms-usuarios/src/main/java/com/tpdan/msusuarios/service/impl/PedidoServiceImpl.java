package com.tpdan.msusuarios.service.impl;

import com.tpdan.msusuarios.exceptions.BusinessRuleException;
import com.tpdan.msusuarios.model.dto.Pedido;
import com.tpdan.msusuarios.service.PedidoService;
import com.tpdan.msusuarios.service.WebClientService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PedidoServiceImpl implements PedidoService {
    private final WebClientService webClientService;

    @Value("${pedidos.obtener-pedidos-por-cliente}")
    private String URL;

    public PedidoServiceImpl(WebClientService webClientService){
        this.webClientService = webClientService;
    }

    @Override
    public List<Pedido> buscarPedidosPorCliente(Integer id, String cuit) throws BusinessRuleException {
        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        map.put("cuit", cuit);
        return Arrays.asList(webClientService.get(Pedido[].class, URL, map));
    }
}
