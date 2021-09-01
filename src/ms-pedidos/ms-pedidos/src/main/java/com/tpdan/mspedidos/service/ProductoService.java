package com.tpdan.mspedidos.service;

import com.tpdan.mspedidos.exceptions.BusinessRuleException;
import com.tpdan.mspedidos.model.dto.Producto;

import java.util.List;

public interface ProductoService {
    List<Producto> buscarProductosPorId(List<Integer>ids) throws BusinessRuleException;
}
