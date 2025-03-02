package org.example.granjadao.MODEL;

import jakarta.persistence.*;
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
    private String nombre;
    private String especie;
}
