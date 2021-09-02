package com.tpdan.mspedidos.repository;

import com.tpdan.mspedidos.model.DetallePedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DetallePedidoRepository extends JpaRepository<DetallePedido, Integer> {
    Optional<DetallePedido> findById(Integer integer);
}
