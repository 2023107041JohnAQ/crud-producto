package episs.unaj.com.crudproducto.repository;

import episs.unaj.com.crudproducto.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository
        extends JpaRepository<Categoria,Integer> {
}