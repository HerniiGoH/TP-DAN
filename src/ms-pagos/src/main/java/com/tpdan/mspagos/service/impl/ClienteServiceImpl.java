package com.tpdan.mspagos.service.impl;

import com.tpdan.mspagos.exceptions.BusinessRuleException;
import com.tpdan.mspagos.model.dto.Cliente;
import com.tpdan.mspagos.service.ClienteService;
import com.tpdan.mspagos.service.WebClientService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ClienteServiceImpl implements ClienteService {
    private final WebClientService webClientService;

    @Value("${usuarios.buscar-cliente-por-id}")
    private String URL_CLIENTE;
    @Value("${usuarios.buscar-lista-clientes-por-id}")
    private String URL_LISTA_CLIENTES;

    public ClienteServiceImpl(WebClientService webClientService) {
        this.webClientService = webClientService;
    }

    @Override
    public Cliente bucarClientePorId(Integer id) throws BusinessRuleException {
        return webClientService.get(Cliente.class,URL_CLIENTE,new HashMap<>(), id);
    }

    @Override
    public List<Cliente> buscarClientesPorId(List<Integer> ids) throws BusinessRuleException {
        Map<String, Object> mapIds = new HashMap<>();
        mapIds.put("idsCliente", StringUtils.collectionToCommaDelimitedString(ids));
        return Arrays.asList(webClientService.get(Cliente[].class, URL_LISTA_CLIENTES, mapIds));
    }
}
