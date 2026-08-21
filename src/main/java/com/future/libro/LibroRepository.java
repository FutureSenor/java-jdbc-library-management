package com.future.libro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import javax.management.RuntimeErrorException;

import org.postgresql.core.SqlCommand;

public class LibroRepository {

    private final Connection connection;
   


    public LibroRepository(Connection connection) {
        this.connection = connection;
    }

    public List<Libro> findAll() {
        List<Libro> librosEncontrados = new ArrayList<>();
        String sql = "SELECT * FROM books";

        try(PreparedStatement statement = 
            connection.prepareStatement(sql)){
                ResultSet resultSet = statement.executeQuery();
                
                while (resultSet.next()) {
                    long id = resultSet.getLong("id");
                    String title = resultSet.getString("title");
                    int cantidad = resultSet.getInt("quantity");
                    String nombre = resultSet.getString("author");
                    
                    Libro libro = new Libro(id, title, cantidad, nombre);
                    librosEncontrados.add(libro);
                }
            
            }catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        return librosEncontrados;
    }

    public Libro buscarId(long id) {
        String sqlId = "select * from books where id = ?";



        try (PreparedStatement statement = connection.prepareStatement(sqlId)) {
            statement.setLong(1,id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                long bookId = resultSet.getLong("id");
                String title = resultSet.getString("title");
                int cantidad = resultSet.getInt("quantity");
                String nombre = resultSet.getString("author");

                Libro libro = new Libro(bookId, title, cantidad, nombre);
                return libro;
            }else{
                throw new InvalidBookException 
                ("No existe el libro con ese id");
            }


        }catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public void addLibro(Libro libro) {
        String sqlAdd = "insert into books (title, author, quantity) values (?, ?, ?) ";

        if (libro == null) {
            throw new InvalidBookException("El libro no puede ser null");
        }

        try (PreparedStatement statement = connection.prepareStatement(sqlAdd)) {
            statement.setString(1, libro.getTitulo());
            statement.setInt(3, libro.getCantidad());
            statement.setString(2, libro.getAuthor());
            int affectedRows = statement.executeUpdate();

            if (affectedRows == 0) {
                throw new RuntimeException ("No se pudo guardar el libro");
            }

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void cambiarCantidad (long id, int cantidad) {

        String sqlCambiar = "update books set quantity = ? where id = ?";

        try (PreparedStatement statement = connection.prepareStatement(sqlCambiar)) {
            statement.setInt(1,cantidad);
            statement.setLong(2,id);
            int affectedRows = statement.executeUpdate();

            if (affectedRows == 0) {
                throw new RuntimeException ("No se pudo cambiar el libro");
            }

        }catch (SQLException e){
            throw new RuntimeException (e);
        }
    }

    public void eliminarLibro (long id) {
        String sqlDelete = "delete from books where id = ?";

        try (PreparedStatement statement = connection.prepareStatement(sqlDelete)) {
            statement.setLong(1, id);
            int affectedRows = statement.executeUpdate();

            if (affectedRows == 0) {
                throw new RuntimeException("Nungun libro no se elimino");
            }

            }catch (SQLException e) {
                throw new RuntimeException(e);
        }
    }

    public void updateLibro(Libro libro) {
        String sqlUpdate = "update books set titulo = ?, author = ?, quantity = ? where id = ?";

        try (PreparedStatement statement = connection.prepareStatement(sqlUpdate)){
            statement.setString(1, libro.getTitulo());
            statement.setString(2, libro.getAuthor());
            statement.setInt(3, libro.getCantidad());
            statement.setLong(4, libro.getId());
            int affectedRows = statement.executeUpdate();
        
            if (affectedRows == 0) {
                throw new RuntimeException("los cambios no completan");
            }
        
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
