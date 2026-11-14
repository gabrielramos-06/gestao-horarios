package br.com.unisales.horarios.controller;

import br.com.unisales.horarios.model.Turma;
import br.com.unisales.horarios.service.TurmaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/turmas")
@Tag(name = "3. Turmas", description = "Endpoints para cadastro, edição, exclusão e listagem de turmas")
public class TurmaController {

    private final TurmaService service;

    public TurmaController(TurmaService service) {
        this.service = service;
    }

    @GetMapping
    @Operation(summary = "Listar todas as turmas")
    public ResponseEntity<List<Turma>> listarTodas() {
        return ResponseEntity.ok(service.listarTodas());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar turma por ID")
    public ResponseEntity<Turma> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PostMapping
    @Operation(summary = "Cadastrar uma nova turma")
    public ResponseEntity<Turma> cadastrar(@Valid @RequestBody Turma turma) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.salvar(turma));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Editar dados de uma turma")
    public ResponseEntity<Turma> atualizar(@PathVariable Long id, @Valid @RequestBody Turma turma) {
        return ResponseEntity.ok(service.atualizar(id, turma));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Excluir uma turma")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }
}