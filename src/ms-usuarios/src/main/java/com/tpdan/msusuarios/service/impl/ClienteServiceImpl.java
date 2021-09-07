package com.tpdan.msusuarios.service.impl;

import com.tpdan.msusuarios.exceptions.BusinessRuleException;
import com.tpdan.msusuarios.exceptions.ClienteConPedidosException;
import com.tpdan.msusuarios.model.Cliente;
import com.tpdan.msusuarios.model.dto.RiesgoBCRA;
import com.tpdan.msusuarios.repository.ClienteRepository;
import com.tpdan.msusuarios.service.BCRAService;
import com.tpdan.msusuarios.service.ClienteService;
import com.tpdan.msusuarios.service.UsuarioService;
import com.tpdan.msusuarios.validator.ClienteValidator;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;
    private final ClienteValidator clienteValidator;
    private final UsuarioService usuarioService;

    public ClienteServiceImpl(ClienteRepository clienteRepository,
                              ClienteValidator clienteValidator,
                              UsuarioService usuarioService){
        this.clienteRepository = clienteRepository;
        this.clienteValidator = clienteValidator;
        this.usuarioService = usuarioService;
    }

    @Override
    public List<Cliente> buscarTodos(List<Integer> ids) {
       return ids==null?clienteRepository.findAll():clienteRepository.findAllById(ids);
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
    public Cliente buscarClientePorIdObra(Integer id) {
        return clienteRepository.findByIdObra(id);
    }

    @Override
    public Cliente crearCliente(Cliente nuevoCliente) throws BusinessRuleException {
        RiesgoBCRA riesgoBCRA = clienteValidator.validarCreacion(nuevoCliente);
        nuevoCliente.setUsuario(usuarioService.crearUsuario(nuevoCliente));
        nuevoCliente.getObras().forEach(obra -> obra.setCliente(nuevoCliente));
        nuevoCliente.setHabilitadoOnline(RiesgoBCRA.esSituacionValida(riesgoBCRA));
        //TODO ver que hacer con MAX CUENTA CORRIENTE
        nuevoCliente.setMaxCuentaCorriente(nuevoCliente.getHabilitadoOnline()?50000.0:0.0);
        return clienteRepository.save(nuevoCliente);
    }

    @Override
    public Cliente actualizarCliente(Cliente nuevoCliente) {
        return clienteRepository.save(nuevoCliente);
    }

    @Override
    public void borrarCliente(Integer id) throws BusinessRuleException{
        try{
            clienteValidator.validarEliminacion(id);
        }catch(ClienteConPedidosException e){
            Cliente cliente = clienteRepository.findById(id).orElseThrow();
            cliente.setFechaBaja(LocalDateTime.now());
            clienteRepository.save(cliente);
        }
        clienteRepository.deleteById(id);
    }
}
