package com.tpdan.msproductos.service.impl;

import com.tpdan.msproductos.model.Producto;
import com.tpdan.msproductos.repository.MovimientosStockRepository;
import com.tpdan.msproductos.repository.ProductoRepository;
import com.tpdan.msproductos.repository.ProvisionRepository;
import com.tpdan.msproductos.service.ProductoService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductoServiceImpl implements ProductoService {
    private final ProductoRepository productoRepository;
    private final ProvisionRepository provisionRepository;
    private final MovimientosStockRepository movimientosStockRepository;

    public ProductoServiceImpl(ProductoRepository productoRepository, ProvisionRepository provisionRepository, MovimientosStockRepository movimientosStockRepository){
        this.productoRepository = productoRepository;
        this.provisionRepository = provisionRepository;
        this.movimientosStockRepository = movimientosStockRepository;
    }

    @Override
    public List<Producto> buscarTodos() {
        return productoRepository.findAll();
    }

    @Override
    public Producto crearProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public Optional<Producto> buscarProductoPorId(Integer id) {
        return productoRepository.findById(id);
    }

    @Override
    public Producto actualizarProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public Optional<List<Producto>> buscarProductos(String nombre, Integer stock, Double precio) {
        return productoRepository.buscarProducto(nombre, stock, precio);
    }

    @Override
    public List<Producto> buscarProductosSinStock(List<Integer> ids, List<Integer> cantidades) {
        List<Producto> productosSinStock = new ArrayList<>();
        for (int i = 0; i < ids.size(); i++) {
            productoRepository.buscarProductoSinStock(ids.get(i), cantidades.get(i)).ifPresent(productosSinStock::add);
        }
        return productosSinStock;
    }
}
