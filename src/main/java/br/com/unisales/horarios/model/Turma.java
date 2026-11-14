package br.com.unisales.horarios.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "turmas")
public class Turma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O código da turma é obrigatório")
    @Column(nullable = false, unique = true)
    private String codigo;

    @NotBlank(message = "O nome do curso é obrigatório")
    @Column(nullable = false)
    private String curso;

    @NotBlank(message = "O semestre letivo é obrigatório (ex: 2026/2)")
    @Column(nullable = false)
    private String semestre;

    public Turma() {}

    public Turma(String codigo, String curso, String semestre) {
        this.codigo = codigo;
        this.curso = curso;
        this.semestre = semestre;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }
    public String getCurso() { return curso; }
    public void setCurso(String curso) { this.curso = curso; }
    public String getSemestre() { return semestre; }
    public void setSemestre(String semestre) { this.semestre = semestre; }
}