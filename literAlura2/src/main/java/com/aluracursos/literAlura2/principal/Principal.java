package com.aluracursos.literAlura2.principal;

import com.aluracursos.literAlura2.model.Libro;
import com.aluracursos.literAlura2.repository.AutorRepository;
import com.aluracursos.literAlura2.repository.LibroRepository;
import com.aluracursos.literAlura2.service.ServiceLibro;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    private Scanner teclado =new Scanner(System.in);

    private AutorRepository autorRepository;
    private LibroRepository libroRepository;
    private ServiceLibro serviceLibro;
    private List<String>posiblesIdiomas;

    public Principal(AutorRepository autorRepository,LibroRepository libroRepository,ServiceLibro serviceLibro){
        this.autorRepository =autorRepository;
        this.libroRepository=libroRepository;
        this.serviceLibro=serviceLibro;

        posiblesIdiomas= new ArrayList<>();
        posiblesIdiomas.add("pt");
        posiblesIdiomas.add("es");
        posiblesIdiomas.add("en");
        posiblesIdiomas.add("fr");
    }
    public void muestaMenu(){
        var opcion=-1;
        while (opcion !=0){
            var menu = """
                   
                    1-Busqueda de libro por autor
                    2-Mostar todos los libros buscados
                    3-Mosar los autores de los libros buscados
                    4-Mostar los autores en un determinado año
                    5-Cantidad de libros en un determinado idioma
                    0-SALIR
                    
                    """;

            System.out.println(menu);
            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion){
                case 1:
                    busquedaDeLibroPorTitulo();
                    break;
                case 2:
                    listarTodosLosLibros();

                    break;
                case 3:
                    mostarTodosLosAutores();
                    break;
                case 4:
                    mostrarAutoresDeterminadaFecha();
                    break;
                case 5:
                    mostarCantidadDeLibroPorDescargas();
                    break;
                case 0:
                    System.out.println("Programa finalizado");
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        }
    }

    private void busquedaDeLibroPorTitulo() {
        System.out.println("Escriba el nombre del titulo que desea buscar");
        var titulo = teclado.nextLine();
        var libroDatos =serviceLibro.busqueda( titulo.replace(" ", "+")).stream().findFirst();
        if(libroDatos.isEmpty()){
            System.out.println("Libro no encontrado");

        }else {
            var libro = Libro.datosLibro(libroDatos.get());
            autorRepository.save(libro.getAutor());
            libroRepository.save(libro);

        }
    }

    private void listarTodosLosLibros() {
        var libro =libroRepository.findAll();
        if (libro.isEmpty()){
            System.out.println("No hay libros guardados");
        }
    }

    private void mostarTodosLosAutores() {
    }

    private void mostrarAutoresDeterminadaFecha() {

    }

    private void mostarCantidadDeLibroPorDescargas() {

    }

}















