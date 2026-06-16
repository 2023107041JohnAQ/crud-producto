package episs.unaj.com.crudproducto.service.impl;

import episs.unaj.com.crudproducto.entity.Proveedor;
import episs.unaj.com.crudproducto.repository.ProveedorRepository;
import episs.unaj.com.crudproducto.service.ProveedorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProveedorServiceImpl implements ProveedorService {

    private final ProveedorRepository repository;

    public ProveedorServiceImpl(ProveedorRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Proveedor> listar() {
        return repository.findAll();
    }

    @Override
    public Proveedor guardar(Proveedor proveedor) {
        return repository.save(proveedor);
    }

    @Override
    public Proveedor buscar(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Proveedor actualizar(Integer id, Proveedor proveedor) {

        Proveedor actual = buscar(id);

        actual.setRuc(proveedor.getRuc());
        actual.setNombreEmpresa(proveedor.getNombreEmpresa());
        actual.setTelefono(proveedor.getTelefono());
        actual.setCorreo(proveedor.getCorreo());
        actual.setDireccion(proveedor.getDireccion());

        return repository.save(actual);
    }

    @Override
    public void eliminar(Integer id) {
        repository.deleteById(id);
    }
}