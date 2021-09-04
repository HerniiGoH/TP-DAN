package com.tpdan.msusuarios.service;

import com.tpdan.msusuarios.exceptions.BusinessRuleException;
import com.tpdan.msusuarios.model.Cliente;
import com.tpdan.msusuarios.model.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {
    Usuario crearUsuario(Cliente cliente) throws BusinessRuleException;
    Optional<Usuario> buscarUsuarioPorNombre(String mail);
    List<Usuario> buscarTodos();
}
