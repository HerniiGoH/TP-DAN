package com.tpdan.msusuarios.service;

import com.tpdan.msusuarios.exceptions.BusinessRuleException;
import com.tpdan.msusuarios.model.Cliente;
import com.tpdan.msusuarios.model.Obra;
import com.tpdan.msusuarios.model.TipoObra;

import java.util.List;
import java.util.Optional;

public interface ObraService {
    List<Obra> buscarTodas(List<Integer> ids);
    Optional<Obra> buscarObraPorId(Integer id);
    Optional<List<Obra>> buscarObra(Integer id, String descripcion, Float latitud, Float longitud, String direccion, Integer superficie, TipoObra tipoObra, Cliente cliente);
    Optional<List<Obra>> buscarObraPorCliente(Integer id, String cuit);
    Obra crearObra(Obra nuevaObra);
    List<Obra> crearObras(List<Obra> nuevasObras);
    Obra actualizarObra(Obra nuevaObra);
    void borrarObra(Integer id) throws BusinessRuleException;
}
