package br.net.luana.sistema.services;

import br.net.luana.sistema.domain.CartaoKanBan;
import br.net.luana.sistema.domain.CartaoKanBanHistorico;
import br.net.luana.sistema.domain.CorEntradas;
import br.net.luana.sistema.domain.cores.Cor;
import br.net.luana.sistema.domain.enums.MotivoBaixaKanBan;
import br.net.luana.sistema.repositories.CartaoKanBanHistoricoRepository;
import br.net.luana.sistema.repositories.CartaoKanBanRepository;
import br.net.luana.sistema.services.corServices.CorService;
import br.net.luana.sistema.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
@Transactional
public class CartaoKanBanServiceImpl extends MasterServiceImpl<CartaoKanBan, Integer>
        implements CartaoKanBanService {

    @Autowired
    private CartaoKanBanRepository cartaoKanBanRepository;
    @Autowired
    private CartaoKanBanHistoricoRepository cartaoKanBanHistoricoRepository;
    @Autowired
    private CorService<Cor, Integer> corService;

    public CartaoKanBanServiceImpl(CartaoKanBanRepository cartaoKanBanRepository) {
        super(cartaoKanBanRepository);
    }

    @Override
    public CartaoKanBan save(CartaoKanBan entity) {
        return cartaoKanBanRepository.save(entity);
    }

    @Override
    protected void updateData(CartaoKanBan updateEntity, CartaoKanBan entity) {
        updateEntity.setEmUso(false);
    }

    public CartaoKanBan findByCodigoCartao (int codigo) {
        Optional<CartaoKanBan> obj = cartaoKanBanRepository.findByCodigoCartao(codigo);
        return obj.orElseThrow(
                () -> new ObjectNotFoundException(codigo));
    }

    public List<CartaoKanBan> criarCartoesKanBan (Cor cor, CorEntradas corEntrada) {

        List<CartaoKanBan> cartoes = new ArrayList<>();

        double sobras = corEntrada.getQuantidade() % cor.getQuantidadeKanBan();
        int quantidadeCartoes = (int)(corEntrada.getQuantidade() / cor.getQuantidadeKanBan());

        if(sobras != 0) {
            quantidadeCartoes += 1;
        }

        for(CartaoKanBan cartao : pegarCartoesVazios(quantidadeCartoes)) {
            cartoes.add(setarDadosNoCartao(cartao, cor, corEntrada));
        }

        while(quantidadeCartoes > cartoes.size()) {
            CartaoKanBan cartao = new CartaoKanBan();
            cartao.setCodigoCartao(criarCodigoCartao());
            cartoes.add(setarDadosNoCartao(cartao, cor, corEntrada));
        }

        if(sobras != 0) {
            BigDecimal sobraArredondada = new BigDecimal(sobras)
                    .setScale(2, RoundingMode.HALF_EVEN);
            cartoes.get((cartoes.size())-1)
                    .setQuantidadeArmazenada(sobraArredondada.doubleValue());
        }

        cartaoKanBanRepository.saveAll(cartoes);

        return cartoes;
    }

    public void baixarCartao(CartaoKanBan cartao, MotivoBaixaKanBan motivoBaixa) {
        if(cartao.getEmUso() == true) {
            cartao.setEmUso(false);
            criarCartaoKanBanHistorico(cartao, motivoBaixa);
            save(cartao);
        }
    }


    public List<String> baixarCarteosEmLote(List<Integer> lista, MotivoBaixaKanBan motivoBaixa) {
        List<String> retornos = new ArrayList<>();
        for(Integer codigo : lista) {
            try {
                CartaoKanBan cartao = findByCodigoCartao(codigo);
                if(cartao.getEmUso() == false) {
                    String retorno = "Cartão já baixado";
                    retornos.add(retorno);
                } else {
                    cartao.setEmUso(false);
                    corService.diminuirQuantidadeCorEstoque(
                            cartao.getCorEntradas().getCor(),
                            cartao.getQuantidadeArmazenada());
                    criarCartaoKanBanHistorico(cartao, motivoBaixa);
                    String retorno = "Cartão baixado com sucesso";
                    retornos.add(retorno);
                }
            } catch (ObjectNotFoundException e) {
                String retorno = "Código cartão não encontrado";
                retornos.add(retorno);
            }
        }
        return retornos;
    }

    private void criarCartaoKanBanHistorico(CartaoKanBan cartao, MotivoBaixaKanBan motivoBaixa) {
        CartaoKanBanHistorico cartaoHistorico = new CartaoKanBanHistorico();

        cartaoHistorico.setCodigoCartao(cartao.getCodigoCartao());
        cartaoHistorico.setQuantidadeArmazenada(cartao.getQuantidadeArmazenada());
        cartaoHistorico.setUnidadeMedida(cartao.getUnidadeMedida());
        cartaoHistorico.setDataBaixa(LocalDate.now());
        cartaoHistorico.setMotivoBaixa(motivoBaixa);
        cartaoHistorico.setCorEntradas(cartao.getCorEntradas());

        cartaoKanBanHistoricoRepository.save(cartaoHistorico);
    }

    private int criarCodigoCartao () {
        Random gerador = new Random();
        int codigo;
        do {
            codigo = gerador.nextInt(1000000);
        }
        while (verificarDuplicidade(codigo));

        return codigo;
    }

    private boolean verificarDuplicidade (int codigo) {
        return cartaoKanBanRepository.findByCodigoCartao(codigo).isPresent();
    }

    private List<CartaoKanBan> pegarCartoesVazios (int quantidadeCartoesAPegar) {
        List<CartaoKanBan> listaCartoesVazios = cartaoKanBanRepository.findByEmUso(false);

        if(quantidadeCartoesAPegar >= listaCartoesVazios.size()) {
            return listaCartoesVazios;
        } else {
            return listaCartoesVazios.subList(0, quantidadeCartoesAPegar);
        }
    }

    private CartaoKanBan setarDadosNoCartao (CartaoKanBan cartao, Cor cor, CorEntradas corEntrada) {
        cartao.setCorEntradas(corEntrada);
        cartao.setEmUso(true);
        cartao.setQuantidadeArmazenada(cor.getQuantidadeKanBan());
        cartao.setUnidadeMedida(cor.getUnidadeMedida());

        return cartao;
    }



}
