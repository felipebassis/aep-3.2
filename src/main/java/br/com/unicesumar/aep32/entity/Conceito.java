package br.com.unicesumar.aep32.entity;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "CONCEITO")
public class Conceito {

    @Id
    private String id;

    @Embedded
    private Nota nota;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_AVALIACAO")
    private Avaliação avaliação;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_ALUNO")
    private Aluno aluno;

    protected Conceito() {
    }

    public Conceito(Float nota, Avaliação avaliação, Aluno aluno) {
        this.id = UUID.randomUUID().toString();
        this.nota = new Nota(nota);
        this.avaliação = avaliação;
        this.aluno = aluno;
    }

    public Conceito(Avaliação avaliação, Aluno aluno) {
        this.id = UUID.randomUUID().toString();
        this.nota = new Nota(0F);
        this.avaliação = avaliação;
        this.aluno = aluno;
    }

    public String getId() {
        return id;
    }

    public Float getNota() {
        return nota.getValor();
    }

    public Avaliação getAvaliação() {
        return avaliação;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setNota(Float nota) {
        this.nota.setValor(nota);
    }

    public void setAvaliação(Avaliação avaliação) {
        this.avaliação = avaliação;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    @Embeddable
    private static class Nota {

        @Column(name = "nota")
        private Float valor;

        private Nota(Float valor) {
            checkValue(valor);
            this.valor = valor;
        }

        private Nota() {
        }

        private Float getValor() {
            return valor;
        }

        private void setValor(Float valor) {
            checkValue(valor);
            this.valor = valor;
        }

        private void checkValue(Float valor) {
            if (valor < 0 || valor > 10) {
                throw new IllegalArgumentException("Valor deve ser entre 0 e 10");
            }
        }
    }
}
