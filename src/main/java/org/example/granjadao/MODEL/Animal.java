package org.example.granjadao.MODEL;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "animales")
public class Animal {
    @Id
    private Integer id;

    @Size(max = 50)
    @NotNull(message = "El nombre no puede ser nulo")
    @Pattern(
            regexp = "^[A-ZÁÉÍÓÚÑ][A-ZÁÉÍÓÚÑa-záéíóúñ ]*$",
            message = "Nombre de animal empieza con mayúscula y solo con caracteres alfabéticos"
    )
    private String nombre;

    @Size(max = 50)
    @NotNull(message = "La especie no puede ser nula")
    @Pattern(
            regexp = "^[A-ZÁÉÍÓÚÑ][A-ZÁÉÍÓÚÑa-záéíóúñ ]*$",
            message = "La especie debe empezar con mayúscula y solo contener letras"
    )
    private String especie;
}
