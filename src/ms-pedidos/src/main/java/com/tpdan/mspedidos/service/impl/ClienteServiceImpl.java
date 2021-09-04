package com.tpdan.mspedidos.service.impl;

import com.tpdan.mspedidos.exceptions.BusinessRuleException;
import com.tpdan.mspedidos.model.dto.Cliente;
import com.tpdan.mspedidos.model.dto.Obra;
import com.tpdan.mspedidos.service.ClienteService;
import com.tpdan.mspedidos.service.WebClientService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.StringUtils;

import java.util.*;

@Service
public class ClienteServiceImpl implements ClienteService {

    private final WebClientService webClientService;

    @Value("${usuarios.buscar-obras-por-id}")
    private String URL_ID;
    @Value("${usuarios.buscar-obras-por-cliente}")
    private String URL_OBRA_POR_CLIENTE;
    @Value("${usuarios.buscar-cliente-por-id-obra}")
    private String URL_CLIENTE_POR_ID_OBRA;

    public ClienteServiceImpl(WebClientService webClientService){
        this.webClientService = webClientService;
    }

    @Override
    public List<Obra> buscarObrasPorId(List<Integer> ids) throws BusinessRuleException {
        Map<String, Object> mapIds = new HashMap<>();
        mapIds.put("ids", StringUtils.collectionToCommaDelimitedString(ids));
        return Arrays.asList(webClientService.get(Obra[].class, URL_ID, mapIds));
    }

    @Override
    public List<Obra> buscarObrasPorCliente(Integer id, String cuit) throws BusinessRuleException {
        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        map.put("cuit", cuit);
        return Arrays.asList(webClientService.get(Obra[].class, URL_OBRA_POR_CLIENTE, map));
    }

    @Override
    public Cliente buscarClientePorIdObra(Integer id) throws BusinessRuleException {
        Map<String, Object> map = new HashMap<>();
        map.put("idObra", id);
        return webClientService.get(Cliente.class, URL_CLIENTE_POR_ID_OBRA, map);
    }


}
