package br.com.unicesumar.aep32.repository;

import br.com.unicesumar.aep32.entity.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, String> {
}
