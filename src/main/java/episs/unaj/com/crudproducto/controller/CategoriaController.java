package episs.unaj.com.crudproducto.controller;

import episs.unaj.com.crudproducto.entity.Categoria;
import episs.unaj.com.crudproducto.service.CategoriaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/categorias")
public class CategoriaController {

    private final CategoriaService service;

    public CategoriaController(CategoriaService service) {
        this.service = service;
    }

    @GetMapping
    public String listarCategorias(Model model){

        model.addAttribute(
                "categorias",
                service.listar());

        return "categoria-index";
    }

    @GetMapping("/nuevo")
    public String nuevaCategoria(Model model){

        model.addAttribute(
                "categoria",
                new Categoria());

        return "categoria-form";
    }

    @PostMapping("/guardar")
    public String guardarCategoria(
            Categoria categoria){

        service.guardar(categoria);

        return "redirect:/categorias";
    }

    @GetMapping("/editar/{id}")
    public String editarCategoria(
            @PathVariable Integer id,
            Model model){

        Categoria categoria = service.buscar(id);

        model.addAttribute(
                "categoria",
                categoria);

        return "categoria-form";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarCategoria(
            @PathVariable Integer id){

        service.eliminar(id);

        return "redirect:/categorias";
    }
}