package com.tpdan.msusuarios.validator.impl;

import com.tpdan.msusuarios.exceptions.*;
import com.tpdan.msusuarios.model.Cliente;
import com.tpdan.msusuarios.model.Obra;
import com.tpdan.msusuarios.service.ClienteService;
import com.tpdan.msusuarios.service.PedidoService;
import com.tpdan.msusuarios.validator.ClienteValidator;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ClienteValidatorImpl implements ClienteValidator {

    private final ClienteService clienteService;
    private final PedidoService pedidoService;

    public ClienteValidatorImpl(@Lazy ClienteService clienteService,
                                PedidoService pedidoService){
        this.clienteService = clienteService;
        this.pedidoService = pedidoService;
    }

    @Override
    public void validarCreacion(Cliente cliente) throws BusinessRuleException {
        if(cliente.getObras() == null || cliente.getObras().isEmpty()){
            throw new ClienteSinObrasException();
        }
        for(Obra obra : cliente.getObras()){
            if(obra.getTipoObra()==null){
                throw new ClienteSinTipoDeObraException();
            }
        }

        //TODO validar situacion crediticia
    }

    @Override
    public void validarEliminacion(Integer id) throws BusinessRuleException {
        Optional<Cliente> cliente = clienteService.buscarClientePorId(id);

        if(cliente.isEmpty()){
            throw new ClienteInexistenteException();
        }

        if(pedidoService.buscarPedidosPorCliente(id, cliente.get().getCuit()).isEmpty()){
            throw new ClienteConPedidosException();
        }
    }
}
