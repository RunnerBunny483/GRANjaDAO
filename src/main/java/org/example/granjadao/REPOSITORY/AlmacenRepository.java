package org.example.granjadao.REPOSITORY;

import org.example.granjadao.MODEL.Almacen;
import org.springframework.stereotype.Repository;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;

@Repository
public class AlmacenRepository {
    private static final String xml = "Almacen.xml";

    public List<Almacen> getAllAlmacenes() throws Exception {
        JAXBContext context = JAXBContext.newInstance(Almacen.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        return (List<Almacen>) unmarshaller.unmarshal(new File(xml));
    }

    public Almacen saveAlmacen(Almacen almacen) throws Exception {
        JAXBContext context = JAXBContext.newInstance(Almacen.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.marshal(almacen, new File(xml));
        return almacen;
    }
}
