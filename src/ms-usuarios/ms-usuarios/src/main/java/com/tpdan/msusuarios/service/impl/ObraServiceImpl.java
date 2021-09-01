package com.tpdan.msusuarios.service.impl;

import com.tpdan.msusuarios.model.Cliente;
import com.tpdan.msusuarios.model.Obra;
import com.tpdan.msusuarios.model.TipoObra;
import com.tpdan.msusuarios.repository.ObraRepository;
import com.tpdan.msusuarios.service.ObraService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ObraServiceImpl implements ObraService {

    private final ObraRepository obraRepository;

    public ObraServiceImpl(ObraRepository obraRepository){
        this.obraRepository = obraRepository;
    }

    @Override
    public List<Obra> buscarTodas(List<Integer> ids) {
        return ids!=null ? obraRepository.findAllByIdIsIn(ids) : obraRepository.findAll();
    }

    @Override
    public Optional<Obra> buscarObraPorId(Integer id) {
        return obraRepository.findById(id);
    }

    @Override
    public Optional<List<Obra>> buscarObra(Integer id, String descripcion, Float latitud, Float longitud, String direccion, Integer superficie, TipoObra tipoObra, Cliente cliente) {
        return obraRepository.findAllByQuery(id, descripcion, latitud, longitud, direccion, superficie, tipoObra, cliente);
    }

    @Override
    public Optional<List<Obra>> buscarObraPorCliente(Integer id, String cuit) {
        return obraRepository.buscarObraPorCliente(id, cuit);
    }

    @Override
    public Obra crearObra(Obra nuevaObra) {
        return obraRepository.save(nuevaObra);
    }

    @Override
    public List<Obra> crearObras(List<Obra> nuevasObras) {
        return obraRepository.saveAll(nuevasObras);
    }

    @Override
    public Obra actualizarObra(Obra nuevaObra) {
        return obraRepository.save(nuevaObra);
    }

    @Override
    public void borrarObra(Integer id) {
        obraRepository.deleteById(id);
    }
}
