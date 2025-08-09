package com.alura.challenger.literalura.repositorio;

import com.alura.challenger.literalura.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Long> {
}
