package com.aluracursos.literAlura2.principal;

import com.aluracursos.literAlura2.model.*;
import com.aluracursos.literAlura2.repository.LibroRepository;
import com.aluracursos.literAlura2.service.ConsumoApi;
import com.aluracursos.literAlura2.service.ConvierteDatos;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Principal {
    private Scanner teclado =new Scanner(System.in);
    private LibroRepository libroRepository;
    private List<Libro> libros;
    private String URL_BASE = "https://gutendex.com/books/";
    private ConsumoApi consumoAPI = new ConsumoApi();
    private ConvierteDatos conversor = new ConvierteDatos();

    public Principal(LibroRepository libroRepository){
        this.libroRepository=libroRepository;
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
        var nombreTitulo =teclado.nextLine().toLowerCase();
        var json = consumoAPI.obtenerDatos(URL_BASE + "?search=" + nombreTitulo.replace(" ", "%20").toLowerCase());
        Resultado resultado = conversor.obtenerDatos(json,Resultado.class);
        libros =libroRepository.findAll();
        Optional<Libro> libro= libros.stream()
                .filter(s->s.getTitulo().toLowerCase().contains(nombreTitulo.toLowerCase()))
                .findFirst();
        if (resultado.cantidadResultado()==0){
            System.out.println("""
                    ***********************************
                    No se encontraron resultados
                    ***********************************\n""");

        }else if (libro.isPresent()){
            System.out.println("""
                    ***************************************
                    El libro ya esta en la base de datos
                    ***************************************\n""");

        }else {
            DatosLibro datosLibro = resultado.libros().get(0);
            DatosAutor datosAutor = datosLibro.autores().get(0);
            Libro libroAGuardar = new Libro();
            Autor autor = new Autor();
            libroAGuardar.setAutor(autor);
            libroRepository.save(libroAGuardar);
            System.out.printf(datosLibro.titulo(),
                    datosAutor.nombre(), datosLibro.idiomas(), datosLibro.cantDescargas());

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















