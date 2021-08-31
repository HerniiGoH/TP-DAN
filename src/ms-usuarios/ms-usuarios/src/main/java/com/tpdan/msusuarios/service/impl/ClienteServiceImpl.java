package com.tpdan.msusuarios.service.impl;

import com.tpdan.msusuarios.exceptions.BusinessRuleException;
import com.tpdan.msusuarios.model.Cliente;
import com.tpdan.msusuarios.repository.ClienteRepository;
import com.tpdan.msusuarios.service.ClienteService;
import com.tpdan.msusuarios.service.UsuarioService;
import com.tpdan.msusuarios.validator.ClienteValidator;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;
    private final ClienteValidator clienteValidator;
    private final UsuarioService usuarioService;

    public ClienteServiceImpl(ClienteRepository clienteRepository, ClienteValidator clienteValidator, UsuarioService usuarioService){
        this.clienteRepository = clienteRepository;
        this.clienteValidator = clienteValidator;
        this.usuarioService = usuarioService;
    }

    @Override
    public List<Cliente> buscarTodos() {
        return clienteRepository.findAll();
    }

    @Override
    public Optional<Cliente> buscarClientePorId(Integer id) {
        return clienteRepository.findById(id);
    }

    @Override
    public Optional<List<Cliente>> buscarCliente(Integer id, String cuit, String razonSocial, String mail, Double maxCuentaCorriente, Boolean habilitadoOnline) {
        return clienteRepository.findAllByQuerySQL(id, cuit, razonSocial, mail, maxCuentaCorriente, habilitadoOnline);
    }

    @Override
    public Cliente crearCliente(Cliente nuevoCliente) throws BusinessRuleException {
        clienteValidator.validarCreacion(nuevoCliente);
        nuevoCliente.setUsuario(usuarioService.crearUsuario(nuevoCliente.getUsuario()));
        nuevoCliente.getObras().forEach(obra -> obra.setCliente(nuevoCliente));
        return clienteRepository.save(nuevoCliente);
    }

    @Override
    public Cliente actualizarCliente(Cliente nuevoCliente) {
        return clienteRepository.save(nuevoCliente);
    }

    @Override
    public void borrarCliente(Integer id) throws BusinessRuleException{
        clienteValidator.validarEliminacion(id);
        //TODO valdiar que no tenga pedidos
        clienteRepository.deleteById(id);
    }
}
