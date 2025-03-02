package org.example.granjadao.REPOSITORY;

import org.example.granjadao.MODEL.Almacen;
import org.springframework.stereotype.Repository;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;

@Repository
public class AlmacenRepository {
    private static final String xml = "Almacen.xml";

    public List<Almacen> getAlmacenes() throws Exception {
        JAXBContext context = JAXBContext.newInstance(Almacen.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        return (List<Almacen>) unmarshaller.unmarshal(new File(xml));
    }
}
