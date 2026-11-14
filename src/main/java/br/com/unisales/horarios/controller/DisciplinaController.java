package br.com.unisales.horarios.controller;

import br.com.unisales.horarios.model.Disciplina;
import br.com.unisales.horarios.service.DisciplinaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/disciplinas")
@Tag(name = "2. Disciplinas", description = "Endpoints para cadastro, edição, exclusão e listagem de disciplinas")
public class DisciplinaController {

    private final DisciplinaService service;

    public DisciplinaController(DisciplinaService service) {
        this.service = service;
    }

    @GetMapping
    @Operation(summary = "Listar todas as disciplinas")
    public ResponseEntity<List<Disciplina>> listarTodas() {
        return ResponseEntity.ok(service.listarTodas());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar disciplina por ID")
    public ResponseEntity<Disciplina> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PostMapping
    @Operation(summary = "Cadastrar uma nova disciplina")
    public ResponseEntity<Disciplina> cadastrar(@Valid @RequestBody Disciplina disciplina) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.salvar(disciplina));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Editar dados de uma disciplina")
    public ResponseEntity<Disciplina> atualizar(@PathVariable Long id, @Valid @RequestBody Disciplina disciplina) {
        return ResponseEntity.ok(service.atualizar(id, disciplina));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Excluir uma disciplina")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }
}