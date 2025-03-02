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

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class GranjaService {

    private final AnimalRepository animalRepository;
    private final TrabajadorRepository trabajadorRepository;
    private final AlmacenRepository almacenRepository;
    private final ProductoRepository productoRepository;

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
