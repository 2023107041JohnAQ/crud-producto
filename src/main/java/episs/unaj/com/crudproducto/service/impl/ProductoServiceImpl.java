package episs.unaj.com.crudproducto.service.impl;

import episs.unaj.com.crudproducto.entity.Producto;
import episs.unaj.com.crudproducto.repository.ProductoRepository;
import episs.unaj.com.crudproducto.service.ProductoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServiceImpl implements ProductoService {

    private final ProductoRepository repository;

    public ProductoServiceImpl(ProductoRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Producto> listar() {
        return repository.findAll();
    }

    @Override
    public Producto guardar(Producto producto) {
        return repository.save(producto);
    }

    @Override
    public Producto buscar(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Producto actualizar(Integer id, Producto producto) {

        Producto actual = buscar(id);

        actual.setCodigo(producto.getCodigo());
        actual.setNombre(producto.getNombre());
        actual.setDescripcion(producto.getDescripcion());
        actual.setPrecio(producto.getPrecio());
        actual.setStock(producto.getStock());

        return repository.save(actual);
    }

    @Override
    public void eliminar(Integer id) {
        repository.deleteById(id);
    }
}
