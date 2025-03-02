package org.example.granjadao.MODEL;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement(name = "almacen")
@XmlAccessorType(XmlAccessType.FIELD)
public class Establecimiento {
    private Integer id;
    private String nombre;
    private String ubicacion;
}
