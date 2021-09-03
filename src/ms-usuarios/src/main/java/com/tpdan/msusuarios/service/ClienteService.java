package com.tpdan.msusuarios.service;

import com.tpdan.msusuarios.exceptions.BusinessRuleException;
import com.tpdan.msusuarios.model.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteService {
    List<Cliente> buscarTodos();
    Optional<Cliente> buscarClientePorId(Integer id);
    Optional<List<Cliente>> buscarCliente(Integer id, String cuit, String razonSocial, String mail, Double maxCuentaCorriente, Boolean habilitadoOnline);
    Cliente buscarClientePorIdObra(Integer id);
    Cliente crearCliente(Cliente nuevoCliente) throws BusinessRuleException;
    Cliente actualizarCliente(Cliente nuevoCliente);
    void borrarCliente(Integer id) throws BusinessRuleException;
}
