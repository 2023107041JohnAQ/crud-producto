package episs.unaj.com.crudproducto.service;

import episs.unaj.com.crudproducto.entity.Proveedor;

import java.util.List;

public interface ProveedorService {

    List<Proveedor> listar();

    Proveedor guardar(Proveedor proveedor);

    Proveedor buscar(Integer id);

    Proveedor actualizar(Integer id,
                         Proveedor proveedor);

    void eliminar(Integer id);
}