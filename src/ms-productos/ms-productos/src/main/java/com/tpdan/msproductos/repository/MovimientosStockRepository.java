package com.tpdan.msproductos.repository;

import com.tpdan.msproductos.model.MovimientosStock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovimientosStockRepository extends JpaRepository<MovimientosStock, Integer> {
}
