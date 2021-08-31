package com.tpdan.msproductos.repository;

import com.tpdan.msproductos.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {
    List<Producto> findAll();
    @Query("SELECT p FROM Producto p WHERE (:nombre is null or p.nombre like %:nombre%) and (:stock is null or p.stockActual >= :stock) and (:precio is null or p.precio = :precio)")
    Optional<List<Producto>> buscarProducto(String nombre, Integer stock, Double precio);
    //lo ideal sería que nos pasen 2 valores de precio y buscar en ese rango, o de un valor para arriba o abajo
    @Query("SELECT p FROM Producto p WHERE (p.id = :id and p.stockActual < :cantidades)")
    Optional<Producto> buscarProductoSinStock(Integer id, Integer cantidades);
}
