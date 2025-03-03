package org.example.granjadao.REPOSITORY;

import org.example.granjadao.MODEL.Producto;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ProductoRepository {
    private static final String rutaTXT = "src/main/resources/Productos.txt";

    //Leer
    public List<Producto> leerProductos() throws IOException {
        List<Producto> productos = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(rutaTXT))) {
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

    //Escribir
    public Producto escribirProducto(Producto producto) throws IOException {
        List<Producto> productos = leerProductos();

        //Verificar si el ID ya existe
        boolean idExiste = productos.stream().anyMatch(p -> p.getId().equals(producto.getId()));

        //Manera imperativa con forEach:
//        boolean idExisteForEach = false;
//        for (Producto productoForEach : productos) {
//            if (productoForEach.getId().equals(producto.getId())) {
//                idExisteForEach = true;
//            }
//        }

        if (idExiste) {
            throw new RuntimeException("El ID del producto ya existe: " + producto.getId());
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(rutaTXT, true))) { // Modo append
            String linea = producto.getId() + "," +
                    producto.getNombre() + "," +
                    producto.getDescripcion() + "," +
                    producto.getPrecio() + "," +
                    producto.getCantidad();

            bw.write(linea);
            bw.newLine();
        }
        return producto;
    }

    public void escribirProductos(List<Producto> productos) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(rutaTXT))) {
            for (Producto producto : productos) {
                String linea = producto.getId() + "," +
                        producto.getNombre() + "," +
                        producto.getDescripcion() + "," +
                        producto.getPrecio() + "," +
                        producto.getCantidad();

                bw.write(linea);
                bw.newLine();
            }
        }
    }


    //Borrar
    public void deleteProducto(int id) throws IOException {
        List<Producto> productos = leerProductos();
        // Buscar el producto por su ID
        Producto productoDelete = productos.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Producto no encontrado con ID: " + id));

        //Manera imperativa con forEach:
//        Producto productoEncontrado = null;
//        for (Producto productoForEach : productos) {
//            if (productoForEach.getId() == id) {
//                productoEncontrado = productoForEach;
//                break;
//            }
//        }
//        if(productoEncontrado == null) throw new RuntimeException("Producto no encontrado con ID: " + id);

        productos.remove(productoDelete);
        escribirProductos(productos);
    }

    //Buscar por id
    public Producto findById(int id) throws IOException {
        List<Producto> productos = leerProductos();
        return productos.stream()
                .filter(producto -> producto.getId() == id)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Producto no encontrado con ID: " + id));
    }
}
