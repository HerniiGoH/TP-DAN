package com.tpdan.mspagos.service;

import com.tpdan.mspagos.exceptions.BusinessRuleException;
import com.tpdan.mspagos.model.Pago;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface PagoService {
    List<Pago>buscarTodos() throws BusinessRuleException;
    Pago crearPago(Pago pago);
    Optional<List<Pago>> buscarPorIdCliente(Integer clienteId) throws BusinessRuleException;
}
