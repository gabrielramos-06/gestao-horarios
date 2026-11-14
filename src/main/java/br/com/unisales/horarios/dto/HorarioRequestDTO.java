package br.com.unisales.horarios.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class HorarioRequestDTO {

    @NotBlank(message = "O dia da semana é obrigatório")
    private String diaSemana;

    @NotBlank(message = "A hora de início é obrigatória")
    private String horaInicio;

    @NotBlank(message = "A hora de fim é obrigatória")
    private String horaFim;

    @NotBlank(message = "A sala é obrigatória")
    private String sala;

    @NotNull(message = "O ID do professor é obrigatório")
    private Long professorId;

    @NotNull(message = "O ID da disciplina é obrigatório")
    private Long disciplinaId;

    @NotNull(message = "O ID da turma é obrigatório")
    private Long turmaId;

    public String getDiaSemana() { return diaSemana; }
    public void setDiaSemana(String diaSemana) { this.diaSemana = diaSemana; }
    public String getHoraInicio() { return horaInicio; }
    public void setHoraInicio(String horaInicio) { this.horaInicio = horaInicio; }
    public String getHoraFim() { return horaFim; }
    public void setHoraFim(String horaFim) { this.horaFim = horaFim; }
    public String getSala() { return sala; }
    public void setSala(String sala) { this.sala = sala; }
    public Long getProfessorId() { return professorId; }
    public void setProfessorId(Long professorId) { this.professorId = professorId; }
    public Long getDisciplinaId() { return disciplinaId; }
    public void setDisciplinaId(Long disciplinaId) { this.disciplinaId = disciplinaId; }
    public Long getTurmaId() { return turmaId; }
    public void setTurmaId(Long turmaId) { this.turmaId = turmaId; }
}