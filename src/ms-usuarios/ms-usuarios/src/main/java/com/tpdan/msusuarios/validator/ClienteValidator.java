package com.tpdan.msusuarios.validator;

import com.tpdan.msusuarios.exceptions.BusinessRuleException;
import com.tpdan.msusuarios.model.Cliente;

public interface ClienteValidator {
    void validarCreacion(Cliente cliente) throws BusinessRuleException;
    void validarEliminacion(Integer id) throws BusinessRuleException;
}
