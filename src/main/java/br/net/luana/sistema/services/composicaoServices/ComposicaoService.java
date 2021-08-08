package br.net.luana.sistema.services.composicaoServices;

import br.net.luana.sistema.domain.composicoes.Composicao;
import br.net.luana.sistema.services.MasterService;

import java.util.List;

public interface ComposicaoService extends MasterService<Composicao, Integer> {

    List<Composicao> verificaDuplicidade(Composicao entity);
}
