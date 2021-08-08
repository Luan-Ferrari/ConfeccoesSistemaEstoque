package br.net.luana.sistema.services.corServices;

import br.net.luana.sistema.domain.cores.Cor;
import br.net.luana.sistema.services.MasterService;

public interface CorService<T extends Cor, ID extends Integer>
        extends MasterService<T, ID> {

    public void acrescentarQuantidadeCorEstoque(Cor cor, Double quantidade);

    public void diminuirQuantidadeCorEstoque(Cor cor, Double quantidade);

}
