package br.edu.atitus.paradigma.cambioservice.repositorys;

import br.edu.atitus.paradigma.cambioservice.Entity.CambioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CambioRepository extends JpaRepository<CambioEntity, Long> {
    CambioEntity findByOrigemAndDestino(String origem, String destino);

}
