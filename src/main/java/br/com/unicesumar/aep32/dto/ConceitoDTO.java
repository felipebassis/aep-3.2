package br.com.unicesumar.aep32.dto;

public class ConceitoDTO {

    private AvaliaçãoDTO avaliação;

    private AlunoDTO aluno;

    private Float nota;

    public AvaliaçãoDTO getAvaliação() {
        return avaliação;
    }

    public void setAvaliação(AvaliaçãoDTO avaliação) {
        this.avaliação = avaliação;
    }

    public AlunoDTO getAluno() {
        return aluno;
    }

    public void setAluno(AlunoDTO aluno) {
        this.aluno = aluno;
    }

    public Float getNota() {
        return nota;
    }

    public void setNota(Float nota) {
        this.nota = nota;
    }
}
