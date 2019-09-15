package br.com.unicesumar.aep32.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "AVALIACAO")
public class Avaliação {

    @Id
    private String id;

    private String disciplina;

    private LocalDate dataAplicação;

    protected Avaliação() {
    }

    public Avaliação(String disciplina, LocalDate dataAplicação) {
        this.id = UUID.randomUUID().toString();
        this.disciplina = disciplina;
        this.dataAplicação = dataAplicação;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public void setDataAplicação(LocalDate dataAplicação) {
        this.dataAplicação = dataAplicação;
    }
}
