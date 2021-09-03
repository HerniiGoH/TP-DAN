package com.tpdan.msusuarios.repository;

import com.tpdan.msusuarios.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    @Query(value = "SELECT c FROM Cliente c WHERE c.fechaBaja is null")
    List<Cliente> findAll();
    @Query(value = "SELECT c FROM Cliente c WHERE (c.fechaBaja is null) and (c.id = :integer)")
    Optional<Cliente> findById(Integer integer);
    @Query(value = "SELECT c FROM Cliente c WHERE (c.fechaBaja is null) and (:id is null or c.id = :id) and (:mail is null or c.mail = :mail) and (:cuit is null or c.cuit = :cuit) and (:razonSocial is null or c.razonSocial = :razonSocial) and (:maxCuentaCorriente is null or c.maxCuentaCorriente=:maxCuentaCorriente) and (:habilitadoOnline is null or c.habilitadoOnline = :habilitadoOnline)")
    Optional<List<Cliente>> findAllByQuerySQL(Integer id, String cuit, String razonSocial, String mail, Double maxCuentaCorriente, Boolean habilitadoOnline);
    @Query(value = "SELECT c FROM Cliente c JOIN Obra o on (c = o.cliente) and (o.id = :id) and (c.fechaBaja is null)")
    Cliente findByIdObra(Integer id);
}
