package com.aluracursos.literAlura2.model;

import jakarta.persistence.*;
//import org.springframework.data.annotation.Id;


@Entity
@Table(name="libros")

public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String idiomas;
    private Integer cantDescargas;

    @ManyToOne
    private Autor autor;

    public Libro(){
    }

    public static Libro datosLibro (DatosLibro datosLibro){
     var libro = new Libro();

     libro.id =Long.valueOf(datosLibro.id());
     libro.titulo=datosLibro.titulo();
     libro.cantDescargas= datosLibro.cantDescargas();

     if (!datosLibro.idiomas().isEmpty()){
         libro.idiomas =datosLibro.idiomas().get(0);
     }

     if (!datosLibro.autores().isEmpty()){
        libro.autor = Autor.datosAutor(datosLibro.autores().get(0));
     }

        return libro;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(String idiomas) {
        this.idiomas = idiomas;
    }

    public Integer getCantDescargas() {
        return cantDescargas;
    }

    public void setCantDescargas(Integer cantDescargas) {
        this.cantDescargas = cantDescargas;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    @Override
    public String toString() {
        return "Libro{" +
                ", titulo='" + titulo + '\'' +
                ", idiomas='" + idiomas + '\'' +
                ", cantDescargas=" + cantDescargas +
                ", autor=" + autor +
                '}';
    }
}
