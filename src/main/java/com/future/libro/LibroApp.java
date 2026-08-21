package com.future.libro;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;



public class LibroApp {

    public static void main(String[] args) {

        String url = "jdbc:postgresql://localhost:5432/libreria_db";
        String username = "postgres";
        String password = System.getenv("DB_PASSWORD");

        try (Connection connection =
                DriverManager.getConnection(url, username, password)) {

            System.out.println("Подключение успешно");

            LibroRepository repository = new LibroRepository(connection);
            LibroService libroService = new LibroService(repository);

            Libro libro1 = new Libro("El gran Gatsby", 12, "F. Scot Fitzerald");
            libroService.crearLibro(libro1);

            libroService.prestarLibro(6, 6);

            libroService.devolverLibro(6, 2);
              
            libroService.obtenerLibroPorId(6);

            libroService.obtenerLibros();

            libroService.eliminarLibro(2);

            libroService.updateLibro(libro1);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        
    }
}
