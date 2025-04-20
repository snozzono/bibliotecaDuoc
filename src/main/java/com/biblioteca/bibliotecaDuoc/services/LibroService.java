package com.biblioteca.bibliotecaDuoc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biblioteca.bibliotecaDuoc.repository.LibroRepository;
import com.biblioteca.bibliotecaDuoc.model.Libro;

@Service
public class LibroService {
    
    @Autowired
    private LibroRepository libroRepository;

    public List<Libro> getLibros() {
        return libroRepository.obtenerLibros();
    }

    public Libro saveLibro(Libro libro){
        return libroRepository.guardar(libro);
    }

    public Libro getLibroId(int id){
        return libroRepository.buscarPorId(id);
    }

    public Libro updateLibro(Libro libro){
        return libroRepository.actualizar(libro);
    }

    public Libro deleteLibro(Libro libro){
        return libroRepository.actualizar(libro);
    }

    public String deleteLibro(int id){
        libroRepository.eliminar(id);
        return "Producto eliminado";
    }

    public int totalLibrosV1(){
        return libroRepository.obtenerLibros().size();
    }

    public int totalLibrosV2(){
        return libroRepository.totalLibros();
    }

    public Libro buscarPorISBN(String isbn){
        return libroRepository.buscarPorISBN(isbn);
    }

    public int cantidadDeLibrosPublicadosEnUnAñoEspecifico(int año){
        return libroRepository.cantidadDeLibrosPublicadosEnUnAñoEspecifico(año);
    }
    public List<Libro> librosDeUnAutor(String autor){   
        return libroRepository.librosDeUnAutor(autor);
    }

    public Libro libroMasAntiguo(){
        return libroRepository.libroMasAntiguo();
    }

    public Libro libroMasNuevo(){
        return libroRepository.libroMasNuevo();
    }

    public List<Libro> librosOrdenadosPorAño(){
        return libroRepository.librosOrdenadosPorAño();
    }
}
