package episs.unaj.com.crudproducto.service;

import episs.unaj.com.crudproducto.entity.MovimientoInventario;

import java.util.List;

public interface MovimientoInventarioService {

    List<MovimientoInventario> listar();

    MovimientoInventario guardar(
            MovimientoInventario movimiento);

    MovimientoInventario buscar(Integer id);

    MovimientoInventario actualizar(
            Integer id,
            MovimientoInventario movimiento);

    void eliminar(Integer id);
}