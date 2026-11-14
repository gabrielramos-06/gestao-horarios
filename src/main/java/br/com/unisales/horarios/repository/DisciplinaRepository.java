package br.com.unisales.horarios.repository;

import br.com.unisales.horarios.model.Disciplina;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DisciplinaRepository extends JpaRepository<Disciplina, Long> {
}