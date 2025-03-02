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
    @Autowired
    private AnimalRepository animalRepository;

    @Autowired
    private TrabajadorRepository trabajadorRepository;

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private AlmacenRepository  almacenRepository;

    //OBTENER TODAS LAS LITAS
    public List<Animal> getListAnimales() {
        return animalRepository.findAll();
    }

    public List<Trabajador> getListTrabajadores() {
        return trabajadorRepository.findAll();
    }

    public List<Producto> getListProductos() throws IOException {
        return productoRepository.leerProductos();
    }

    public List<Almacen> getListAlmacenes() throws Exception {
        return almacenRepository.getAlmacenes();
    }
}
