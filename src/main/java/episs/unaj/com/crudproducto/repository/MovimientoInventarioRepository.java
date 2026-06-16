package episs.unaj.com.crudproducto.repository;

import episs.unaj.com.crudproducto.entity.MovimientoInventario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovimientoInventarioRepository
        extends JpaRepository<MovimientoInventario,Integer> {
}