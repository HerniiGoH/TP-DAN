package com.tpdan.mspedidos.service;

import com.tpdan.mspedidos.exceptions.BusinessRuleException;
import com.tpdan.mspedidos.model.dto.RiesgoBCRA;

public interface BCRAService {
    RiesgoBCRA obtenerRiesgoPorCliente(String cuit) throws BusinessRuleException;
}
