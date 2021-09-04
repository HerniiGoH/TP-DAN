package com.tpdan.msproductos.service.impl;

import com.tpdan.msproductos.exceptions.BusinessRuleException;
import com.tpdan.msproductos.exceptions.ProductoInexistenteException;
import com.tpdan.msproductos.model.MovimientosStock;
import com.tpdan.msproductos.model.Producto;
import com.tpdan.msproductos.model.dto.DetallePedido;
import com.tpdan.msproductos.model.dto.Pedido;
import com.tpdan.msproductos.repository.MovimientosStockRepository;
import com.tpdan.msproductos.repository.ProductoRepository;
import com.tpdan.msproductos.repository.ProvisionRepository;
import com.tpdan.msproductos.service.ProductoService;
import com.tpdan.msproductos.validator.MovimientoStockValidador;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ProductoServiceImpl implements ProductoService {
    private final ProductoRepository productoRepository;
    private final ProvisionRepository provisionRepository;
    private final MovimientosStockRepository movimientosStockRepository;
    private final MovimientoStockValidador movimientoStockValidador;

    public ProductoServiceImpl(ProductoRepository productoRepository,
                               ProvisionRepository provisionRepository,
                               MovimientosStockRepository movimientosStockRepository,
                               MovimientoStockValidador movimientoStockValidador){
        this.productoRepository = productoRepository;
        this.provisionRepository = provisionRepository;
        this.movimientosStockRepository = movimientosStockRepository;
        this.movimientoStockValidador = movimientoStockValidador;
    }

    @Override
    public List<Producto> buscarTodos(List<Integer> ids) {
        return ids!=null ? productoRepository.findAllByIdIsIn(ids) : productoRepository.findAll();
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
        List<Producto> productosSinStock = productoRepository.findAllByIdIsIn(ids);
        return productosSinStock.stream().filter(producto -> producto.getStockActual()<cantidades.get(productosSinStock.indexOf(producto))).collect(Collectors.toUnmodifiableList());
    }

    @Override
    public void generarMovimientoStock(List<DetallePedido> detallePedidoList) throws BusinessRuleException {
        try {
            List<Producto> productos = movimientoStockValidador.validarCreacion(detallePedidoList);
            List<MovimientosStock> movimientosStocks = new ArrayList<>();

            for(DetallePedido dp : detallePedidoList){
                MovimientosStock movimientosStock = new MovimientosStock();
                movimientosStock.setCantidadSalida(dp.getCantidad());
                movimientosStock.setProducto(productos.stream().filter(p-> Objects.equals(p.getId(), dp.getProductoId())).findFirst().get());
                movimientosStock.setFecha(LocalDateTime.now());
                movimientosStocks.add(movimientosStock);
            }
            movimientosStockRepository.saveAll(movimientosStocks);
            //TODO verificar los stocks para hacer los pedidos de aprovisionamiento
        } catch (BusinessRuleException e) {
            e.printStackTrace();
        }
    }
}
