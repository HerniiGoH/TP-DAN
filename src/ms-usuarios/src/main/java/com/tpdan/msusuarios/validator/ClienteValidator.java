package com.tpdan.msusuarios.validator;

import com.tpdan.msusuarios.exceptions.BusinessRuleException;
import com.tpdan.msusuarios.model.Cliente;
import com.tpdan.msusuarios.model.dto.RiesgoBCRA;

public interface ClienteValidator {
    RiesgoBCRA validarCreacion(Cliente cliente) throws BusinessRuleException;
    void validarEliminacion(Integer id) throws BusinessRuleException;
}
