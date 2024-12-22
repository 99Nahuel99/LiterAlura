package com.aluracursos.literAlura2.repository;

import com.aluracursos.literAlura2.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AutorRepository extends JpaRepository<Autor,Long> {

    List<Autor> findByFechaNacimientoFechaFallecimiento(Integer fecha1,Integer fecha2);
}
