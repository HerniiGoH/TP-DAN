package com.tpdan.msproductos.validator.impl;

import com.tpdan.msproductos.exceptions.BusinessRuleException;
import com.tpdan.msproductos.exceptions.ProductoInexistenteException;
import com.tpdan.msproductos.model.Producto;
import com.tpdan.msproductos.model.dto.DetallePedido;
import com.tpdan.msproductos.model.dto.Pedido;
import com.tpdan.msproductos.service.ProductoService;
import com.tpdan.msproductos.validator.MovimientoStockValidador;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class MovimientoStockValidadorImpl implements MovimientoStockValidador {

    private final ProductoService productoService;

    public MovimientoStockValidadorImpl(@Lazy ProductoService productoService) {
        this.productoService = productoService;
    }

    @Override
    public List<Producto> validarCreacion(List<DetallePedido> detallePedidoList) throws BusinessRuleException {
        Set<Integer> productoIds = new HashSet<>();
        for(DetallePedido dp : detallePedidoList){
            productoIds.add(dp.getProductoId());
        }
        List<Producto> productos = productoService.buscarTodos(new ArrayList<>(productoIds));
        if(productos.size()!=productoIds.size()){
            throw new ProductoInexistenteException();
        }
        return productos;
    }
}
