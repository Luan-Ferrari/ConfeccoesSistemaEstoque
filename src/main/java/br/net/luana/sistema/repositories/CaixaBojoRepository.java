package br.net.luana.sistema.repositories;

import br.net.luana.sistema.domain.CaixaBojo;
import org.springframework.stereotype.Repository;

@Repository
public interface CaixaBojoRepository extends MasterRepository<CaixaBojo, Integer> {

    CaixaBojo findByNomeCaixa(String nome);
}
