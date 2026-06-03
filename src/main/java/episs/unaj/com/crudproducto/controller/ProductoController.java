package episs.unaj.com.crudproducto.controller;

import episs.unaj.com.crudproducto.entity.Producto;
import episs.unaj.com.crudproducto.service.ProductoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    private final ProductoService service;

    public ProductoController(ProductoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Producto> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Producto buscar(@PathVariable Integer id) {
        return service.buscar(id);
    }

    @PostMapping
    public Producto guardar(@RequestBody Producto producto) {
        return service.guardar(producto);
    }

    @PutMapping("/{id}")
    public Producto actualizar(@PathVariable Integer id,
                               @RequestBody Producto producto) {

        return service.actualizar(id, producto);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        service.eliminar(id);
    }
}
