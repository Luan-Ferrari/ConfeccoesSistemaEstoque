package br.net.luana.sistema.services;

import br.net.luana.sistema.domain.*;
import br.net.luana.sistema.domain.cores.CorEntradas;
import br.net.luana.sistema.domain.cores.CorTecido;
import br.net.luana.sistema.domain.enums.FuncaoContato;
import br.net.luana.sistema.domain.enums.TipoTelefone;
import br.net.luana.sistema.domain.enums.UnidadeMedida;
import br.net.luana.sistema.domain.materiasprimas.Colchete;
import br.net.luana.sistema.domain.materiasprimas.Tecido;
import br.net.luana.sistema.domain.materiasprimas.TecidoClasse;
import br.net.luana.sistema.domain.tipos.TipoTecido;
import br.net.luana.sistema.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Arrays;

@Service
public class DBService {

    @Autowired
    private ContatoRepository contatoRepository;
    @Autowired
    private TelefoneRepository telefoneRepository;
    @Autowired
    private TipoFornecedorRepository tipoFornecedorRepository;
    @Autowired
    private FornecedorRepository fornecedorRepository;
    @Autowired
    private TecidoClasseRepository tecidoClasseRepository;
    @Autowired
    private MateriaPrimaRepository materiaPrimaRepository;
    @Autowired
    private TipoRepository tipoRepository;
    @Autowired
    private CorRepository corRepository;
    @Autowired
    private ComposicaoRepository composicaoRepository;
    @Autowired
    private CorEntradasRepository corEntradasRepository;
    @Autowired
    @Qualifier(value = "tecido")
    private TecidoRepository tecidoRepository;
    @Autowired
    @Qualifier(value = "colchete")
    private ColcheteRepository colcheteRepository;


    public void intanciateTestDatabase() throws ParseException {

        //criando contatos
        Contato cont1 = new Contato(null, "Fulano da Silva", FuncaoContato.VENDEDOR);
        Contato cont2 = new Contato(null, "Ciclano da Silva", FuncaoContato.ADMINISTRACAO);
        Contato cont3 = new Contato(null, "Beltrano da Silva", FuncaoContato.TRANSPORTE);
        Contato cont4 = new Contato(null, "Fulano da Fonseca", FuncaoContato.ESCRITORIO);
        Contato cont5 = new Contato(null, "Fulano de Moura", FuncaoContato.VENDEDOR);
        Contato cont6 = new Contato(null, "Fulano Aspargo", FuncaoContato.VENDEDOR);

        //criando telefones
        Telefone tel1 = new Telefone(null, "54", "999887766", null, TipoTelefone.CELULAR, cont1);
        Telefone tel2 = new Telefone(null, "49", "999887765", null, TipoTelefone.CELULAR_E_WHATSAPP, cont2);
        Telefone tel3 = new Telefone(null, "47", "35223522", null, TipoTelefone.FIXO,cont3);
        Telefone tel4 = new Telefone(null, "51", "999887764", null, TipoTelefone.CELULAR_E_WHATSAPP,cont4);
        Telefone tel5 = new Telefone(null, "55", "999887762", null, TipoTelefone.CELULAR,cont5);
        Telefone tel6 = new Telefone(null, "54", "89897575", "2002", TipoTelefone.FIXO,cont6);
        Telefone tel7 = new Telefone(null, "54", "999887760", null, TipoTelefone.CELULAR,cont1);

        //associando os telefones aos seus contatos
        cont1.getTelefones().addAll(Arrays.asList(tel1, tel7));
        cont2.getTelefones().addAll(Arrays.asList(tel2));
        cont3.getTelefones().addAll(Arrays.asList(tel3));
        cont4.getTelefones().addAll(Arrays.asList(tel4));
        cont5.getTelefones().addAll(Arrays.asList(tel5));
        cont6.getTelefones().addAll(Arrays.asList(tel6));

        //criando tipos de fornecedor
        TipoFornecedor tipFornec1 = new TipoFornecedor(null, "Tecido");
        TipoFornecedor tipFornec2 = new TipoFornecedor(null, "Bojo");
        TipoFornecedor tipFornec3 = new TipoFornecedor(null, "Elástico");
        TipoFornecedor tipFornec4 = new TipoFornecedor(null, "Renda");
        TipoFornecedor tipFornec5 = new TipoFornecedor(null, "Botão");

        //criando fornecedores
        Fornecedor fornec1 = new Fornecedor(null, "Ramalhete", "001112220000133", "ramalhete@email.com");
        Fornecedor fornec2 = new Fornecedor(null, "Peteca", "11222333000144", "peteca@email.com");
        Fornecedor fornec3 = new Fornecedor(null, "Down Bojos", "22333444000155", "downbojos@email.com");
        Fornecedor fornec4 = new Fornecedor(null, "Malharia da Esquina", "33444555000166", "malhariadaesquina@email.com");

        //associando fornecedores e tipos fornecedores
        fornec1.getTipoFornecedor().addAll(Arrays.asList(tipFornec1, tipFornec2, tipFornec3, tipFornec4));
        fornec2.getTipoFornecedor().addAll(Arrays.asList(tipFornec1, tipFornec3));
        fornec3.getTipoFornecedor().addAll(Arrays.asList(tipFornec2));
        fornec4.getTipoFornecedor().addAll(Arrays.asList(tipFornec1, tipFornec3, tipFornec4, tipFornec5));

        tipFornec1.getFornecedores().addAll(Arrays.asList(fornec1, fornec2, fornec3));
        tipFornec2.getFornecedores().addAll(Arrays.asList(fornec1, fornec3));
        tipFornec3.getFornecedores().addAll(Arrays.asList(fornec1, fornec2, fornec4));
        tipFornec4.getFornecedores().addAll(Arrays.asList(fornec1, fornec4));

        //associando fornecedores e contatos
        fornec1.getContatos().addAll(Arrays.asList(cont1));
        fornec2.getContatos().addAll(Arrays.asList(cont2));
        fornec3.getContatos().addAll(Arrays.asList(cont3,cont4));
        fornec4.getContatos().addAll(Arrays.asList(cont1, cont5, cont6));

        cont1.getFornecedores().addAll(Arrays.asList(fornec1, fornec4));
        cont2.getFornecedores().addAll(Arrays.asList(fornec2));
        cont3.getFornecedores().addAll(Arrays.asList(fornec3));
        cont4.getFornecedores().addAll(Arrays.asList(fornec3));
        cont5.getFornecedores().addAll(Arrays.asList(fornec4));
        cont6.getFornecedores().addAll(Arrays.asList(fornec4));

        //criando classe tecido
        TecidoClasse tecClass1 = new TecidoClasse(null, "Apeluciado");
        TecidoClasse tecClass2 = new TecidoClasse(null, "Plush");
        TecidoClasse tecClass3 = new TecidoClasse(null, "Algodão");
        TecidoClasse tecClass4 = new TecidoClasse(null, "Praia");

        //criando tipo tecido
        TipoTecido tipo1 = new TipoTecido(null, "Plush");
        TipoTecido tipo2 = new TipoTecido(null, "Soft");
        TipoTecido tipo3 = new TipoTecido(null, "Cotton");
        TipoTecido tipo4 = new TipoTecido(null, "Montaria");
        TipoTecido tipo5 = new TipoTecido(null, "Quase Plush");
        TipoTecido tipo6 = new TipoTecido(null, "Viscose");
        TipoTecido tipo7 = new TipoTecido(null, "Lycra");
        TipoTecido tipo8 = new TipoTecido(null, "Praia");

        //criando matéria-prima(tecido)
        Tecido tec1 = new Tecido(null, "ref1", null, false, UnidadeMedida.QUILOS, fornec2, tipo1, tecClass2);
        Tecido tec2 = new Tecido(null, "ref2", null, false, UnidadeMedida.QUILOS, fornec3, tipo2, tecClass2);
        Tecido tec3 = new Tecido(null, "ref3", "é feio", false, UnidadeMedida.QUILOS, fornec1, tipo3, tecClass3);
        Tecido tec4 = new Tecido(null, "ref4", null, false, UnidadeMedida.QUILOS, fornec2, tipo4, tecClass1);
        Tecido tec5 = new Tecido(null, "ref5", "é mole", false, UnidadeMedida.QUILOS, fornec4, tipo5, tecClass2);
        Tecido tec6 = new Tecido(null, "ref6", null, false, UnidadeMedida.QUILOS, fornec4, tipo6, tecClass4);
        Tecido tec7 = new Tecido(null, "ref7", null, true, UnidadeMedida.QUILOS, fornec3, tipo3, tecClass3);
        Tecido tec8 = new Tecido(null, "ref8", "é fedido", true, UnidadeMedida.QUILOS, fornec3, tipo7, tecClass4);
        Tecido tec9 = new Tecido(null, "ref9", null, false, UnidadeMedida.QUILOS, fornec2, tipo8, tecClass4);
        Tecido tec10 = new Tecido(null, "ref10", null, false, UnidadeMedida.QUILOS, fornec1, tipo1,tecClass2);
        Tecido tec11 = new Tecido(null, "ref11", null, true, UnidadeMedida.QUILOS, fornec4, tipo2, tecClass2);
        Tecido tec12 = new Tecido(null, "ref12", null, false, UnidadeMedida.QUILOS, fornec1, tipo1, tecClass2);
        Tecido tec13 = new Tecido(null, "ref13", null, false, UnidadeMedida.QUILOS, fornec1, tipo2, tecClass2);
        Tecido tec14 = new Tecido(null, "ref14", "é bonito", false, UnidadeMedida.QUILOS, fornec1, tipo3, tecClass3);
        Tecido tec15 = new Tecido(null, "ref15", null, false, UnidadeMedida.QUILOS, fornec2, tipo1, tecClass1);
        Tecido tec16 = new Tecido(null, "ref16", null, false, UnidadeMedida.QUILOS, fornec2, tipo1, tecClass1);

        Colchete colc1 = new Colchete(null, "refColc1", null, false, UnidadeMedida.UNIDADES, fornec2);
        Colchete colc2 = new Colchete(null, "refColc2", null, false, UnidadeMedida.UNIDADES, fornec3);
        Colchete colc3 = new Colchete(null, "refColc3", null, false, UnidadeMedida.UNIDADES, fornec1);

        //criando composiçoes
        Composicao comp1 = new Composicao(null);
        Composicao comp2 = new Composicao(null);
        Composicao comp3 = new Composicao(null);

        //criando cor tecido
        CorTecido corTec1 = new CorTecido(null, "ref01", "corA", null, 50.00, comp1, tec1);
        CorTecido corTec2 = new CorTecido(null, "ref02", "corB", null, 50.00, comp2, tec2);
        CorTecido corTec3 = new CorTecido(null, "ref03", "corC", null, 50.00, comp3, tec3);
        CorTecido corTec4 = new CorTecido(null, "ref04", "corD", "feia", 50.00, comp2, tec4);
        CorTecido corTec5 = new CorTecido(null, "ref05", "corE", null, 50.00, comp1, tec5);
        CorTecido corTec6 = new CorTecido(null, "ref06", "corF", null, 50.00, comp1, tec6);
        CorTecido corTec7 = new CorTecido(null, "ref07", "corG", null, 50.00, comp3, tec7);
        CorTecido corTec8 = new CorTecido(null, "ref08", "corH", "fina", 50.00, comp2, tec8);
        CorTecido corTec9 = new CorTecido(null, "ref09", "corI", null, 50.00, comp3, tec9);
        CorTecido corTec10 = new CorTecido(null, "ref010", "corJ", null, 50.00, comp3, tec10);
        CorTecido corTec11 = new CorTecido(null, "ref011", "corK", null, 50.00, comp2, tec11);
        CorTecido corTec12 = new CorTecido(null, "ref012", "corL", null, 50.00, comp2, tec12);
        CorTecido corTec13 = new CorTecido(null, "ref013", "corM", null, 50.00, comp1, tec13);
        CorTecido corTec14 = new CorTecido(null, "ref014", "corN", "tosca", 50.00, comp2, tec14);
        CorTecido corTec15 = new CorTecido(null, "ref015", "corO", null, 50.00, comp1, tec15);
        CorTecido corTec16 = new CorTecido(null, "ref016", "corP", null, 50.00, comp1, tec1);
        CorTecido corTec17 = new CorTecido(null, "ref017", "corQ", null, 50.00, comp3, tec2);
        CorTecido corTec18 = new CorTecido(null, "ref018", "corR", null, 50.00, comp1, tec3);
        CorTecido corTec19 = new CorTecido(null, "ref019", "corS", "amarelada", 50.00, comp2, tec4);
        CorTecido corTec20 = new CorTecido(null, "ref020", "corT", null, 50.00, comp1, tec5);
        CorTecido corTec21 = new CorTecido(null, "ref021", "corU", null, 50.00, comp3, tec6);
        CorTecido corTec22 = new CorTecido(null, "ref022", "corV", null, 50.00, comp1, tec7);
        CorTecido corTec23 = new CorTecido(null, "ref023", "corX", null, 50.00, comp1, tec8);
        CorTecido corTec24 = new CorTecido(null, "ref024", "corY", "desbota", 50.00, comp2, tec9);
        CorTecido corTec25 = new CorTecido(null, "ref025", "corW", null, 50.00, comp1, tec10);
        CorTecido corTec26 = new CorTecido(null, "ref026", "corZ", null, 50.00, comp1, tec11);
        CorTecido corTec27 = new CorTecido(null, "ref027", "corAB", null, 50.00, comp1, tec12);
        CorTecido corTec28 = new CorTecido(null, "ref028", "corAC", null, 50.00, comp2, tec13);
        CorTecido corTec29 = new CorTecido(null, "ref029", "corAD", null, 50.00, comp1, tec14);
        CorTecido corTec30 = new CorTecido(null, "ref030", "corAE", null, 50.00, comp3, tec15);

        //instanciado cor entrada
        CorEntradas corEnt1 = new CorEntradas(null, "15/08/2020", 50.00, 20.00, corTec1);
        CorEntradas corEnt2 = new CorEntradas(null, "15/05/2019", 60.00, 30.00, corTec1);
        CorEntradas corEnt3 = new CorEntradas(null, "15/03/2018", 70.00, 40.00, corTec2);
        CorEntradas corEnt4 = new CorEntradas(null, "15/02/2020", 80.00, 50.00, corTec3);
        CorEntradas corEnt5 = new CorEntradas(null, "15/01/2020", 90.00, 60.00, corTec4);
        CorEntradas corEnt6 = new CorEntradas(null, "15/02/2019", 100.00, 70.00, corTec4);
        CorEntradas corEnt7 = new CorEntradas(null, "15/03/2020", 40.00, 80.00, corTec1);
        CorEntradas corEnt8 = new CorEntradas(null, "15/04/2018", 30.00, 90.00, corTec5);
        CorEntradas corEnt9 = new CorEntradas(null, "15/05/2017", 20.00, 100.00, corTec6);
        CorEntradas corEnt10 = new CorEntradas(null, "15/06/2016", 15.00, 90.00, corTec7);
        CorEntradas corEnt11 = new CorEntradas(null, "15/07/2020", 18.00, 80.00, corTec8);
        CorEntradas corEnt12 = new CorEntradas(null, "15/03/2021", 10.00, 70.00, corTec8);
        CorEntradas corEnt13 = new CorEntradas(null, "15/02/2021", 5.00, 60.00, corTec5);

        //associando fornecedor a materia prima
        fornec1.getMateriasPrimas().addAll(Arrays.asList(tec3, tec10, tec12, tec13, tec14));
        fornec2.getMateriasPrimas().addAll(Arrays.asList(tec1, tec4, tec9, tec15, tec16));
        fornec3.getMateriasPrimas().addAll(Arrays.asList(tec2, tec7, tec8));
        fornec4.getMateriasPrimas().addAll(Arrays.asList(tec5, tec6, tec11));

        //associando os tecidos aos seus tipos
        tipo1.getTecidos().addAll(Arrays.asList(tec1, tec10, tec12, tec15, tec16));
        tipo2.getTecidos().addAll(Arrays.asList(tec2, tec11, tec13));
        tipo3.getTecidos().addAll(Arrays.asList(tec3, tec7, tec14));
        tipo4.getTecidos().addAll(Arrays.asList(tec4));
        tipo5.getTecidos().addAll(Arrays.asList(tec5));
        tipo6.getTecidos().addAll(Arrays.asList(tec6));
        tipo7.getTecidos().addAll(Arrays.asList(tec7));
        tipo8.getTecidos().addAll(Arrays.asList(tec8));

        //associando os tecidos as suas classes
        tecClass1.getTecidos().addAll(Arrays.asList(tec1, tec2, tec5, tec10, tec11, tec12, tec13, tec16));
        tecClass2.getTecidos().addAll(Arrays.asList(tec4, tec15));
        tecClass3.getTecidos().addAll(Arrays.asList(tec3, tec7, tec14));
        tecClass4.getTecidos().addAll(Arrays.asList(tec6, tec8, tec9));

        //associando os tecidos a suas cores
        tec1.getCores().addAll(Arrays.asList(corTec1, corTec16));
        tec2.getCores().addAll(Arrays.asList(corTec2, corTec17));
        tec3.getCores().addAll(Arrays.asList(corTec3, corTec18));
        tec4.getCores().addAll(Arrays.asList(corTec4, corTec19));
        tec5.getCores().addAll(Arrays.asList(corTec5, corTec20));
        tec6.getCores().addAll(Arrays.asList(corTec6, corTec21));
        tec7.getCores().addAll(Arrays.asList(corTec7, corTec22));
        tec8.getCores().addAll(Arrays.asList(corTec8, corTec23));
        tec9.getCores().addAll(Arrays.asList(corTec9, corTec24));
        tec10.getCores().addAll(Arrays.asList(corTec10, corTec25));
        tec11.getCores().addAll(Arrays.asList(corTec11, corTec26));
        tec12.getCores().addAll(Arrays.asList(corTec12, corTec27));
        tec13.getCores().addAll(Arrays.asList(corTec13, corTec28));
        tec14.getCores().addAll(Arrays.asList(corTec14, corTec29));
        tec15.getCores().addAll(Arrays.asList(corTec15, corTec30));

        //associando as cores de tecido as suas entradas
        corTec1.getEntradas().addAll(Arrays.asList(corEnt1, corEnt2, corEnt7));
        corTec2.getEntradas().addAll(Arrays.asList(corEnt3));
        corTec3.getEntradas().addAll(Arrays.asList(corEnt4));
        corTec4.getEntradas().addAll(Arrays.asList(corEnt5, corEnt6));
        corTec5.getEntradas().addAll(Arrays.asList(corEnt8, corEnt13));
        corTec6.getEntradas().addAll(Arrays.asList(corEnt9));
        corTec7.getEntradas().addAll(Arrays.asList(corEnt10));
        corTec8.getEntradas().addAll(Arrays.asList(corEnt11, corEnt12));

        //persistindo dados de Contato
        contatoRepository.saveAll(Arrays.asList(cont1, cont2, cont3, cont4, cont5, cont6));
        //persistindo dados de Telefone
        telefoneRepository.saveAll(Arrays.asList(tel1, tel2, tel3, tel4, tel5, tel6, tel7));

        //persistindo dados de tipoFornecedor
        tipoFornecedorRepository.saveAll(Arrays.asList(tipFornec1,tipFornec2, tipFornec3, tipFornec4, tipFornec5));
        //persistindo dados de fornecedor
        fornecedorRepository.saveAll(Arrays.asList(fornec1, fornec2, fornec3, fornec4));

        //persistindo classe de tecido
        tecidoClasseRepository.saveAll(Arrays.asList(tecClass1, tecClass2, tecClass3, tecClass4));
        //persistindo tipo tecido
        tipoRepository.saveAll(Arrays.asList(tipo1, tipo2, tipo3, tipo4, tipo5, tipo6, tipo7, tipo8));

        //persistindo composicao
        composicaoRepository.saveAll(Arrays.asList(comp1, comp2, comp3));

        //persistindo materias primas (Tecidos)
        tecidoRepository.saveAll(Arrays.asList(tec1, tec2, tec3, tec4, tec5, tec6, tec7, tec8,
                tec9, tec10, tec11, tec12, tec13, tec14, tec15, tec16));

        colcheteRepository.saveAll(Arrays.asList(colc1, colc2, colc3));

        //persistindo cores
        corRepository.saveAll(Arrays.asList(corTec1, corTec2, corTec3, corTec4, corTec5, corTec6,
                corTec7, corTec8, corTec9, corTec10, corTec11, corTec12, corTec13, corTec14,
                corTec15, corTec16, corTec17, corTec18, corTec19, corTec20, corTec21, corTec22,
                corTec23, corTec24, corTec25, corTec26, corTec27, corTec28, corTec29, corTec30));

        corEntradasRepository.saveAll(Arrays.asList(corEnt1, corEnt2, corEnt3, corEnt4, corEnt5,
                corEnt6, corEnt7, corEnt8, corEnt9, corEnt10, corEnt11, corEnt12, corEnt13));









    }
}
