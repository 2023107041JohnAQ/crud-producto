package episs.unaj.com.crudproducto.service.impl;

import episs.unaj.com.crudproducto.entity.Categoria;
import episs.unaj.com.crudproducto.repository.CategoriaRepository;
import episs.unaj.com.crudproducto.service.CategoriaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    private final CategoriaRepository repository;

    public CategoriaServiceImpl(CategoriaRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Categoria> listar() {
        return repository.findAll();
    }

    @Override
    public Categoria guardar(Categoria categoria) {
        return repository.save(categoria);
    }

    @Override
    public Categoria buscar(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Categoria actualizar(Integer id, Categoria categoria) {

        Categoria actual = buscar(id);

        actual.setNombre(categoria.getNombre());
        actual.setDescripcion(categoria.getDescripcion());

        return repository.save(actual);
    }

    @Override
    public void eliminar(Integer id) {
        repository.deleteById(id);
    }
}