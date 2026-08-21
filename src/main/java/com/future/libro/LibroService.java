package com.future.libro;

import java.util.List;

public class LibroService {
    private final LibroRepository repository;

    public LibroService (LibroRepository repository) {
        this.repository = repository;
    }

   public void prestarLibro(long id, int amount) {
        Libro pepito = repository.buscarId(id);
        pepito.darLibro(amount);
        repository.cambiarCantidad(id, pepito.getCantidad());
    }

    public void devolverLibro (long id, int amount) {
        Libro salchicha = repository.buscarId(id);
        salchicha.recogerLibro(amount);
        repository.cambiarCantidad(id, salchicha.getCantidad());
    }

    public void crearLibro (Libro libro) {
        repository.addLibro(libro);
    }

    public List<Libro> obtenerLibros () {
        return repository.findAll();
    }

    public Libro obtenerLibroPorId (long id) {
        return repository.buscarId(id);
    }

    public void eliminarLibro(long id) {
        repository.eliminarLibro(id);
    }

    public void updateLibro(Libro libro) {
        repository.updateLibro(libro);
    }
}
