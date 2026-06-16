package episs.unaj.com.crudproducto.service.impl;

import episs.unaj.com.crudproducto.entity.MovimientoInventario;
import episs.unaj.com.crudproducto.repository.MovimientoInventarioRepository;
import episs.unaj.com.crudproducto.service.MovimientoInventarioService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovimientoInventarioServiceImpl
        implements MovimientoInventarioService {

    private final MovimientoInventarioRepository repository;

    public MovimientoInventarioServiceImpl(
            MovimientoInventarioRepository repository) {

        this.repository = repository;
    }

    @Override
    public List<MovimientoInventario> listar() {
        return repository.findAll();
    }

    @Override
    public MovimientoInventario guardar(
            MovimientoInventario movimiento) {

        return repository.save(movimiento);
    }

    @Override
    public MovimientoInventario buscar(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public MovimientoInventario actualizar(
            Integer id,
            MovimientoInventario movimiento) {

        MovimientoInventario actual = buscar(id);

        actual.setTipoMovimiento(
                movimiento.getTipoMovimiento());

        actual.setCantidad(
                movimiento.getCantidad());

        actual.setFecha(
                movimiento.getFecha());

        actual.setObservacion(
                movimiento.getObservacion());

        return repository.save(actual);
    }

    @Override
    public void eliminar(Integer id) {
        repository.deleteById(id);
    }
}