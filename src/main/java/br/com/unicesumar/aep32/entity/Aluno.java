package br.com.unicesumar.aep32.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "ALUNO")
public class Aluno {

    @Id
    private String id;

    private String nome;

    protected Aluno() {
    }

    public Aluno(String nome) {
        this.id = UUID.randomUUID().toString();
        this.nome = nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
