package episs.unaj.com.crudproducto.controller;

import episs.unaj.com.crudproducto.entity.Proveedor;
import episs.unaj.com.crudproducto.service.ProveedorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/proveedores")
public class ProveedorController {

    private final ProveedorService service;

    public ProveedorController(ProveedorService service) {
        this.service = service;
    }

    @GetMapping
    public String listarProveedores(Model model){

        model.addAttribute(
                "proveedores",
                service.listar());

        return "proveedor-index";
    }

    @GetMapping("/nuevo")
    public String nuevoProveedor(Model model){

        model.addAttribute(
                "proveedor",
                new Proveedor());

        return "proveedor-form";
    }

    @PostMapping("/guardar")
    public String guardarProveedor(
            Proveedor proveedor){

        service.guardar(proveedor);

        return "redirect:/proveedores";
    }

    @GetMapping("/editar/{id}")
    public String editarProveedor(
            @PathVariable Integer id,
            Model model){

        Proveedor proveedor = service.buscar(id);

        model.addAttribute(
                "proveedor",
                proveedor);

        return "proveedor-form";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarProveedor(
            @PathVariable Integer id){

        service.eliminar(id);

        return "redirect:/proveedores";
    }
}