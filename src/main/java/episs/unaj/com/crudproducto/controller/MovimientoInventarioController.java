package episs.unaj.com.crudproducto.controller;

import episs.unaj.com.crudproducto.entity.MovimientoInventario;
import episs.unaj.com.crudproducto.service.MovimientoInventarioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/movimientos")
public class MovimientoInventarioController {

    private final MovimientoInventarioService service;

    public MovimientoInventarioController(
            MovimientoInventarioService service) {

        this.service = service;
    }

    @GetMapping
    public String listar(Model model){

        model.addAttribute(
                "movimientos",
                service.listar());

        return "movimiento-index";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model){

        model.addAttribute(
                "movimiento",
                new MovimientoInventario());

        return "movimiento-form";
    }

    @PostMapping("/guardar")
    public String guardar(
            MovimientoInventario movimiento){

        service.guardar(movimiento);

        return "redirect:/movimientos";
    }

    @GetMapping("/editar/{id}")
    public String editar(
            @PathVariable Integer id,
            Model model){

        model.addAttribute(
                "movimiento",
                service.buscar(id));

        return "movimiento-form";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(
            @PathVariable Integer id){

        service.eliminar(id);

        return "redirect:/movimientos";
    }
}