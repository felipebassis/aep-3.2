package br.com.unicesumar.aep32.repository;

import br.com.unicesumar.aep32.entity.Conceito;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConceitoRepository extends JpaRepository<Conceito, String> {
}
