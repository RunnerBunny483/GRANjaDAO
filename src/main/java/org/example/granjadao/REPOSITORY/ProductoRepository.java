package org.example.granjadao.REPOSITORY;

import org.example.granjadao.MODEL.Producto;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductoRepository {
    private static final String FILE_PATH = "src/main/resources/Productos.txt";

    public List<Producto> leerProductos() throws IOException {
        List<Producto> productos = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length == 5) {
                    int id = Integer.parseInt(datos[0]);
                    String nombre = datos[1];
                    String descripcion = datos[2];
                    double precio = Double.parseDouble(datos[3]);
                    int cantidad = Integer.parseInt(datos[4]);

                    Producto producto = new Producto(id, nombre, descripcion, precio, cantidad);
                    productos.add(producto);
                }
            }
        }
        return productos;
    }
}
