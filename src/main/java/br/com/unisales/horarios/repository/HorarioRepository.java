package br.com.unisales.horarios.repository;

import br.com.unisales.horarios.model.Horario;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface HorarioRepository extends JpaRepository<Horario, Long> {
    List<Horario> findByProfessorId(Long professorId);
    List<Horario> findByTurmaId(Long turmaId);
}