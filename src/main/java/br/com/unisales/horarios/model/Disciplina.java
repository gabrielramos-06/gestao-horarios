package br.com.unisales.horarios.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "disciplinas")
public class Disciplina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome da disciplina é obrigatório")
    @Column(nullable = false)
    private String nome;

    @NotBlank(message = "O código da disciplina é obrigatório")
    @Column(nullable = false, unique = true)
    private String codigo;

    @NotNull(message = "A carga horária é obrigatória")
    @Min(value = 20, message = "A carga horária mínima deve ser de 20 horas")
    @Column(nullable = false)
    private Integer cargaHoraria;

    public Disciplina() {}

    public Disciplina(String nome, String codigo, Integer cargaHoraria) {
        this.nome = nome;
        this.codigo = codigo;
        this.cargaHoraria = cargaHoraria;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }
    public Integer getCargaHoraria() { return cargaHoraria; }
    public void setCargaHoraria(Integer cargaHoraria) { this.cargaHoraria = cargaHoraria; }
}