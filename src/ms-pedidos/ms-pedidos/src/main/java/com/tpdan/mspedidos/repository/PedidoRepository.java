package com.tpdan.mspedidos.repository;

import com.tpdan.mspedidos.model.Pedido;
import com.tpdan.mspedidos.model.enumerations.EstadoPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer> {
    List<Pedido> findAll();
    Optional<Pedido> findById(Integer integer);
    @Query(value = "SELECT p FROM Pedido p WHERE (:idObra = p.obraId)")
    Optional<List<Pedido>> findByIdObra(Integer idObra);
    @Query(value = "SELECT p FROM Pedido p WHERE (:estado = p.estadoPedido)")
    Optional<List<Pedido>> buscarPedidoPorEstado(String estado);
}
