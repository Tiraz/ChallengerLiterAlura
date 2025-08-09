package com.alura.challenger.literalura.repositorio;

import com.alura.challenger.literalura.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Autor, Long> {
}
