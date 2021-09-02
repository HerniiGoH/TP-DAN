package com.tpdan.mspedidos.service.impl;

import com.tpdan.mspedidos.exceptions.BusinessRuleException;
import com.tpdan.mspedidos.model.dto.Obra;
import com.tpdan.mspedidos.service.ClienteService;
import com.tpdan.mspedidos.service.WebClientService;
import org.springframework.stereotype.Service;
import reactor.util.StringUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ClienteServiceImpl implements ClienteService {

    private final WebClientService webClientService;

    public ClienteServiceImpl(WebClientService webClientService){
        this.webClientService = webClientService;
    }

    @Override
    public List<Obra> buscarObrasPorId(List<Integer> ids) throws BusinessRuleException {
        Map<String, String> mapIds = new HashMap<>();
        mapIds.put("ids", StringUtils.collectionToCommaDelimitedString(ids));
        return Arrays.asList(webClientService.get(Obra[].class, "", mapIds));
    }

    @Override
    public List<Obra> buscarObrasPorCliente(Integer id, String cuit) throws BusinessRuleException {
        return Arrays.asList(webClientService.get(Obra[].class, "", id, cuit));
    }
}
