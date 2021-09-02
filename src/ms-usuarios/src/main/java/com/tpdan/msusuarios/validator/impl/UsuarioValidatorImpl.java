package com.tpdan.msusuarios.validator.impl;

import com.tpdan.msusuarios.exceptions.BusinessRuleException;
import com.tpdan.msusuarios.exceptions.UsuarioExistenteException;
import com.tpdan.msusuarios.model.Usuario;
import com.tpdan.msusuarios.service.UsuarioService;
import com.tpdan.msusuarios.validator.UsuarioValidator;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UsuarioValidatorImpl implements UsuarioValidator {

    private final UsuarioService usuarioService;

    public UsuarioValidatorImpl(@Lazy UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }

    @Override
    public void validarCreacion(Usuario usuario) throws BusinessRuleException {
        Optional<Usuario> usuarioOptional = usuarioService.buscarUsuarioPorNombre(usuario.getUser());
        if(usuarioOptional.isPresent()){
            throw new UsuarioExistenteException();
        }
    }
}
