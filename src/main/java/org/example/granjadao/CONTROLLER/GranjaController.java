package org.example.granjadao.CONTROLLER;

import jakarta.validation.Valid;
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
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/granja")
@CacheConfig(cacheNames = "granja")
public class GranjaController {

    private GranjaService granjaService;
    private ProductoRepository productoRepository;

    @Autowired
    public GranjaController(GranjaService granjaService, ProductoRepository productoRepository) {
        this.granjaService = granjaService;
        this.productoRepository = productoRepository;
    }

    //----- GET -----

    @GetMapping("/trabajadores")
    public ResponseEntity<List<Trabajador>> getTrabajadores() {
        List<Trabajador> listaTrabajadpres= granjaService.getAllTrabajadores();
        return ResponseEntity.ok(listaTrabajadpres);
    }

    @Cacheable
    @GetMapping("/trabajadores/{dni}")
    public ResponseEntity<?> getTrabajadorById(@PathVariable String dni) {
        try{
            Trabajador trabajador = granjaService.findTrabajadorById(dni);
            return ResponseEntity.ok().body(trabajador);
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

    @GetMapping("/animales")
    public ResponseEntity<List<Animal>> getAnimales() {
        List<Animal> listaAnimales= granjaService.getAllAnimales();
        return ResponseEntity.ok(listaAnimales);
    }

    @Cacheable
    @GetMapping("/animales/{id}")
    public ResponseEntity<?> getAnimalById(@PathVariable Integer id) {
        try{
            Animal animal = granjaService.findAnimalById(id);
            return ResponseEntity.ok().body(animal);
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

    @GetMapping("/productos")
    public ResponseEntity<List<Producto>> getProductos() throws IOException {
        List<Producto> listaProductos= productoRepository.leerProductos();
        return ResponseEntity.ok(listaProductos);
    }

    @GetMapping("/establecimientos")
    public ResponseEntity<List<Almacen>> getAlmacenes() throws Exception {
        List<Almacen> listaAlamacenes= granjaService.getAllAlmacenes();
        return ResponseEntity.ok(listaAlamacenes);
    }

    //----- POST -----

    @PostMapping("/animales")
    public ResponseEntity<?> addAnimal(@Valid @RequestBody Animal animal) {
        try{
            Animal animalSave = granjaService.saveAnimal(animal);
            return ResponseEntity.status(201).body(animalSave);
        } catch (RuntimeException e) {
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @PostMapping("/trabajadores")
    public ResponseEntity<?> addTrabajador(@Valid @RequestBody Trabajador trabajador) {
        try{
            Trabajador trabajadorSave = granjaService.saveTrabajador(trabajador);
            return ResponseEntity.status(201).body(trabajadorSave);
        } catch (RuntimeException e) {
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    //----- PUT -----

    @PutMapping("/animales/{id}")
    public ResponseEntity<?> updateAnimal(@PathVariable Integer id, @Valid @RequestBody Animal animal) {
        try{
            Animal animalUpdate = granjaService.updateAnimal(id, animal);
            return ResponseEntity.ok().body(animalUpdate);
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

    @PutMapping("/trabajadores/{dni}")
    public ResponseEntity<?> updateTrabajador(@PathVariable String dni, @Valid @RequestBody Trabajador trabajador) {
        try{
            Trabajador trabajadorUpdate = granjaService.updateTrabajador(dni, trabajador);
            return ResponseEntity.ok().body(trabajadorUpdate);
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

    //----- DELETE -----

    @DeleteMapping("/animales/{id}")
    public ResponseEntity<?> deleteAnimal(@PathVariable Integer id) {
        try{
            granjaService.deleteAnimalById(id);
            return ResponseEntity.ok().body("Animal con id "+id+" eliminado correctamente.");
        } catch (RuntimeException e){
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

    @DeleteMapping("/trabajadores/{dni}")
    public ResponseEntity<?> deleteTrabajador(@PathVariable String dni) {
        try{
            granjaService.deleteTrabajadorById(dni);
            return ResponseEntity.ok().body("Trabajador con dni "+dni+" eliminado correctamente.");
        } catch (RuntimeException e){
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }
}
