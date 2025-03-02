package org.example.granjadao.SERVICE;

import org.example.granjadao.MODEL.Animal;
import org.example.granjadao.REPOSITORY.AnimalRepository;
import org.example.granjadao.REPOSITORY.ProductoRepository;
import org.example.granjadao.REPOSITORY.TrabajadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GranjaService {
    @Autowired
    private AnimalRepository animalRepository;

    @Autowired
    private TrabajadorRepository trabajadorRepository;

    @Autowired
    private ProductoRepository productoRepository;


}
