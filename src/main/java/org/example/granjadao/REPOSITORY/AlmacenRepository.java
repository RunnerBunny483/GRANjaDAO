package org.example.granjadao.REPOSITORY;

import org.example.granjadao.MODEL.Almacen;
import org.example.granjadao.MODEL.Almacenes;
import org.springframework.stereotype.Repository;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

@Repository
public class AlmacenRepository {
    private static final String xml = "Almacen.xml";

//    public List<Almacen> getAllAlmacenes() throws Exception {
//        JAXBContext context = JAXBContext.newInstance(Almacen.class);
//        Unmarshaller unmarshaller = context.createUnmarshaller();
//        return (List<Almacen>) unmarshaller.unmarshal(new File(xml));
//    }

    public List<Almacen> getAllAlmacenes() throws Exception {
        //Convertir objetos a xml
        JAXBContext context = JAXBContext.newInstance(Almacenes.class);
        //Convierte xml a objetos
        Unmarshaller unmarshaller = context.createUnmarshaller();
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(xml);
        if (inputStream == null) {
            throw new RuntimeException("No encuentro " +xml);
        }
        //Convierte el contenido del xml en un objeto de tipo Almacenes
        Almacenes almacenes = (Almacenes) unmarshaller.unmarshal(inputStream);
        return almacenes.getAlmacenes();
    }

    //Guarda un objeto almacen en el archivo xml
    public Almacen saveAlmacen(Almacen almacen) throws Exception {
        JAXBContext context = JAXBContext.newInstance(Almacen.class);
        //Convertir objetos java a xml
        Marshaller marshaller = context.createMarshaller();
        marshaller.marshal(almacen, new File(xml));
        return almacen;
    }
}
