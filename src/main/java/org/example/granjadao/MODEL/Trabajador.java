package org.example.granjadao.MODEL;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "trabajadores")
public class Trabajador {
    @Id
    @Size(max = 20)
    //validación mediante método
    @Column(name = "dni", nullable = false, length = 20)
    private String dni;

    @Size(max = 50)
    @NotNull(message = "El nombre no puede ser nulo")
    @Pattern(
            regexp = "^[A-ZÁÉÍÓÚÑ][a-záéíóúñ0-9 _-]*$",
            message = "Nombre de trabajador empieza con mayúscula y solo con caracteres alfabéticos"
    )
    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    @Size(max = 100)
    @NotNull(message = "Los apellidos no pueden ser nulos")
    @Pattern(
            regexp = "^[A-ZÁÉÍÓÚÑa-záéíóúñ ]+$",
            message = "Apellidos de trabajador solo con caracteres alfabéticos"
    )
    @Column(name = "apellidos", nullable = false, length = 100)
    private String apellidos;

    @Size(max = 100)
    @Email(message = "El correo electrónico no es válido")
    @Column(name = "email", length = 100)
    private String email;

    @Size(max = 15)
    @Pattern(
            regexp = "^[6,9][0-9]{8}$",
            message = "Teléfono de trabajador 9 dígitos que empiecen por 6 o 9"
    )
    @Column(name = "telefono", length = 15)
    private String telefono;

    @NotNull(message = "El sueldo no puede ser nulo")
    @Positive(message = "El sueldo debe ser un valor positivo, incluido 0")
    @Column(name = "sueldo", nullable = false, precision = 10, scale = 2)
    private BigDecimal sueldo;

    @Size(max = 50)
    @NotNull(message = "El puesto no puede ser nulo")
    @Column(name = "puesto", nullable = false, length = 50)
    private String puesto;

    public Trabajador() {
    }

    public Trabajador(String dni, String nombre, String apellidos, String email, String telefono, BigDecimal sueldo, String puesto) throws Exception {
        setDni(dni);
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.telefono = telefono;
        this.sueldo = sueldo;
        this.puesto = puesto;
    }

    public void setDni(@Size(max = 20) String dni) throws Exception {
        if(validarDNI(dni))
            this.dni = dni;
        else
            throw new Exception("DNI Inválido");
    }

    public static boolean validarDNI(String dni) {
        if(dni == null || !dni.matches("^[0-9]{8}[A-Za-z]$")){
            return false;
        }
        Integer nums = Integer.parseInt(dni.substring(0,8));
        char letra = Character.toUpperCase(dni.charAt(8));
        String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
        char letraBien = letras.charAt(nums%23);
        return letraBien == letra;
    }

    public @Size(max = 20) String getDni() {
        return dni;
    }

    public @Size(max = 50) @NotNull(message = "El nombre no puede ser nulo") @Pattern(
            regexp = "^[A-ZÁÉÍÓÚÑ][a-záéíóúñ0-9 _-]*$",
            message = "Nombre de trabajador empieza con mayúscula y solo con caracteres alfabéticos"
    ) String getNombre() {
        return nombre;
    }

    public void setNombre(@Size(max = 50) @NotNull(message = "El nombre no puede ser nulo") @Pattern(
            regexp = "^[A-ZÁÉÍÓÚÑ][a-záéíóúñ0-9 _-]*$",
            message = "Nombre de trabajador empieza con mayúscula y solo con caracteres alfabéticos"
    ) String nombre) {
        this.nombre = nombre;
    }

    public @Size(max = 100) @NotNull(message = "Los apellidos no pueden ser nulos") @Pattern(
            regexp = "^[A-ZÁÉÍÓÚÑa-záéíóúñ ]+$",
            message = "Apellidos de trabajador solo con caracteres alfabéticos"
    ) String getApellidos() {
        return apellidos;
    }

    public void setApellidos(@Size(max = 100) @NotNull(message = "Los apellidos no pueden ser nulos") @Pattern(
            regexp = "^[A-ZÁÉÍÓÚÑa-záéíóúñ ]+$",
            message = "Apellidos de trabajador solo con caracteres alfabéticos o espacios"
    ) String apellidos) {
        this.apellidos = apellidos;
    }

    public @Size(max = 100) @Email(message = "El correo electrónico no es válido") String getEmail() {
        return email;
    }

    public void setEmail(@Size(max = 100) @Email(message = "El correo electrónico no es válido") String email) {
        this.email = email;
    }

    public @Size(max = 15) @Pattern(
            regexp = "^[6,9][0-9]{8}$",
            message = "Teléfono de trabajador 9 dígitos que empiecen por 6 o 9"
    ) String getTelefono() {
        return telefono;
    }

    public void setTelefono(@Size(max = 15) @Pattern(
            regexp = "^[6,9][0-9]{8}$",
            message = "Teléfono de trabajador 9 dígitos que empiecen por 6 o 9"
    ) String telefono) {
        this.telefono = telefono;
    }

    public @NotNull(message = "El sueldo no puede ser nulo") @Positive(message = "El sueldo debe ser un valor positivo, incluido 0") BigDecimal getSueldo() {
        return sueldo;
    }

    public void setSueldo(@NotNull(message = "El sueldo no puede ser nulo") @Positive(message = "El sueldo debe ser un valor positivo, incluido 0") BigDecimal sueldo) {
        this.sueldo = sueldo;
    }

    public @Size(max = 50) @NotNull(message = "El puesto no puede ser nulo") String getPuesto() {
        return puesto;
    }

    public void setPuesto(@Size(max = 50) @NotNull(message = "El puesto no puede ser nulo") String puesto) {
        this.puesto = puesto;
    }

    @Override
    public String toString() {
        return "Trabajador(" +
                "dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", email='" + email + '\'' +
                ", telefono='" + telefono + '\'' +
                ", sueldo=" + sueldo +
                ", puesto='" + puesto + '\'' +
                ')';
    }
}