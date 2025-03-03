package org.example.granjadao.REPOSITORY;

import org.example.granjadao.MODEL.Almacen;
import org.example.granjadao.MODEL.AlmacenListWrapper;
import org.springframework.stereotype.Repository;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Repository
public class AlmacenRepository {
    private static final String xml = "Almacen.xml";
    private static final File file = new File("src/main/resources/" + xml);

    //Obtener todos los almacenes
    public List<Almacen> getAllAlmacenes() throws Exception {
        JAXBContext context = JAXBContext.newInstance(AlmacenListWrapper.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        //Convertir el contenido del XML en un objeto de tipo AlmacenListWrapper
        AlmacenListWrapper wrapper = (AlmacenListWrapper) unmarshaller.unmarshal(file);
        return wrapper.getAlmacenes();
    }

    //Guardar la lista de almacenes en el archivo XML
    public void guardarAlmacenesEnXML(List<Almacen> almacenes) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(AlmacenListWrapper.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        AlmacenListWrapper wrapper = new AlmacenListWrapper();
        wrapper.setAlmacenes(almacenes);

        //Guardar en la ruta del archivo XML
        marshaller.marshal(wrapper, file);
    }

    public Almacen saveAlmacen(Almacen almacen) throws Exception {
        //Obtener la lista actual de almacenes
        List<Almacen> almacenes = getAllAlmacenes();

        //Verificar si el ID ya existe
        boolean idExiste = almacenes.stream().anyMatch(a -> a.getId().equals(almacen.getId()));
        if (idExiste) {
            throw new RuntimeException("El ID del almacén ya existe: " + almacen.getId());
        }

        //Añadir el nuevo almacén a la lista
        almacenes.add(almacen);

        //Guardar la lista actualizada en el archivo XML
        guardarAlmacenesEnXML(almacenes);

        return almacen;
    }

    public Almacen findById(int id) throws Exception {
        List<Almacen> almacenes = getAllAlmacenes();
        return almacenes.stream()
                .filter(a -> a.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Almacén no encontrado con ID: " + id));
    }

    //Eliminar un almacén por ID
    public void deleteAlmacen(int id) throws Exception {
        List<Almacen> almacenes = getAllAlmacenes();
        Almacen almacenEliminar = findById(id);
        almacenes.remove(almacenEliminar);
        guardarAlmacenesEnXML(almacenes);
    }
}
