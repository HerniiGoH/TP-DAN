package com.tpdan.mspagos.repository;

import com.tpdan.mspagos.model.Pago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PagoRepository extends JpaRepository<Pago, Integer> {
    Optional<List<Pago>>findAllByClienteId(Integer clienteId);
}
