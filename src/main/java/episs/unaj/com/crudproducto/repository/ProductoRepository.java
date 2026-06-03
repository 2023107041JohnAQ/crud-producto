package episs.unaj.com.crudproducto.repository;

import episs.unaj.com.crudproducto.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository
        extends JpaRepository<Producto, Integer> {
}
