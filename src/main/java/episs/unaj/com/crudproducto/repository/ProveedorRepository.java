package episs.unaj.com.crudproducto.repository;

import episs.unaj.com.crudproducto.entity.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProveedorRepository
        extends JpaRepository<Proveedor,Integer> {
}