package com.aluracursos.literAlura2.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Resultado(
        @JsonAlias("results")List<DatosLibro> libros,
        @JsonAlias ("count") int cantidadResultado
        ) {
}
