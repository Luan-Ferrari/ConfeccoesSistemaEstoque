package br.net.luana.sistema.repositories;

import br.net.luana.sistema.domain.Telefone;
import org.springframework.stereotype.Repository;

@Repository
public interface TelefoneRepository extends MasterRepository<Telefone, Integer> {
}
