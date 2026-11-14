package br.com.unisales.horarios.dto;

import java.util.List;

public class HorarioPorTurmaDTO {
    private Long turmaId;
    private String codigoTurma;
    private String curso;
    private String semestre;
    private List<AulaTurmaItem> gradeHoraria;

    public HorarioPorTurmaDTO(Long turmaId, String codigoTurma, String curso, String semestre, List<AulaTurmaItem> gradeHoraria) {
        this.turmaId = turmaId;
        this.codigoTurma = codigoTurma;
        this.curso = curso;
        this.semestre = semestre;
        this.gradeHoraria = gradeHoraria;
    }

    public Long getTurmaId() { return turmaId; }
    public String getCodigoTurma() { return codigoTurma; }
    public String getCurso() { return curso; }
    public String getSemestre() { return semestre; }
    public List<AulaTurmaItem> getGradeHoraria() { return gradeHoraria; }

    public static class AulaTurmaItem {
        private String professorResponsavel;
        private String emailProfessor;
        private String disciplinaOferecida;
        private String codigoDisciplina;
        private String diaSemana;
        private String horario;
        private String sala;

        public AulaTurmaItem(String professorResponsavel, String emailProfessor, String disciplinaOferecida,
                             String codigoDisciplina, String diaSemana, String horario, String sala) {
            this.professorResponsavel = professorResponsavel;
            this.emailProfessor = emailProfessor;
            this.disciplinaOferecida = disciplinaOferecida;
            this.codigoDisciplina = codigoDisciplina;
            this.diaSemana = diaSemana;
            this.horario = horario;
            this.sala = sala;
        }

        public String getProfessorResponsavel() { return professorResponsavel; }
        public String getEmailProfessor() { return emailProfessor; }
        public String getDisciplinaOferecida() { return disciplinaOferecida; }
        public String getCodigoDisciplina() { return codigoDisciplina; }
        public String getDiaSemana() { return diaSemana; }
        public String getHorario() { return horario; }
        public String getSala() { return sala; }
    }
}