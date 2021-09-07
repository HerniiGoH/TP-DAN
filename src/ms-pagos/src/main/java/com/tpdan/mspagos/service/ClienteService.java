package com.tpdan.mspagos.service;

import com.tpdan.mspagos.exceptions.BusinessRuleException;
import com.tpdan.mspagos.model.dto.Cliente;

import java.util.List;

public interface ClienteService {
    Cliente bucarClientePorId(Integer id) throws BusinessRuleException;
    List<Cliente> buscarClientesPorId(List<Integer> ids) throws BusinessRuleException;
}
