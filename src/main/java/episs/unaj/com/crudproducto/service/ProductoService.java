package episs.unaj.com.crudproducto.service;

import episs.unaj.com.crudproducto.entity.Producto;

import java.util.List;

public interface ProductoService {

    List<Producto> listar();

    Producto guardar(Producto producto);

    Producto buscar(Integer id);

    Producto actualizar(Integer id, Producto producto);

    void eliminar(Integer id);
}
