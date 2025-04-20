package com.biblioteca.bibliotecaDuoc.controller;

import org.springframework.beans.factory.annotation.Autowired;
/* 
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;
*/
import org.springframework.web.bind.annotation.*;

import com.biblioteca.bibliotecaDuoc.services.LibroService;
import com.biblioteca.bibliotecaDuoc.model.Libro;

import java.util.List;

@RestController
@RequestMapping("/api/v1/libros")
public class libroController {
    
    @Autowired
    private LibroService libroService;

    @GetMapping
    public List<Libro> listarLibros(){
        return libroService.getLibros();
    }

    @PostMapping
    public Libro agregarLibro(@RequestBody Libro libro){
        return libroService.saveLibro(libro);
    }

    @GetMapping("{id}")
    public Libro buscarLibro(@PathVariable int id){
        return libroService.getLibroId(id);
    }

    @PutMapping("{id}")
    public Libro actualizarLibro(@PathVariable int id, @RequestBody Libro libro){
        // más adelante
        return libroService.updateLibro(libro);
    }

    @DeleteMapping("{id}")
    public String eliminarLbro(@PathVariable int id){
        return libroService.deleteLibro(id);
    }

    @GetMapping("/total")
    public int totalLibrosV2(){
        return libroService.totalLibrosV2();
    }

    @GetMapping("/isbn/{isbn}")
    public Libro buscarPorIsbn(@PathVariable String isbn){
        return libroService.buscarPorISBN(isbn);
    }

    @GetMapping("/año/{año}")
    public int cantidadDeLibrosPublicadosEnUnAñoEspecifico(@PathVariable int año){
        return libroService.cantidadDeLibrosPublicadosEnUnAñoEspecifico(año);
    }

    @GetMapping("/autor/{autor}")
    public List<Libro> librosDeUnAutor(@PathVariable String autor){
        return libroService.librosDeUnAutor(autor);
    }

    @GetMapping("/mas_antiguo")
    public Libro libroMasAntiguo(){
        return libroService.libroMasAntiguo();
    }

    @GetMapping("/mas_nuevo")
    public Libro libroMasNuevo(){
        return libroService.libroMasNuevo();
    }

    @GetMapping("/ordenadosxaño")
    public List<Libro> librosOrdenadosPorAño(){
        return libroService.librosOrdenadosPorAño();
    }
}