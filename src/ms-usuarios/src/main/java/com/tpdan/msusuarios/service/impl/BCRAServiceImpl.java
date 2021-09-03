package com.tpdan.msusuarios.service.impl;

import com.tpdan.msusuarios.exceptions.BusinessRuleException;
import com.tpdan.msusuarios.model.dto.RiesgoBCRA;
import com.tpdan.msusuarios.service.BCRAService;
import com.tpdan.msusuarios.service.WebClientService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class BCRAServiceImpl implements BCRAService {
    private final WebClientService webClientService;

    @Value("${bcra.buscar-riesgo-por-cuit}")
    private String URL;

    public BCRAServiceImpl(WebClientService webClientService){
        this.webClientService = webClientService;
    }
    @Override
    public RiesgoBCRA buscarRiesgoPorCuit(String cuit) throws BusinessRuleException {
        return webClientService.get(RiesgoBCRA.class, URL, cuit);
    }
}
