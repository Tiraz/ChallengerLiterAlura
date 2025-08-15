package com.alura.challenger.literalura.repositorio;

import com.alura.challenger.literalura.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LivroRepository extends JpaRepository<Livro, Long> {

    @Query("""
        SELECT l FROM Livro l 
        JOIN l.idiomas i 
        WHERE i = :idioma
    """)
    List<Livro> findByIdioma(@Param("idioma") String idioma);
}
