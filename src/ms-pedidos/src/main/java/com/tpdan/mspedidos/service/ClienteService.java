package com.tpdan.mspedidos.service;

import com.tpdan.mspedidos.exceptions.BusinessRuleException;
import com.tpdan.mspedidos.model.dto.Obra;

import java.util.List;

public interface ClienteService {
    List<Obra> buscarObrasPorId(List<Integer> ids) throws BusinessRuleException;
    List<Obra> buscarObrasPorCliente(Integer id, String cuit) throws BusinessRuleException;
}
