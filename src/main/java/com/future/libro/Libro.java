package com.future.libro;

public class Libro {

    private long id;
    private String titulo;
    private int cantidad;
    private String author;

    public Libro (long id, String titulo, int cantidad, String author) {
    
    if (cantidad < 1) {
        throw new InvalidBookException("Quantity must be at least 1");
    }

    this.id = id;
    setTitulo(titulo);
    this.cantidad = cantidad;
    this.author = author;
    }

    public Libro(String titulo, int cantidad, String author) {
    
    if (cantidad < 1) {
        throw new InvalidBookException("Quantity must be at least 1");
    }    

    setTitulo(titulo);
    this.cantidad = cantidad;
    this.author = author;
    }

    public void darLibro (int amount) {
    
    if (amount <= 0) {
        throw new InvalidAmountException ("La cantidad debe ser mayor que 0");
    }

    if (cantidad < amount) {
        throw new BookUnavailableException ("La cantidad de libros disponibles es insuficiente");
    }

    this.cantidad = cantidad - amount;
    
    }

    public void recogerLibro (int cantidadDevuelta) {
    
        if (cantidadDevuelta <= 0) {
            throw new InvalidAmountException ("La cantidad de libros debe ser mas que 0");
        } 

        this.cantidad = cantidad + cantidadDevuelta;
    
    }



    public long getId() {
        return id;
    }

    public int getCantidad() {
        return cantidad;
    }   

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        if (titulo == null || titulo.isBlank()) {
            throw new InvalidBookException ("El libro no puede ser null");
        }
        this.titulo = titulo;
    }

    public String getAuthor() {
        return author;
        }

}