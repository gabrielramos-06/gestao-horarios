package br.com.unisales.horarios.controller;

import br.com.unisales.horarios.model.Professor;
import br.com.unisales.horarios.service.ProfessorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/professores")
@Tag(name = "1. Professores", description = "Endpoints para cadastro, edição, exclusão e listagem de professores")
public class ProfessorController {

    private final ProfessorService service;

    public ProfessorController(ProfessorService service) {
        this.service = service;
    }

    @GetMapping
    @Operation(summary = "Listar todos os professores")
    public ResponseEntity<List<Professor>> listarTodos() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar professor por ID")
    public ResponseEntity<Professor> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PostMapping
    @Operation(summary = "Cadastrar um novo professor")
    public ResponseEntity<Professor> cadastrar(@Valid @RequestBody Professor professor) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.salvar(professor));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Editar dados de um professor")
    public ResponseEntity<Professor> atualizar(@PathVariable Long id, @Valid @RequestBody Professor professor) {
        return ResponseEntity.ok(service.atualizar(id, professor));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Excluir um professor")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }
}