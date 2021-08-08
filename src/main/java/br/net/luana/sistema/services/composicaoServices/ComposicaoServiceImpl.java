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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class ComposicaoServiceImpl extends MasterServiceImpl<Composicao, Integer>
        implements ComposicaoService {

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
            Set<Fio> fiosComposicaoNova = new HashSet<>(composicaoNova.getFios());

            for (int i = 0; i < composicoesExistentes.size(); i++) {
                System.out.println("Testando Composicao " + i);
                Set<Fio> fiosComposicaoExistente = new HashSet<>(composicoesExistentes.get(i).getFios());
                List<Boolean> listaAuxiliar = new ArrayList<>();
                Boolean booleanAuxiliar;

                if (fiosComposicaoExistente.equals(fiosComposicaoNova)) {
                    System.out.println("Entrou no if composicao " + i);

                    for (int j = 0; j < composicoesExistentes.get(i).getFios().size(); j++) {
                        System.out.println("Testando Fio " + j + "da composicao " + i);
                        listaAuxiliar.add(validarPorcentagens(
                                composicoesExistentes.get(i).getPorcentagens().get(j),
                                composicaoNova.getPorcentagens().get(j)));
                    }
                    if (verificaListaAuxiliar(listaAuxiliar)) {
                        composicoesDuplicadas.add(composicoesExistentes.get(i));
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
        System.out.println("Entrou no método que valida porcentagens ");
        int tolerancia = 3;
        int limiteSuperior = porcentagemNova + tolerancia;
        int limiteInferior = porcentagemNova - tolerancia;
        if (porcentagemExistente <= limiteSuperior && porcentagemExistente >= limiteInferior) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    protected void updateData(Composicao updateEntity, Composicao entity) {
        updateEntity.setId(entity.getId());
        updateEntity.setNumero(entity.getNumero());
        updateEntity.setItensFios(entity.getItensFios());
    }
}
