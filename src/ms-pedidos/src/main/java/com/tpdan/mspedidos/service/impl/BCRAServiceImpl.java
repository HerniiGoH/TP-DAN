package com.tpdan.mspedidos.service.impl;

import com.tpdan.mspedidos.exceptions.BusinessRuleException;
import com.tpdan.mspedidos.model.dto.RiesgoBCRA;
import com.tpdan.mspedidos.service.BCRAService;
import com.tpdan.mspedidos.service.WebClientService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class BCRAServiceImpl implements BCRAService {

    private final WebClientService webClientService;

    @Value("${bcra.buscar-riesgo-por-cuit}")
    private String URL;

    public BCRAServiceImpl(WebClientService webClientService){
        this.webClientService = webClientService;
    }

    @Override
    public RiesgoBCRA obtenerRiesgoPorCliente(String cuit) throws BusinessRuleException {
        Map<String, Object> map = new HashMap<>();
        map.put("cuit", cuit);
        return webClientService.get(RiesgoBCRA.class,URL, map);
    }
}
