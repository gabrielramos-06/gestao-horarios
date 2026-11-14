package br.com.unisales.horarios.controller;

import br.com.unisales.horarios.dto.HorarioPorProfessorDTO;
import br.com.unisales.horarios.dto.HorarioPorTurmaDTO;
import br.com.unisales.horarios.dto.HorarioRequestDTO;
import br.com.unisales.horarios.model.Horario;
import br.com.unisales.horarios.service.HorarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/horarios")
@Tag(name = "4. Horários e Consultas Especiais", description = "Gerenciamento de horários e visualização consolidada por Professor e por Turma")
public class HorarioController {

    private final HorarioService service;

    public HorarioController(HorarioService service) {
        this.service = service;
    }

    @GetMapping
    @Operation(summary = "Listar todos os horários cadastrados")
    public ResponseEntity<List<Horario>> listarTodos() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar horário por ID")
    public ResponseEntity<Horario> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PostMapping
    @Operation(summary = "Cadastrar um novo horário de aula")
    public ResponseEntity<Horario> cadastrar(@Valid @RequestBody HorarioRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.salvar(dto));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Editar um horário de aula existente")
    public ResponseEntity<Horario> atualizar(@PathVariable Long id, @Valid @RequestBody HorarioRequestDTO dto) {
        return ResponseEntity.ok(service.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Excluir um horário de aula")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/professor/{professorId}")
    @Operation(
        summary = "Visualização de horários por Professor",
        description = "Seleciona um professor pelo ID e exibe: disciplinas ministradas, turmas associadas, dias e horários das aulas."
    )
    public ResponseEntity<HorarioPorProfessorDTO> visualizarPorProfessor(@PathVariable Long professorId) {
        return ResponseEntity.ok(service.consultarPorProfessor(professorId));
    }

    @GetMapping("/turma/{turmaId}")
    @Operation(
        summary = "Visualização de horários por Turma",
        description = "Seleciona uma turma pelo ID e exibe: professores responsáveis, disciplinas oferecidas, dias e horários das aulas."
    )
    public ResponseEntity<HorarioPorTurmaDTO> visualizarPorTurma(@PathVariable Long turmaId) {
        return ResponseEntity.ok(service.consultarPorTurma(turmaId));
    }
}