package com.tpdan.mspedidos.service.impl;

import com.tpdan.mspedidos.exceptions.BusinessRuleException;
import com.tpdan.mspedidos.model.DetallePedido;
import com.tpdan.mspedidos.model.dto.Producto;
import com.tpdan.mspedidos.service.ProductoService;
import com.tpdan.mspedidos.service.WebClientService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ProductoServiceImpl implements ProductoService {

    private final WebClientService webClientService;

    @Value("${productos.buscar-productos-por-id}")
    private String URL;
    @Value("${productos.buscar-productos-sin-stock}")
    private String URL_SIN_STOCK;

    public ProductoServiceImpl(WebClientService webClientService){
        this.webClientService = webClientService;
    }

    @Override
    public List<Producto> buscarProductosPorId(List<Integer> ids) throws BusinessRuleException {
        Map<String, Object> mapIds = new HashMap<>();
        mapIds.put("ids", StringUtils.collectionToCommaDelimitedString(ids));
        return Arrays.asList(webClientService.get(Producto[].class, URL, mapIds));
    }

    @Override
    public List<Producto> buscarProductosSinStock(List<DetallePedido> detallePedidos) throws BusinessRuleException {
        Map<String,Object> map = new HashMap<>();
        map.put("ids", StringUtils.collectionToCommaDelimitedString(detallePedidos.stream().map(DetallePedido::getProductoId).collect(Collectors.toUnmodifiableList())));
        map.put("cantidades", StringUtils.collectionToCommaDelimitedString(detallePedidos.stream().map(DetallePedido::getCantidad).collect(Collectors.toUnmodifiableList())));
        return Arrays.asList(webClientService.get(Producto[].class,URL_SIN_STOCK, map));
    }
}
