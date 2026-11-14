package br.com.unisales.horarios.service;

import br.com.unisales.horarios.model.Professor;
import br.com.unisales.horarios.repository.ProfessorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessorService {

    private final ProfessorRepository repository;

    public ProfessorService(ProfessorRepository repository) {
        this.repository = repository;
    }

    public List<Professor> listarTodos() {
        return repository.findAll();
    }

    public Professor buscarPorId(Long id) {
        return repository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Professor não encontrado com ID: " + id));
    }

    public Professor salvar(Professor professor) {
        return repository.save(professor);
    }

    public Professor atualizar(Long id, Professor atualizado) {
        Professor existente = buscarPorId(id);
        existente.setNome(atualizado.getNome());
        existente.setEmail(atualizado.getEmail());
        existente.setTitulacao(atualizado.getTitulacao());
        return repository.save(existente);
    }

    public void excluir(Long id) {
        Professor existente = buscarPorId(id);
        repository.delete(existente);
    }
}