package com.tpdan.msproductos.service;

import com.tpdan.msproductos.model.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductoService {
    List<Producto> buscarTodos();
    Producto crearProducto(Producto producto);
    Optional<Producto> buscarProductoPorId(Integer id);
    Producto actualizarProducto(Producto producto);
    Optional<List<Producto>> buscarProductos(String nombre, Integer stock, Double precio);
    List<Producto> buscarProductosSinStock(List<Integer> ids, List<Integer> cantidades);
}
