package com.tpdan.msusuarios.validator.impl;

import com.tpdan.msusuarios.exceptions.BusinessRuleException;
import com.tpdan.msusuarios.exceptions.ClienteInexistenteException;
import com.tpdan.msusuarios.exceptions.ClienteSinObrasException;
import com.tpdan.msusuarios.exceptions.ClienteSinTipoDeObraException;
import com.tpdan.msusuarios.model.Cliente;
import com.tpdan.msusuarios.model.Obra;
import com.tpdan.msusuarios.service.ClienteService;
import com.tpdan.msusuarios.validator.ClienteValidator;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ClienteValidatorImpl implements ClienteValidator {

    private final ClienteService clienteService;

    public ClienteValidatorImpl(@Lazy ClienteService clienteService){
        this.clienteService = clienteService;
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

        //TODO validar que no tenga pedidos
    }
}
