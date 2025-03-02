package org.example.granjadao.CONTROLLER;

import org.example.granjadao.MODEL.Almacen;
import org.example.granjadao.MODEL.Animal;
import org.example.granjadao.MODEL.Producto;
import org.example.granjadao.MODEL.Trabajador;
import org.example.granjadao.REPOSITORY.AlmacenRepository;
import org.example.granjadao.REPOSITORY.AnimalRepository;
import org.example.granjadao.REPOSITORY.ProductoRepository;
import org.example.granjadao.REPOSITORY.TrabajadorRepository;
import org.example.granjadao.SERVICE.GranjaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.http.ResponseEntity;
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

    private GranjaService granjaService;
    private AnimalRepository animalRepository;
    private TrabajadorRepository trabajadorRepository;
    private ProductoRepository productoRepository;
    private AlmacenRepository almacenRepository;

    @Autowired
    public GranjaController(GranjaService granjaService, AnimalRepository animalRepository, TrabajadorRepository trabajadorRepository, ProductoRepository productoRepository, AlmacenRepository almacenRepository) {
        this.granjaService = granjaService;
        this.animalRepository = animalRepository;
        this.trabajadorRepository = trabajadorRepository;
        this.productoRepository = productoRepository;
        this.almacenRepository = almacenRepository;
    }

    //GET
    @GetMapping("/trabajadores")
    public ResponseEntity<List<Trabajador>> getTrabajadores() {
        List<Trabajador> listaTrabajadpres= trabajadorRepository.findAll();
        return ResponseEntity.ok(listaTrabajadpres);
    }

    @GetMapping("/animales")
    public ResponseEntity<List<Animal>> getAnimales() {
        List<Animal> listaAnimales= animalRepository.findAll();
        return ResponseEntity.ok(listaAnimales);
    }

    @GetMapping("/productos")
    public ResponseEntity<List<Producto>> getProductos() throws IOException {
        List<Producto> listaProductos= productoRepository.leerProductos();
        return ResponseEntity.ok(listaProductos);
    }

    @GetMapping("/establecimientos")
    public ResponseEntity<List<Almacen>> getAlmacenes() throws Exception {
        List<Almacen> listaAlamacenes= almacenRepository.getAlmacenes();
        return ResponseEntity.ok(listaAlamacenes);
    }
    //POST
    //PUT
    //DELETE
}
