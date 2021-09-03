package com.tpdan.msusuarios.validator;

import com.tpdan.msusuarios.exceptions.BusinessRuleException;
import com.tpdan.msusuarios.model.Obra;

public interface ObraValidador {
    void validarEliminacion(Integer id) throws BusinessRuleException;
}
