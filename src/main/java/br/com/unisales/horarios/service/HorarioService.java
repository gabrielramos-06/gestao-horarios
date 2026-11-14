package br.com.unisales.horarios.service;

import br.com.unisales.horarios.dto.HorarioPorProfessorDTO;
import br.com.unisales.horarios.dto.HorarioPorTurmaDTO;
import br.com.unisales.horarios.dto.HorarioRequestDTO;
import br.com.unisales.horarios.model.Disciplina;
import br.com.unisales.horarios.model.Horario;
import br.com.unisales.horarios.model.Professor;
import br.com.unisales.horarios.model.Turma;
import br.com.unisales.horarios.repository.HorarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HorarioService {

    private final HorarioRepository horarioRepository;
    private final ProfessorService professorService;
    private final DisciplinaService disciplinaService;
    private final TurmaService turmaService;

    public HorarioService(HorarioRepository horarioRepository,
                          ProfessorService professorService,
                          DisciplinaService disciplinaService,
                          TurmaService turmaService) {
        this.horarioRepository = horarioRepository;
        this.professorService = professorService;
        this.disciplinaService = disciplinaService;
        this.turmaService = turmaService;
    }

    public List<Horario> listarTodos() {
        return horarioRepository.findAll();
    }

    public Horario buscarPorId(Long id) {
        return horarioRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Horário não encontrado com ID: " + id));
    }

    public Horario salvar(HorarioRequestDTO dto) {
        Professor professor = professorService.buscarPorId(dto.getProfessorId());
        Disciplina disciplina = disciplinaService.buscarPorId(dto.getDisciplinaId());
        Turma turma = turmaService.buscarPorId(dto.getTurmaId());

        Horario horario = new Horario(
            dto.getDiaSemana(),
            dto.getHoraInicio(),
            dto.getHoraFim(),
            dto.getSala(),
            professor,
            disciplina,
            turma
        );
        return horarioRepository.save(horario);
    }

    public Horario atualizar(Long id, HorarioRequestDTO dto) {
        Horario existente = buscarPorId(id);
        Professor professor = professorService.buscarPorId(dto.getProfessorId());
        Disciplina disciplina = disciplinaService.buscarPorId(dto.getDisciplinaId());
        Turma turma = turmaService.buscarPorId(dto.getTurmaId());

        existente.setDiaSemana(dto.getDiaSemana());
        existente.setHoraInicio(dto.getHoraInicio());
        existente.setHoraFim(dto.getHoraFim());
        existente.setSala(dto.getSala());
        existente.setProfessor(professor);
        existente.setDisciplina(disciplina);
        existente.setTurma(turma);

        return horarioRepository.save(existente);
    }

    public void excluir(Long id) {
        Horario existente = buscarPorId(id);
        horarioRepository.delete(existente);
    }

    public HorarioPorProfessorDTO consultarPorProfessor(Long professorId) {
        Professor professor = professorService.buscarPorId(professorId);
        List<Horario> horarios = horarioRepository.findByProfessorId(professorId);

        List<HorarioPorProfessorDTO.AulaProfessorItem> itens = horarios.stream()
            .map(h -> new HorarioPorProfessorDTO.AulaProfessorItem(
                h.getDisciplina().getNome(),
                h.getDisciplina().getCodigo(),
                h.getTurma().getCodigo(),
                h.getTurma().getCurso(),
                h.getDiaSemana(),
                h.getHoraInicio() + " às " + h.getHoraFim(),
                h.getSala()
            ))
            .collect(Collectors.toList());

        return new HorarioPorProfessorDTO(
            professor.getId(),
            professor.getNome(),
            professor.getTitulacao(),
            itens
        );
    }

    public HorarioPorTurmaDTO consultarPorTurma(Long turmaId) {
        Turma turma = turmaService.buscarPorId(turmaId);
        List<Horario> horarios = horarioRepository.findByTurmaId(turmaId);

        List<HorarioPorTurmaDTO.AulaTurmaItem> itens = horarios.stream()
            .map(h -> new HorarioPorTurmaDTO.AulaTurmaItem(
                h.getProfessor().getNome(),
                h.getProfessor().getEmail(),
                h.getDisciplina().getNome(),
                h.getDisciplina().getCodigo(),
                h.getDiaSemana(),
                h.getHoraInicio() + " às " + h.getHoraFim(),
                h.getSala()
            ))
            .collect(Collectors.toList());

        return new HorarioPorTurmaDTO(
            turma.getId(),
            turma.getCodigo(),
            turma.getCurso(),
            turma.getSemestre(),
            itens
        );
    }
}