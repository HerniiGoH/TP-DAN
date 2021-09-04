package com.tpdan.msusuarios.service.impl;

import com.tpdan.msusuarios.exceptions.BusinessRuleException;
import com.tpdan.msusuarios.model.Cliente;
import com.tpdan.msusuarios.model.Usuario;
import com.tpdan.msusuarios.repository.UsuarioRepository;
import com.tpdan.msusuarios.service.UsuarioService;
import com.tpdan.msusuarios.validator.UsuarioValidator;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioValidator usuarioValidator;
    private final UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(UsuarioValidator usuarioValidator, UsuarioRepository usuarioRepository){
        this.usuarioValidator = usuarioValidator;
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public Usuario crearUsuario(Cliente cliente) throws BusinessRuleException {
        Usuario usuario = cliente.getUsuario();
        usuario.setUser(cliente.getMail());
        usuario.setPassword("1234");
        usuarioValidator.validarCreacion(usuario);
        return usuarioRepository.save(usuario);
    }

    @Override
    public Optional<Usuario> buscarUsuarioPorNombre(String mail) {
        return usuarioRepository.findUsuarioByUser(mail);
    }

    @Override
    public List<Usuario> buscarTodos() {
        return usuarioRepository.findAll();
    }
}
