package com.biblioteca.bibliotecaDuoc.repository;

import com.biblioteca.bibliotecaDuoc.model.Libro;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class LibroRepository {
    
    private List<Libro> listaLibros = new ArrayList<>();

    public LibroRepository() {

        //agregar libros por defecto
        listaLibros.add(new Libro(1, "978-0140449136", "La Odisea", "Penguin Classics", -800, "Homero"));
        listaLibros.add(new Libro(2, "978-0061122415", "Matar a un ruiseñor", "Harper Perennial", 1960, "Harper Lee"));
        listaLibros.add(new Libro(3, "978-0307277671", "Kafka en la orilla", "Vintage", 2002, "Haruki Murakami"));
        listaLibros.add(new Libro(4, "978-8437610166", "Don Quijote de la Mancha", "Cátedra", 1605, "Miguel de Cervantes"));
        listaLibros.add(new Libro(5, "978-0451524935", "1984", "Signet Classics", 1949, "George Orwell"));
        listaLibros.add(new Libro(6, "978-9875668765", "Rayuela", "Sudamericana", 1963, "Julio Cortázar"));
        listaLibros.add(new Libro(7, "978-0141439600", "Orgullo y prejuicio", "Penguin Classics", 1813, "Jane Austen"));
        listaLibros.add(new Libro(8, "978-0307474278", "Los hombres me explican cosas", "Vintage", 2014, "Rebecca Solnit"));
        listaLibros.add(new Libro(9, "978-8423349705", "Patria", "Tusquets", 2016, "Fernando Aramburu"));
        listaLibros.add(new Libro(10, "978-0679783275", "Crimen y castigo", "Vintage", 1866, "Fiódor Dostoyevski"));

    }

    public List<Libro> obtenerLibros() {
        return listaLibros;
    }

    public Libro buscarPorId(int id){
        for (Libro libro : listaLibros) {
            if (libro.getId() == id) {
                return libro;
            }
        }
        return null;
    }

    public Libro buscarPorISBN(String ISBN){
        for (Libro libro : listaLibros) {
            if (libro.getIsbn().equals(ISBN)) {
                return libro;
            }
        }
        return null;
    }

    public Libro guardar(Libro lib){
        listaLibros.add(lib);
        return lib;
    }

    public Libro actualizar(Libro lib){
        int id = 0;
        int idPosicion = 0;

    for (int i = 0; i < listaLibros.size(); i++) {
        if (listaLibros.get(i).getId() == lib.getId()) {
            id = lib.getId();
            idPosicion = i;
        }
    }

    Libro libro1 = new Libro();
    libro1.setAutor(lib.getAutor());
    libro1.setEditorial(lib.getAutor());
    libro1.setFechaPublicacion(lib.getFechaPublicacion());
    libro1.setId(lib.getId());
    libro1.setIsbn(lib.getIsbn());
    libro1.setTitulo(lib.getTitulo());

    listaLibros.set(idPosicion, libro1);
    return libro1;
    }

    public void eliminar(int id){
        Libro libro = buscarPorId(id);
        if (libro != null) {
            listaLibros.remove(libro);
        }
        /* 
        int idPosicion = 0;
        for (int i = 0; i < listaLibros.size(); i++) {
            if (listaLibros.get(i).getId() == id) {
                idPosicion = i;
                break;
            }            
        if (idPosicion > 0) {
            listaLibros.remove(idPosicion);
        }
        }

        listaLibros.removeIf(x -> x.getId() == id);
        */
    }

    public int totalLibros() {
        return listaLibros.size();
    }

    public int cantidadDeLibrosPublicadosEnUnAñoEspecifico(int año){
        int cantidad = 0;
        for (Libro libro : listaLibros) {
            if (libro.getFechaPublicacion() == año) {
                cantidad += 1;
            }
        }
        return cantidad;
    }    

    public List<Libro> librosDeUnAutor(String autor){
        List<Libro> libros = new ArrayList<>();
        for (Libro libro : listaLibros) {
            if (libro.getAutor().equals(autor)) {
               libros.add(libro); 
            }
        }
        return libros;
    }

    public Libro libroMasAntiguo(){
        int año = 0;
        Libro libroMasAntiguo = null;
        for (Libro libro : listaLibros) {
            if (libro.getFechaPublicacion() < año) {
                año = libro.getFechaPublicacion();
                libroMasAntiguo = libro;
            }
        }
        return libroMasAntiguo;
    }

    public Libro libroMasNuevo(){
        int año = 0;
        Libro libroMasNuevo = null;
        for (Libro libro : listaLibros) {
            if (libro.getFechaPublicacion() > año) {
                año = libro.getFechaPublicacion();
                libroMasNuevo = libro;
            }
        }
        return libroMasNuevo;
    }

    public List<Libro> librosOrdenadosPorAño() {
        List<Libro> libros = new ArrayList<>(listaLibros); 
        int n = libros.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (libros.get(j).getFechaPublicacion() > libros.get(j + 1).getFechaPublicacion()) {
                    Libro temp = libros.get(j);
                    libros.set(j, libros.get(j + 1));
                    libros.set(j + 1, temp);
                }
            }
        }
        return libros;
    }
}
