package com.tpdan.mspedidos.service.impl;

import com.tpdan.mspedidos.exceptions.BusinessRuleException;
import com.tpdan.mspedidos.model.dto.Producto;
import com.tpdan.mspedidos.service.ProductoService;
import com.tpdan.mspedidos.service.WebClientService;
import org.springframework.stereotype.Service;
import reactor.util.StringUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductoServiceImpl implements ProductoService {

    private final WebClientService webClientService;

    public ProductoServiceImpl(WebClientService webClientService){
        this.webClientService = webClientService;
    }

    @Override
    public List<Producto> buscarProductosPorId(List<Integer> ids) throws BusinessRuleException {
        Map<String, String> mapIds = new HashMap<>();
        mapIds.put("ids", StringUtils.collectionToCommaDelimitedString(ids));
        return Arrays.asList(webClientService.get(Producto[].class, "", mapIds));
    }
}
