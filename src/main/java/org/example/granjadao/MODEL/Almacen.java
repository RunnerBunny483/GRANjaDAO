package org.example.granjadao.MODEL;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement(name = "almacen")
@XmlAccessorType(XmlAccessType.FIELD)
public class Almacen {
    @XmlElement(name = "id")
    private Integer id;

    @XmlElement(name = "nombre")
    private String nombre;

    @XmlElement(name = "ubicacion")
    private String ubicacion;

    @XmlElement(name = "numero_trabajadores")
    private Integer numero_trabajadores;

    @XmlElement(name = "metrosCuadrados")
    private Double metrosCuadrados;
}