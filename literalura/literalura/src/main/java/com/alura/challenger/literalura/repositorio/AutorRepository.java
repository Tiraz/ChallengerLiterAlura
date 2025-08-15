package com.alura.challenger.literalura.repositorio;

import com.alura.challenger.literalura.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AutorRepository extends JpaRepository<Autor, Long> {

    @Query("""
    SELECT a FROM Autor a
    WHERE a.aniversario <= :anoEscolhido
      AND (a.anoMorte >= :anoEscolhido OR a.anoMorte IS NULL)
    """)
    List<Autor> findAnoVivo(@Param("anoEscolhido") int anoEscolhido);
}
