package episs.unaj.com.crudproducto.controller;

import episs.unaj.com.crudproducto.entity.Producto;
import episs.unaj.com.crudproducto.service.ProductoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import java.util.List;

@Controller
@RequestMapping("/productos")
public class ProductoController {

    private final ProductoService service;

    public ProductoController(ProductoService service) {
        this.service = service;
    }
/*pagina web*/
    @GetMapping
    public String listarProductos(Model model){

        model.addAttribute(
                "productos",
                service.listar());

        return "index";
    }
    @GetMapping("/nuevo")
    public String nuevoProducto(Model model){

        model.addAttribute(
                "producto",
                new Producto());

        return "form";
    }
    @PostMapping("/guardar")
    public String guardarProducto(
            Producto producto){

        service.guardar(producto);

        return "redirect:/productos";
    }
    @GetMapping("/editar/{id}")
    public String editarProducto(
            @PathVariable Integer id,
            Model model){

        Producto producto = service.buscar(id);

        model.addAttribute(
                "producto",
                producto);

        return "form";
    }
    @GetMapping("/eliminar/{id}")
    public String eliminarProducto(
            @PathVariable Integer id){

        service.eliminar(id);

        return "redirect:/productos";
    }
/*-----*/
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
