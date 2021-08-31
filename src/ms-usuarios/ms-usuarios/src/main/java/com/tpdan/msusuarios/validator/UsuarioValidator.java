package com.tpdan.msusuarios.validator;

import com.tpdan.msusuarios.exceptions.BusinessRuleException;
import com.tpdan.msusuarios.model.Usuario;

public interface UsuarioValidator {
    void validarCreacion(Usuario usuario) throws BusinessRuleException;
}
