package episs.unaj.com.crudproducto.service;

import episs.unaj.com.crudproducto.entity.Categoria;

import java.util.List;

public interface CategoriaService {

    List<Categoria> listar();

    Categoria guardar(Categoria categoria);

    Categoria buscar(Integer id);

    Categoria actualizar(Integer id,
                         Categoria categoria);

    void eliminar(Integer id);
}