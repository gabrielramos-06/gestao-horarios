package br.com.unisales.horarios.service;

import br.com.unisales.horarios.model.Disciplina;
import br.com.unisales.horarios.repository.DisciplinaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DisciplinaService {

    private final DisciplinaRepository repository;

    public DisciplinaService(DisciplinaRepository repository) {
        this.repository = repository;
    }

    public List<Disciplina> listarTodas() {
        return repository.findAll();
    }

    public Disciplina buscarPorId(Long id) {
        return repository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Disciplina não encontrada com ID: " + id));
    }

    public Disciplina salvar(Disciplina disciplina) {
        return repository.save(disciplina);
    }

    public Disciplina atualizar(Long id, Disciplina atualizada) {
        Disciplina existente = buscarPorId(id);
        existente.setNome(atualizada.getNome());
        existente.setCodigo(atualizada.getCodigo());
        existente.setCargaHoraria(atualizada.getCargaHoraria());
        return repository.save(existente);
    }

    public void excluir(Long id) {
        Disciplina existente = buscarPorId(id);
        repository.delete(existente);
    }
}