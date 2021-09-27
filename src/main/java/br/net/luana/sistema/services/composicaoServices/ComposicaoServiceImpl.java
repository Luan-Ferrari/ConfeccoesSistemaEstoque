package br.net.luana.sistema.services.composicaoServices;

import br.net.luana.sistema.domain.composicoes.Composicao;
import br.net.luana.sistema.domain.composicoes.ComposicaoFio;
import br.net.luana.sistema.domain.composicoes.Fio;
import br.net.luana.sistema.repositories.composicoes.ComposicaoFioRepository;
import br.net.luana.sistema.repositories.composicoes.ComposicaoRepository;
import br.net.luana.sistema.services.MasterServiceImpl;
import br.net.luana.sistema.services.exceptions.PorcentagemComposicaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ComposicaoServiceImpl extends MasterServiceImpl<Composicao, Integer>
        implements ComposicaoService {

    private final int porcentagemMinima = 85;
    private final int toleranciaPorcentagem = 3;

    @Autowired
    private ComposicaoRepository composicaoRepository;
    @Autowired
    private ComposicaoFioRepository composicaoFioRepository;
    @Autowired
    private FioService fioService;
    @Autowired
    private ModoLavarService modoLavarService;

    public ComposicaoServiceImpl(ComposicaoRepository composicaoRepository) {
        super(composicaoRepository);
    }

    @Override
    public Composicao save(Composicao entity) {
        if(entity.verificaTotalComposicao()) {
            entity = composicaoRepository.save(entity);

            for (ComposicaoFio cf : entity.getItensFios()) {
                cf.setFio(fioService.findById(cf.getFio().getId()));
                cf.setComposicao(entity);
                composicaoFioRepository.save(cf);
            }

            return entity;
        } else {
            throw new PorcentagemComposicaoException();
        }
    }

    public List<Composicao> verificaDuplicidade(Composicao composicaoNova) {
        if(composicaoNova.verificaTotalComposicao()) {
            List<Composicao> composicoesDuplicadas = new ArrayList<>();
            List<Composicao> composicoesExistentes = findAll();
            List<Fio> fiosComposicaoNova = new ArrayList<>(composicaoNova.getFios());

            for (Composicao composicao : composicoesExistentes) {
                List<Fio> fiosComposicaoExistente = new ArrayList<>(composicao.getFios());
                List<Boolean> listaAuxiliar = new ArrayList<>();

                if(composicao.getTipoPorcentagemMinima()) {
                    for(Fio fio : composicao.getFios())
                    if(validarPorcentagemMinima(fio, composicaoNova)) {
                        composicoesDuplicadas.add(composicao);
                    }
                }

                if (fiosComposicaoExistente.containsAll(fiosComposicaoNova) &&
                    fiosComposicaoNova.containsAll(fiosComposicaoExistente)) {

                    for (int j = 0; j < composicao.getFios().size(); j++) {

                        int posicaoFioComposicaoNova = fiosComposicaoNova.indexOf(
                                composicao.getFios().get(j));

                        listaAuxiliar.add(validarPorcentagens(
                                composicao.getPorcentagens().get(j),
                                composicaoNova.getPorcentagens().get(posicaoFioComposicaoNova)));
                    }
                    if (verificaListaAuxiliar(listaAuxiliar)) {
                        composicoesDuplicadas.add(composicao);
                    }
                }
            }
            return composicoesDuplicadas;
        } else {
            throw new PorcentagemComposicaoException();
        }
    }

    public boolean verificaListaAuxiliar(List<Boolean> listaAuxiliar) {
        for(Boolean b : listaAuxiliar) {
            if(b == false) {
                return false;
            }
        }
        return true;
    }

    public boolean validarPorcentagens(Integer porcentagemExistente, Integer porcentagemNova) {
        int limiteSuperior = porcentagemNova + toleranciaPorcentagem;
        int limiteInferior = porcentagemNova - toleranciaPorcentagem;
        if (porcentagemExistente <= limiteSuperior && porcentagemExistente >= limiteInferior) {
            return true;
        } else {
            return false;
        }
    }

    public boolean validarPorcentagemMinima(Fio fio, Composicao composicaoNova) {
        if(composicaoNova.getFios().contains(fio)) {
            int porcentagemNova = composicaoNova.getPorcentagens().get(
                    composicaoNova.getFios().indexOf(fio));
            if (porcentagemNova >= porcentagemMinima) {
                return true;
            }
        }
        return false;
    }

    @Override
    protected void updateData(Composicao updateEntity, Composicao entity) {
        updateEntity.setId(entity.getId());
        updateEntity.setNumero(entity.getNumero());
        updateEntity.setItensFios(entity.getItensFios());
    }
}
