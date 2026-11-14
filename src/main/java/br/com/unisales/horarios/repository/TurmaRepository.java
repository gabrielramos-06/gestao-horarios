package br.com.unisales.horarios.repository;

import br.com.unisales.horarios.model.Turma;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TurmaRepository extends JpaRepository<Turma, Long> {
}