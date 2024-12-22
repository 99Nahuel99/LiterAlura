package com.aluracursos.literAlura2.service;

import com.aluracursos.literAlura2.model.DatosAutor;
import com.aluracursos.literAlura2.model.DatosLibro;
import com.aluracursos.literAlura2.model.Libro;
import com.aluracursos.literAlura2.model.Resultado;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

import static java.awt.SystemColor.text;

public class ServiceLibro {
    private String baseURL = "https://gutendex.com/books/";

    public List<DatosLibro> busqueda(String texto){
        var json= ConsumoApi.getData(baseURL + "?search=");

        return new ConvierteDatos().convert(json, Resultado.class).libros();
    }

    public List<DatosAutor>getAutorVivosDeterminadoAño(Integer fecha){
        var busquedaFecha =baseURL + "?author_year_start=" + fecha + "&author_year_end=" + fecha;
        var json =ConsumoApi.getData(busquedaFecha);

        return new ConvierteDatos().convert(json,Resultado.class).libros().stream()
                .flatMap(l -> l.autores().stream())
                .toList();
    }

}
