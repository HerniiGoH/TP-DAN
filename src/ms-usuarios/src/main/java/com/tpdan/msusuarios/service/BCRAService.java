package com.tpdan.msusuarios.service;

import com.tpdan.msusuarios.exceptions.BusinessRuleException;
import com.tpdan.msusuarios.model.dto.RiesgoBCRA;

public interface BCRAService {
    RiesgoBCRA buscarRiesgoPorCuit(String cuit) throws BusinessRuleException;
}
