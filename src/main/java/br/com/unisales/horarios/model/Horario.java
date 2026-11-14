package br.com.unisales.horarios.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "horarios")
public class Horario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O dia da semana é obrigatório (ex: SEGUNDA-FEIRA)")
    @Column(nullable = false)
    private String diaSemana;

    @NotBlank(message = "A hora de início é obrigatória (ex: 19:00)")
    @Column(nullable = false)
    private String horaInicio;

    @NotBlank(message = "A hora de término é obrigatória (ex: 20:40)")
    @Column(nullable = false)
    private String horaFim;

    @NotBlank(message = "A sala ou laboratório é obrigatório")
    @Column(nullable = false)
    private String sala;

    @ManyToOne(optional = false)
    @JoinColumn(name = "professor_id", nullable = false)
    private Professor professor;

    @ManyToOne(optional = false)
    @JoinColumn(name = "disciplina_id", nullable = false)
    private Disciplina disciplina;

    @ManyToOne(optional = false)
    @JoinColumn(name = "turma_id", nullable = false)
    private Turma turma;

    public Horario() {}

    public Horario(String diaSemana, String horaInicio, String horaFim, String sala,
                   Professor professor, Disciplina disciplina, Turma turma) {
        this.diaSemana = diaSemana;
        this.horaInicio = horaInicio;
        this.horaFim = horaFim;
        this.sala = sala;
        this.professor = professor;
        this.disciplina = disciplina;
        this.turma = turma;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getDiaSemana() { return diaSemana; }
    public void setDiaSemana(String diaSemana) { this.diaSemana = diaSemana; }
    public String getHoraInicio() { return horaInicio; }
    public void setHoraInicio(String horaInicio) { this.horaInicio = horaInicio; }
    public String getHoraFim() { return horaFim; }
    public void setHoraFim(String horaFim) { this.horaFim = horaFim; }
    public String getSala() { return sala; }
    public void setSala(String sala) { this.sala = sala; }
    public Professor getProfessor() { return professor; }
    public void setProfessor(Professor professor) { this.professor = professor; }
    public Disciplina getDisciplina() { return disciplina; }
    public void setDisciplina(Disciplina disciplina) { this.disciplina = disciplina; }
    public Turma getTurma() { return turma; }
    public void setTurma(Turma turma) { this.turma = turma; }
}