package br.com.unisales.horarios.dto;

import java.util.List;

public class HorarioPorProfessorDTO {
    private Long professorId;
    private String nomeProfessor;
    private String titulacao;
    private List<AulaProfessorItem> aulas;

    public HorarioPorProfessorDTO(Long professorId, String nomeProfessor, String titulacao, List<AulaProfessorItem> aulas) {
        this.professorId = professorId;
        this.nomeProfessor = nomeProfessor;
        this.titulacao = titulacao;
        this.aulas = aulas;
    }

    public Long getProfessorId() { return professorId; }
    public String getNomeProfessor() { return nomeProfessor; }
    public String getTitulacao() { return titulacao; }
    public List<AulaProfessorItem> getAulas() { return aulas; }

    public static class AulaProfessorItem {
        private String disciplina;
        private String codigoDisciplina;
        private String turma;
        private String curso;
        private String diaSemana;
        private String horario;
        private String sala;

        public AulaProfessorItem(String disciplina, String codigoDisciplina, String turma,
                                 String curso, String diaSemana, String horario, String sala) {
            this.disciplina = disciplina;
            this.codigoDisciplina = codigoDisciplina;
            this.turma = turma;
            this.curso = curso;
            this.diaSemana = diaSemana;
            this.horario = horario;
            this.sala = sala;
        }

        public String getDisciplina() { return disciplina; }
        public String getCodigoDisciplina() { return codigoDisciplina; }
        public String getTurma() { return turma; }
        public String getCurso() { return curso; }
        public String getDiaSemana() { return diaSemana; }
        public String getHorario() { return horario; }
        public String getSala() { return sala; }
    }
}