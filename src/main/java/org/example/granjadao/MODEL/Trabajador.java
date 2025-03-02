package org.example.granjadao.MODEL;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "trabajadores")
public class Trabajador {
    @Id
    @Size(max = 20)
    @Column(name = "dni", nullable = false, length = 20)
    private String dni;

    @Size(max = 50)
    @NotNull
    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    @Size(max = 100)
    @NotNull
    @Column(name = "apellidos", nullable = false, length = 100)
    private String apellidos;

    @Size(max = 100)
    @Column(name = "email", length = 100)
    private String email;

    @Size(max = 15)
    @Column(name = "telefono", length = 15)
    private String telefono;

    @NotNull
    @Column(name = "sueldo", nullable = false, precision = 10, scale = 2)
    private BigDecimal sueldo;

    @Size(max = 50)
    @NotNull
    @Column(name = "puesto", nullable = false, length = 50)
    private String puesto;

    public Trabajador() {
    }

    public Trabajador(String dni, String nombre, String apellidos, String email, String telefono, BigDecimal sueldo, String puesto) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.telefono = telefono;
        this.sueldo = sueldo;
        this.puesto = puesto;
    }
}