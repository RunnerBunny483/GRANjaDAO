package org.example.granjadao.SERVICE;

import org.example.granjadao.MODEL.Almacen;
import org.example.granjadao.MODEL.Animal;
import org.example.granjadao.MODEL.Producto;
import org.example.granjadao.MODEL.Trabajador;
import org.example.granjadao.REPOSITORY.AlmacenRepository;
import org.example.granjadao.REPOSITORY.AnimalRepository;
import org.example.granjadao.REPOSITORY.ProductoRepository;
import org.example.granjadao.REPOSITORY.TrabajadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class GranjaService {

    private final AnimalRepository animalRepository;
    private final TrabajadorRepository trabajadorRepository;
    private final AlmacenRepository almacenRepository;
    private final ProductoRepository productoRepository;

    @Autowired
    public GranjaService(AnimalRepository animalRepository, TrabajadorRepository trabajadorRepository, AlmacenRepository almacenRepository, ProductoRepository productoRepository) {
        this.animalRepository = animalRepository;
        this.trabajadorRepository = trabajadorRepository;
        this.almacenRepository = almacenRepository;
        this.productoRepository = productoRepository;
    }

    //----- XML:Almacen -----

    public Almacen saveAlmacen(Almacen almacen) throws Exception {
        return almacenRepository.saveAlmacen(almacen);
    }

    public List<Almacen> getAllAlmacenes() throws Exception {
        return almacenRepository.getAllAlmacenes();
    }


    //----- TXT:Producto -----

    public List<Producto> getAllProductos() throws IOException {
        return productoRepository.leerProductos();
    }

    public Producto findProductoById(int id) throws IOException {
        return productoRepository.findById(id);
    }

    public Producto saveProducto(Producto producto) throws IOException {
        return productoRepository.escribirProducto(producto);
    }

    public Producto updateProducto(Integer id, Producto producto) throws Exception {
        List<Producto> productos = productoRepository.leerProductos();
        // Buscar el producto por su ID
        Producto productoUpdate = productos.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Producto no encontrado con ID: " + id));

        productoUpdate.setNombre(producto.getNombre());
        productoUpdate.setDescripcion(producto.getDescripcion());
        productoUpdate.setPrecio(producto.getPrecio());
        productoUpdate.setCantidad(producto.getCantidad());

        //guardar la lista actualizada en el archivo
        productoRepository.escribirProductos(productos);

        return productoUpdate;
    }

    public void deleteProductoById(int id) throws IOException {
        productoRepository.deleteProducto(id);
    }

    //----- MongoDB:Animal -----

    public List<Animal> getAllAnimales() {
        return animalRepository.findAll();
    }

    public Animal findAnimalById(Integer id) {
        return animalRepository.findById(id).orElseThrow(() -> new RuntimeException("Animal no encontrado."));
    }

    public Animal saveAnimal(Animal animal) {
        return animalRepository.save(animal);
    }

    public Animal updateAnimal(Integer id, Animal animal) {
        Animal animalUpdate = animalRepository.findById(id).orElseThrow(() -> new RuntimeException("Animal no encontrado."));

        animalUpdate.setNombre(animal.getNombre());
        animalUpdate.setEspecie(animal.getEspecie());

        return animalRepository.save(animalUpdate);
    }

    public void deleteAnimalById(Integer id) {
        Animal animalDelete = animalRepository.findById(id).orElseThrow(() -> new RuntimeException("Animal no encontrado."));
        animalRepository.delete(animalDelete);
    }

    //----- JPA:Trabajador -----

    public List<Trabajador> getAllTrabajadores() {
        return trabajadorRepository.findAll();
    }

    public Trabajador findTrabajadorById(String dni) {
        return trabajadorRepository.findById(dni).orElseThrow(() -> new RuntimeException("Trabajador no encontrado."));
    }

    public Trabajador saveTrabajador(Trabajador trabajador) {
        return trabajadorRepository.save(trabajador);
    }

    public Trabajador updateTrabajador(String dni, Trabajador trabajador) {
        Trabajador trabajadorUpdate = trabajadorRepository.findById(dni).orElseThrow(() -> new RuntimeException("Trabajador no encontrado."));

        trabajadorUpdate.setNombre(trabajador.getNombre());
        trabajadorUpdate.setApellidos(trabajador.getApellidos());
        trabajadorUpdate.setEmail(trabajador.getEmail());
        trabajadorUpdate.setTelefono(trabajador.getTelefono());
        trabajadorUpdate.setSueldo(trabajador.getSueldo());
        trabajadorUpdate.setPuesto(trabajador.getPuesto());

        return trabajadorRepository.save(trabajadorUpdate);
    }

    public void deleteTrabajadorById(String dni) {
        Trabajador trabajadorDelete = trabajadorRepository.findById(dni).orElseThrow(() -> new RuntimeException("Trabajador no encontrado."));
        trabajadorRepository.delete(trabajadorDelete);
    }
}
