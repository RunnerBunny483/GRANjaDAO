package org.example.granjadao.MODEL;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAccessType;
import java.util.List;

@XmlRootElement(name = "almacenes")
@XmlAccessorType(XmlAccessType.FIELD) // Use fields for mapping
public class Almacenes {
    @XmlElement(name = "almacen") // Explicitly map this field
    private List<Almacen> almacenes;

    public List<Almacen> getAlmacenes() {
        return almacenes;
    }

    public void setAlmacenes(List<Almacen> almacenes) {
        this.almacenes = almacenes;
    }
}
