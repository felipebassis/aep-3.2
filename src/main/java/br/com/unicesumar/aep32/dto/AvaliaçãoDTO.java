package br.com.unicesumar.aep32.dto;

public class    AvaliaçãoDTO {

    private String id;

    private String disciplina;

    private String dataDaAplicação;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public String getDataDaAplicação() {
        return dataDaAplicação;
    }

    public void setDataDaAplicação(String dataDaAplicação) {
        this.dataDaAplicação = dataDaAplicação;
    }
}
