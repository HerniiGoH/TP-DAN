package com.tpdan.msusuarios.service.impl;

import com.tpdan.msusuarios.exceptions.BusinessRuleException;
import com.tpdan.msusuarios.model.dto.Pedido;
import com.tpdan.msusuarios.service.PedidoService;
import com.tpdan.msusuarios.service.WebClientService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class PedidoServiceImpl implements PedidoService {
    private final WebClientService webClientService;

    public PedidoServiceImpl(WebClientService webClientService){
        this.webClientService = webClientService;
    }

    @Override
    public List<Pedido> buscarPedidosPorCliente(Integer id, String cuit) throws BusinessRuleException {
        return Arrays.asList(webClientService.get(Pedido[].class, "", id, cuit));
    }
}
