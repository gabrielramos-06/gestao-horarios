package br.com.unisales.horarios.service;

import br.com.unisales.horarios.model.Turma;
import br.com.unisales.horarios.repository.TurmaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TurmaService {

    private final TurmaRepository repository;

    public TurmaService(TurmaRepository repository) {
        this.repository = repository;
    }

    public List<Turma> listarTodas() {
        return repository.findAll();
    }

    public Turma buscarPorId(Long id) {
        return repository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Turma não encontrada com ID: " + id));
    }

    public Turma salvar(Turma turma) {
        return repository.save(turma);
    }

    public Turma atualizar(Long id, Turma atualizada) {
        Turma existente = buscarPorId(id);
        existente.setCodigo(atualizada.getCodigo());
        existente.setCurso(atualizada.getCurso());
        existente.setSemestre(atualizada.getSemestre());
        return repository.save(existente);
    }

    public void excluir(Long id) {
        Turma existente = buscarPorId(id);
        repository.delete(existente);
    }
}