package com.tpdan.msusuarios.validator.impl;

import com.tpdan.msusuarios.exceptions.BusinessRuleException;
import com.tpdan.msusuarios.exceptions.ObraConPedidosException;
import com.tpdan.msusuarios.exceptions.ObraInexistenteException;
import com.tpdan.msusuarios.model.Obra;
import com.tpdan.msusuarios.model.dto.Pedido;
import com.tpdan.msusuarios.service.ObraService;
import com.tpdan.msusuarios.service.PedidoService;
import com.tpdan.msusuarios.validator.ObraValidador;

import java.util.List;
import java.util.Optional;

public class ObraValidadorImpl implements ObraValidador {
    private final ObraService obraService;
    private final PedidoService pedidoService;

    public ObraValidadorImpl(ObraService obraService, PedidoService pedidoService) {
        this.obraService = obraService;
        this.pedidoService = pedidoService;
    }

    @Override
    public void validarEliminacion(Integer id) throws BusinessRuleException {
        Optional<Obra> obraOptional = obraService.buscarObraPorId(id);
        if(obraOptional.isEmpty()){
            throw new ObraInexistenteException();
        }
        List<Pedido> pedidos = pedidoService.buscarPedidosPorCliente(obraOptional.get().getCliente().getId(), obraOptional.get().getCliente().getCuit());
        if(!pedidos.isEmpty()){
            throw new ObraConPedidosException();
        }
    }
}
