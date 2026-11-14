package br.com.unisales.horarios.config;

import br.com.unisales.horarios.model.Disciplina;
import br.com.unisales.horarios.model.Horario;
import br.com.unisales.horarios.model.Professor;
import br.com.unisales.horarios.model.Turma;
import br.com.unisales.horarios.repository.DisciplinaRepository;
import br.com.unisales.horarios.repository.HorarioRepository;
import br.com.unisales.horarios.repository.ProfessorRepository;
import br.com.unisales.horarios.repository.TurmaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {

    @Bean
    public CommandLineRunner loadData(ProfessorRepository profRepo,
                                      DisciplinaRepository discRepo,
                                      TurmaRepository turmaRepo,
                                      HorarioRepository horarioRepo) {
        return args -> {
            if (profRepo.count() == 0) {
                Professor p1 = profRepo.save(new Professor("Dr. Carlos Eduardo Silva", "carlos.silva@unisales.br", "Doutor"));
                Professor p2 = profRepo.save(new Professor("Dra. Mariana Costa", "mariana.costa@unisales.br", "Mestre"));

                Disciplina d1 = discRepo.save(new Disciplina("Desenvolvimento Back-End", "DBE-2026", 80));
                Disciplina d2 = discRepo.save(new Disciplina("Infraestrutura em Nuvem e Sistemas Distribuídos", "INSD-2026", 60));

                Turma t1 = turmaRepo.save(new Turma("ADS-4N", "Análise e Desenvolvimento de Sistemas", "2026/2"));
                Turma t2 = turmaRepo.save(new Turma("ES-4N", "Engenharia de Software", "2026/2"));

                horarioRepo.save(new Horario("SEGUNDA-FEIRA", "19:00", "20:40", "Lab 04", p1, d1, t1));
                horarioRepo.save(new Horario("QUARTA-FEIRA", "20:50", "22:30", "Lab 02", p1, d1, t2));
                horarioRepo.save(new Horario("TERCA-FEIRA", "19:00", "20:40", "Lab 05", p2, d2, t1));
            }
        };
    }
}