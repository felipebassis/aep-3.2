package br.com.unicesumar.aep32.controller;

import br.com.unicesumar.aep32.dto.ConceitoDTO;
import br.com.unicesumar.aep32.entity.Aluno;
import br.com.unicesumar.aep32.entity.Avaliação;
import br.com.unicesumar.aep32.entity.Conceito;
import br.com.unicesumar.aep32.repository.AlunoRepository;
import br.com.unicesumar.aep32.repository.AvaliaçãoRepository;
import br.com.unicesumar.aep32.repository.ConceitoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

@RestController
@RequestMapping("/conceito")
public class ConceitoController {

    @Autowired
    private ConceitoRepository conceitoRepository;

    @Autowired
    private AvaliaçãoRepository avaliaçãoRepository;

    @Autowired
    private AlunoRepository alunoRepository;

    @PostMapping
    public String inserirConceito(@RequestBody ConceitoDTO body) {
        Aluno aluno = Objects.nonNull(body.getAluno().getId()) ?
                alunoRepository.findById(body.getAluno().getId()).orElseThrow(() -> new IllegalArgumentException("Aluno não encontrado.")) :
                new Aluno(body.getAluno().getNome());

        Avaliação avaliação = Objects.nonNull(body.getAvaliação().getId()) ?
                avaliaçãoRepository.findById(body.getAvaliação().getId()).orElseThrow(() -> new IllegalArgumentException("Avaliação não encontrado.")) :
                new Avaliação(body.getAvaliação().getDisciplina(), LocalDate.parse(body.getAvaliação().getDataDaAplicação(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));

        Conceito conceito = new Conceito(body.getNota(), avaliação, aluno);
        return conceitoRepository.save(conceito).getId();
    }

    @PutMapping("/{id}")
    public Conceito alterarConceito(@PathVariable("id") String id, @RequestBody ConceitoDTO body) {
        Conceito conceito = conceitoRepository.findById(id).
                orElseThrow(() -> new IllegalArgumentException("Conceito não encontrado."));

        conceito.getAluno().setNome(body.getAluno().getNome());
        conceito.getAvaliação().setDisciplina(body.getAvaliação().getDisciplina());
        conceito.getAvaliação().setDataAplicação(LocalDate.parse(body.getAvaliação().getDataDaAplicação(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));

        conceito.setNota(body.getNota());

        return conceitoRepository.save(conceito);
    }

    @GetMapping("/{id}")
    public Conceito encontrarUmConceito(@PathVariable("id") String id) {
        return conceitoRepository.getOne(id);
    }

    @DeleteMapping("/{id}")
    public void deletarUmConceito(@PathVariable("id") String id) {
        conceitoRepository.deleteById(id);
    }

}
