package com.aluracursos.literAlura2.repository;

import com.aluracursos.literAlura2.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LibroRepository extends JpaRepository<Libro,Long> {
    List<Libro> findByIdioma (String idioma);
    Integer countByIdioma(String idioma);
    List<Libro> findTop10ByOrderByDownloadsDesc();

}
