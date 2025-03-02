package org.example.granjadao.CONTROLLER;

import org.example.granjadao.MODEL.Almacen;
import org.example.granjadao.MODEL.Animal;
import org.example.granjadao.MODEL.Producto;
import org.example.granjadao.MODEL.Trabajador;
import org.example.granjadao.SERVICE.GranjaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/granja")
@CacheConfig(cacheNames = "granja")
public class GranjaController {

    @Autowired
    private GranjaService granjaService;

    //GET
    @GetMapping("/trabajadores")
    public List<Trabajador> getTrabajadores() {
        return granjaService.getListTrabajadores();
    }

    @GetMapping("/animales")
    public List<Animal> getAnimales() {
        return granjaService.getListAnimales();
    }

    @GetMapping("/productos")
    public List<Producto> getProductos() throws IOException {
        return granjaService.getListProductos();
    }

    @GetMapping("/establecimientos")
    public List<Almacen> getAlmacenes() throws Exception {
        return granjaService.getListAlmacenes();
    }
    //POST
    //PUT
    //DELETE
}
