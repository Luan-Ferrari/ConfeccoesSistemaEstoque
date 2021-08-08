package br.net.luana.sistema.repositories;

import br.net.luana.sistema.domain.Colecao;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ColecaoRepository extends MasterRepository<Colecao, Integer> {

    List<Colecao> findByNome(String nome);

    List<Colecao> findByAno(Integer ano);

    Colecao findByAnoAndNome(Integer ano, String nome);
}
