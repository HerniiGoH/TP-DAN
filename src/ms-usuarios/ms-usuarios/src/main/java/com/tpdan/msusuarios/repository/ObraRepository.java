package com.tpdan.msusuarios.repository;

import com.tpdan.msusuarios.model.Cliente;
import com.tpdan.msusuarios.model.Obra;
import com.tpdan.msusuarios.model.TipoObra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ObraRepository extends JpaRepository<Obra, Integer> {
    List<Obra> findAll();
    Optional<Obra> findById(Integer integer);
    @Query(value="SELECT o FROM Obra o where (:id is null or o.id = :id) and (:descripcion is null or o.descripcion = :descripcion) and (:latitud is null or o.latitud = :latitud) and (:longitud is null or o.longitud = :longitud) and (:direccion is null or o.direccion = :direccion) and (:superficie is null or o.superficie = :superficie) and (:tipoObra is null or o.tipoObra = :tipoObra) and (:cliente is null or o.cliente = :cliente or (:#{#cliente?.id} = -1 and o.cliente.cuit = :#{#cliente?.cuit}))")
    Optional<List<Obra>> findAllByQuery(Integer id, String descripcion, Float latitud, Float longitud, String direccion, Integer superficie, TipoObra tipoObra, @Param("cliente") Cliente cliente);

}
