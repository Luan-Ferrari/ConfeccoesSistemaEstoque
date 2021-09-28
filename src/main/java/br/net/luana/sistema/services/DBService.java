package br.net.luana.sistema.services;

import br.net.luana.sistema.domain.*;
import br.net.luana.sistema.domain.composicoes.Composicao;
import br.net.luana.sistema.domain.composicoes.ComposicaoFio;
import br.net.luana.sistema.domain.composicoes.Fio;
import br.net.luana.sistema.domain.composicoes.ModoLavar;
import br.net.luana.sistema.domain.cores.*;
import br.net.luana.sistema.domain.enums.*;
import br.net.luana.sistema.domain.materiasprimas.*;
import br.net.luana.sistema.domain.tipos.*;
import br.net.luana.sistema.domain.usuarios.Usuario;
import br.net.luana.sistema.repositories.*;
import br.net.luana.sistema.repositories.composicoes.ComposicaoFioRepository;
import br.net.luana.sistema.repositories.composicoes.ComposicaoRepository;
import br.net.luana.sistema.repositories.composicoes.FioRepository;
import br.net.luana.sistema.repositories.composicoes.ModoLavarRepository;
import br.net.luana.sistema.repositories.corRepositories.*;
import br.net.luana.sistema.repositories.materiaPrimaRepositories.*;
import br.net.luana.sistema.repositories.tipoRepositories.*;
import br.net.luana.sistema.repositories.usuarios.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;

@Transactional
@Service
public class DBService {

    @Autowired
    private ContatoRepository contatoRepository;
    @Autowired
    private TelefoneRepository telefoneRepository;
    @Autowired
    private FornecedorRepository fornecedorRepository;
    @Autowired
    private TecidoClasseRepository tecidoClasseRepository;
    @Autowired
    private CorTecidoRepository corTecidoRepository;
    @Autowired
    private CorColcheteRepository corColcheteRepository;
    @Autowired
    private ComposicaoRepository composicaoRepository;
    @Autowired
    private FioRepository fioRepository;
    @Autowired
    private ComposicaoFioRepository composicaoFioRepository;
    @Autowired
    private ModoLavarRepository modoLavarRepository;
    @Autowired
    private CorEntradasRepository corEntradasRepository;
    @Autowired
    private TipoTecidoRepository tipoTecidoRepository;
    @Autowired
    private TipoColcheteRepository tipoColcheteRepository;
    @Autowired
    private TecidoRepository tecidoRepository;
    @Autowired
    private ColcheteRepository colcheteRepository;
    @Autowired
    private BojoRepository bojoRepository;
    @Autowired
    private CorBojoRepository corBojoRepository;
    @Autowired
    private TipoBojoRepository tipoBojoRepository;
    @Autowired
    private CaixaBojoRepository caixaBojoRepository;
    @Autowired
    private AlcaRepository alcaRepository;
    @Autowired
    private RendaRepository rendaRepository;
    @Autowired
    private ElasticoRepository elasticoRepository;
    @Autowired
    private LinhaRepository linhaRepository;
    @Autowired
    private CorAlcaRepository corAlcaRepository;
    @Autowired
    private CorRendaRepository corRendaRepository;
    @Autowired
    private CorElasticoRepository corElasticoRepository;
    @Autowired
    private CorLinhaRepository corLinhaRepository;
    @Autowired
    private TipoAlcaRepository tipoAlcaRepository;
    @Autowired
    private TipoRendaRepository tipoRendaRepository;
    @Autowired
    private TipoElasticoRepository tipoElasticoRepository;
    @Autowired
    private TipoLinhaRepository tipoLinhaRepository;
    @Autowired
    private CidadeRepository cidadeRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();


    public void intanciateTestDatabase() throws ParseException {

        //criando o administrador
        Usuario admin = new Usuario(null, "Luan", passwordEncoder.encode("teste"));
        admin.addPerfil(PerfilUsuario.ADMIN);

        //criando contatos
        Contato cont1 = new Contato(null, "Fulano da Silva", "Vendedor", "fulano@gmail.com");
        Contato cont2 = new Contato(null, "Ciclano da Silva", "Vendedor", "ciclano@gmail.com");
        Contato cont3 = new Contato(null, "Beltrano da Silva", "Contador", "beltrano@gmail.com");
        Contato cont4 = new Contato(null, "Fulano da Fonseca", "Motorista", "fulano@hotmail.com");
        Contato cont5 = new Contato(null, "Fulano de Moura", "Entregador", "fulano@yahoo.com");
        Contato cont6 = new Contato(null, "Fulano Aspargo", "Aspargo", "aspargo@gmail.com");


        //criando cidades
        Cidade cidade1 = new Cidade(null, "Erechim", Estado.RS);
        Cidade cidade2 = new Cidade(null, "Blumenau", Estado.SC);

        //criando fornecedores
        Fornecedor fornec1 = new Fornecedor(null, "Ramalhete", "001112220000133", "ramalhete@email.com", "Aviamentos", cidade2);
        Fornecedor fornec2 = new Fornecedor(null, "Peteca", "11222333000144", "peteca@email.com", "Malhas", cidade2);
        Fornecedor fornec3 = new Fornecedor(null, "Down Bojos", "22333444000155", "downbojos@email.com", "Bojos", cidade2);
        Fornecedor fornec4 = new Fornecedor(null, "Malharia da Esquina", "33444555000166", "malhariadaesquina@email.com", "Malhas", cidade1);

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

        //criando telefones
        Telefone tel1 = new Telefone(null, "54", "999887766", null, cont1, null);
        Telefone tel2 = new Telefone(null, "49", "999887765", null, cont2, null);
        Telefone tel3 = new Telefone(null, "47", "35223522", null, null, fornec1);
        Telefone tel4 = new Telefone(null, "51", "999887764", null, null, fornec2);
        Telefone tel5 = new Telefone(null, "55", "999887762", null, null, fornec2);
        Telefone tel6 = new Telefone(null, "54", "89897575", "2002", null, fornec2);
        Telefone tel7 = new Telefone(null, "54", "999887760", null, cont1, null);

        //associando os telefones aos seus contatos
        cont1.getTelefones().addAll(Arrays.asList(tel1, tel7));
        cont2.getTelefones().addAll(Arrays.asList(tel2));

        //associando os telefones aos seus fornecedores
        fornec1.getTelefones().addAll(Arrays.asList(tel3));
        fornec2.getTelefones().addAll(Arrays.asList(tel4, tel5, tel6));



        //criando composiçoes
        Composicao comp1 = new Composicao(null, 10, false);
        Composicao comp2 = new Composicao(null, 20, false);
        Composicao comp3 = new Composicao(null,30, false);

        //criando fios
        Fio fio1 = new Fio(null, "Algodao");
        Fio fio2 = new Fio(null, "Poliester");
        Fio fio3 = new Fio(null, "Poliamida");
        Fio fio4 = new Fio(null, "Elastano");
        Fio fio5 = new Fio(null, "Viscose");

        //criando composicao_fio
        ComposicaoFio composicaoFio1 = new ComposicaoFio(comp1, fio1, 100);
        ComposicaoFio composicaoFio2 = new ComposicaoFio(comp2, fio2, 50);
        ComposicaoFio composicaoFio3 = new ComposicaoFio(comp2, fio3, 50);
        ComposicaoFio composicaoFio4 = new ComposicaoFio(comp3, fio1, 50);
        ComposicaoFio composicaoFio5 = new ComposicaoFio(comp3, fio4, 25);
        ComposicaoFio composicaoFio6 = new ComposicaoFio(comp3, fio5, 25);

        //associando composicao e fio a composicao_fio
        comp1.getItensFios().addAll(Arrays.asList(composicaoFio1));
        comp2.getItensFios().addAll(Arrays.asList(composicaoFio2, composicaoFio3));
        comp3.getItensFios().addAll(Arrays.asList(composicaoFio4, composicaoFio5, composicaoFio6));

        fio1.getItensFios().addAll(Arrays.asList(composicaoFio1, composicaoFio4));
        fio2.getItensFios().addAll(Arrays.asList(composicaoFio2));
        fio3.getItensFios().addAll(Arrays.asList(composicaoFio3));
        fio4.getItensFios().addAll(Arrays.asList(composicaoFio5));
        fio5.getItensFios().addAll(Arrays.asList(composicaoFio6));

        //criando modo_lavar
        ModoLavar modoLavar1 = new ModoLavar(null, CategoriaModoLavar.LAVAGEM, "Lavar a mão");
        ModoLavar modoLavar2 = new ModoLavar(null, CategoriaModoLavar.ALVEJAMENTO, "Não alvejar");
        ModoLavar modoLavar3 = new ModoLavar(null, CategoriaModoLavar.SECAGEM_NATURAL, "Secar pendurado");
        ModoLavar modoLavar4 = new ModoLavar(null, CategoriaModoLavar.PASSADORIA, "Não Passar");
        ModoLavar modoLavar5 = new ModoLavar(null, CategoriaModoLavar.LIMPEZA_SECO_PROFISSIONAL, "Não lavar a seco");

        //associando composicao e modo_lavar
        comp1.getItensModoLavar().addAll(Arrays.asList(modoLavar1, modoLavar2, modoLavar3, modoLavar4, modoLavar5));
        comp2.getItensModoLavar().addAll(Arrays.asList(modoLavar1, modoLavar2, modoLavar3, modoLavar4, modoLavar5));

        //criando classe tecido
        TecidoClasse tecClass1 = new TecidoClasse(null, "Apeluciado");
        TecidoClasse tecClass2 = new TecidoClasse(null, "Plush");
        TecidoClasse tecClass3 = new TecidoClasse(null, "Algodão");
        TecidoClasse tecClass4 = new TecidoClasse(null, "Praia");

        //criando tipos
        TipoTecido tipo1 = new TipoTecido(null, "Plush");
        TipoTecido tipo2 = new TipoTecido(null, "Soft");
        TipoTecido tipo3 = new TipoTecido(null, "Cotton");
        TipoTecido tipo4 = new TipoTecido(null, "Montaria");
        TipoTecido tipo5 = new TipoTecido(null, "Quase Plush");
        TipoTecido tipo6 = new TipoTecido(null, "Viscose");
        TipoTecido tipo7 = new TipoTecido(null, "Lycra");
        TipoTecido tipo8 = new TipoTecido(null, "Praia");

        TipoColchete tipColc1 = new TipoColchete(null, "Largo");
        TipoColchete tipColc2 = new TipoColchete(null, "Fino");
        TipoColchete tipColc3 = new TipoColchete(null, "Plástico");

        TipoBojo tipBoj1 = new TipoBojo(null, "Bolha", Tamanho.P, comp1);
        TipoBojo tipBoj2 = new TipoBojo(null, "Bolha", Tamanho.M, comp1);
        TipoBojo tipBoj3 = new TipoBojo(null, "Bolha", Tamanho.G, comp1);
        TipoBojo tipBoj4 = new TipoBojo(null, "Bolha", Tamanho.GG, comp1);
        TipoBojo tipBoj5 = new TipoBojo(null, "Liso", Tamanho.PP, comp2);
        TipoBojo tipBoj6 = new TipoBojo(null, "Liso", Tamanho.P, comp2);
        TipoBojo tipBoj7 = new TipoBojo(null, "Liso", Tamanho.M, comp2);
        TipoBojo tipBoj8 = new TipoBojo(null, "Liso", Tamanho.G, comp2);
        TipoBojo tipBoj9 = new TipoBojo(null, "Liso", Tamanho.GG, comp2);
        TipoBojo tipBoj10 = new TipoBojo(null, "Massageador", Tamanho.P, comp1);
        TipoBojo tipBoj11 = new TipoBojo(null, "Massageador", Tamanho.M, comp1);
        TipoBojo tipBoj12 = new TipoBojo(null, "Massageador", Tamanho.G, comp1);
        TipoBojo tipBoj13 = new TipoBojo(null, "Massageador", Tamanho.GG, comp1);
        TipoBojo tipBoj14 = new TipoBojo(null, "Reto", Tamanho.PP, comp1);
        TipoBojo tipBoj15 = new TipoBojo(null, "Reto", Tamanho.P, comp1);
        TipoBojo tipBoj16 = new TipoBojo(null, "Reto", Tamanho.M, comp1);
        TipoBojo tipBoj17 = new TipoBojo(null, "Reto", Tamanho.G, comp1);
        TipoBojo tipBoj18 = new TipoBojo(null, "Reto", Tamanho.GG, comp1);

        TipoAlca tipoAlca1 = new TipoAlca(null, "Larga");
        TipoAlca tipoAlca2 = new TipoAlca(null, "Fina");

        TipoRenda tipoRenda1 = new TipoRenda(null, "Furada", comp1);
        TipoRenda tipoRenda2 = new TipoRenda(null, "Não Furada", comp2);

        TipoElastico tipoElastico1 = new TipoElastico(null, "Forte");
        TipoElastico tipoElastico2 = new TipoElastico(null, "Fraco");

        TipoLinha tipoLinha1 = new TipoLinha(null, "Overlock");
        TipoLinha tipoLinha2 = new TipoLinha(null, "Reta");


        //criando matéria-prima(tecido)
        Tecido tec1 = new Tecido(null, "ref1", null, false, UnidadeMedida.QUILOS, 0.5, fornec2, tipo1, tecClass2);
        Tecido tec2 = new Tecido(null, "ref2", null, false, UnidadeMedida.QUILOS, 0.5, fornec3, tipo2, tecClass2);
        Tecido tec3 = new Tecido(null, "ref3", "é feio", false, UnidadeMedida.QUILOS, 0.5, fornec1, tipo3, tecClass3);
        Tecido tec4 = new Tecido(null, "ref4", null, false, UnidadeMedida.QUILOS, 0.5, fornec2, tipo4, tecClass1);
        Tecido tec5 = new Tecido(null, "ref5", "é mole", false, UnidadeMedida.QUILOS, 0.5, fornec4, tipo5, tecClass2);
        Tecido tec6 = new Tecido(null, "ref6", null, false, UnidadeMedida.QUILOS, 0.5, fornec4, tipo6, tecClass4);
        Tecido tec7 = new Tecido(null, "ref7", null, true, UnidadeMedida.QUILOS, 0.5, fornec3, tipo3, tecClass3);
        Tecido tec8 = new Tecido(null, "ref8", "é fedido", true, UnidadeMedida.QUILOS, 0.5, fornec3, tipo7, tecClass4);
        Tecido tec9 = new Tecido(null, "ref9", null, false, UnidadeMedida.QUILOS, 0.5, fornec2, tipo8, tecClass4);
        Tecido tec10 = new Tecido(null, "ref10", null, false, UnidadeMedida.QUILOS, 0.5, fornec1, tipo1,tecClass2);
        Tecido tec11 = new Tecido(null, "ref11", null, true, UnidadeMedida.QUILOS, 0.5, fornec4, tipo2, tecClass2);
        Tecido tec12 = new Tecido(null, "ref12", null, false, UnidadeMedida.QUILOS, 0.5, fornec1, tipo1, tecClass2);
        Tecido tec13 = new Tecido(null, "ref13", null, false, UnidadeMedida.QUILOS, 0.5, fornec1, tipo2, tecClass2);
        Tecido tec14 = new Tecido(null, "ref14", "é bonito", false, UnidadeMedida.QUILOS, 0.5, fornec1, tipo3, tecClass3);
        Tecido tec15 = new Tecido(null, "ref15", null, false, UnidadeMedida.QUILOS, 0.5, fornec2, tipo1, tecClass1);
        Tecido tec16 = new Tecido(null, "ref16", null, false, UnidadeMedida.QUILOS, 0.5, fornec2, tipo1, tecClass1);

        Colchete colc1 = new Colchete(null, "refColc1", null, false, UnidadeMedida.UNIDADES, 2.0, fornec2, tipColc1);
        Colchete colc2 = new Colchete(null, "refColc2", null, false, UnidadeMedida.UNIDADES, 2.0,  fornec3, tipColc2);
        Colchete colc3 = new Colchete(null, "refColc3", null, false, UnidadeMedida.UNIDADES, 2.0,  fornec1, tipColc2);

        Bojo boj1 = new Bojo(null, "refB1", null, false, UnidadeMedida.PARES, 1.0, fornec1, tipBoj1);
        Bojo boj2 = new Bojo(null, "refB2", null, false, UnidadeMedida.PARES, 1.0,  fornec2, tipBoj1);
        Bojo boj3 = new Bojo(null, "refB3", null, false, UnidadeMedida.PARES, 1.0,  fornec3, tipBoj1);
        Bojo boj4 = new Bojo(null, "refB4", null, false, UnidadeMedida.PARES, 1.0,  fornec1, tipBoj2);
        Bojo boj5 = new Bojo(null, "refB5", null, false, UnidadeMedida.PARES, 1.0,  fornec2, tipBoj2);
        Bojo boj6 = new Bojo(null, "refB6", null, false, UnidadeMedida.PARES, 1.0,  fornec3, tipBoj2);
        Bojo boj7 = new Bojo(null, "refB7", null, false, UnidadeMedida.PARES, 1.0,  fornec1, tipBoj3);
        Bojo boj8 = new Bojo(null, "refB8", null, false, UnidadeMedida.PARES, 1.0,  fornec2, tipBoj3);
        Bojo boj9 = new Bojo(null, "refB9", null, false, UnidadeMedida.PARES, 1.0,  fornec3, tipBoj3);
        Bojo boj10 = new Bojo(null, "refB10", null, false, UnidadeMedida.PARES, 1.0,  fornec1, tipBoj4);
        Bojo boj11 = new Bojo(null, "refB11", null, false, UnidadeMedida.PARES, 1.0,  fornec2, tipBoj4);
        Bojo boj12 = new Bojo(null, "refB12", null, false, UnidadeMedida.PARES, 1.0, fornec3, tipBoj4);
        Bojo boj13 = new Bojo(null, "refB13", null, false, UnidadeMedida.PARES, 1.0,  fornec1, tipBoj5);
        Bojo boj14 = new Bojo(null, "refB14", null, false, UnidadeMedida.PARES, 1.0,  fornec2, tipBoj5);
        Bojo boj15 = new Bojo(null, "refB15", null, false, UnidadeMedida.PARES, 1.0,  fornec3, tipBoj5);
        Bojo boj16 = new Bojo(null, "refB16", null, false, UnidadeMedida.PARES, 1.0,  fornec1, tipBoj6);
        Bojo boj17 = new Bojo(null, "refB17", null, false, UnidadeMedida.PARES, 1.0,  fornec2, tipBoj6);
        Bojo boj18 = new Bojo(null, "refB18", null, false, UnidadeMedida.PARES, 1.0,  fornec3, tipBoj6);
        Bojo boj19 = new Bojo(null, "refB19", null, false, UnidadeMedida.PARES, 1.0,  fornec1, tipBoj7);
        Bojo boj20 = new Bojo(null, "refB20", null, false, UnidadeMedida.PARES, 1.0,  fornec2, tipBoj7);
        Bojo boj21 = new Bojo(null, "refB21", null, false, UnidadeMedida.PARES, 1.0,  fornec3, tipBoj7);
        Bojo boj22 = new Bojo(null, "refB22", null, false, UnidadeMedida.PARES, 1.0,  fornec1, tipBoj8);
        Bojo boj23 = new Bojo(null, "refB23", null, false, UnidadeMedida.PARES, 1.0,  fornec2, tipBoj8);
        Bojo boj24 = new Bojo(null, "refB24", null, false, UnidadeMedida.PARES, 1.0,  fornec3, tipBoj8);
        Bojo boj25 = new Bojo(null, "refB25", null, false, UnidadeMedida.PARES, 1.0,  fornec1, tipBoj9);
        Bojo boj26 = new Bojo(null, "refB26", null, false, UnidadeMedida.PARES, 1.0,  fornec2, tipBoj9);
        Bojo boj27 = new Bojo(null, "refB27", null, false, UnidadeMedida.PARES, 1.0,  fornec3, tipBoj9);
        Bojo boj28 = new Bojo(null, "refB28", null, false, UnidadeMedida.PARES, 1.0,  fornec1, tipBoj10);
        Bojo boj29 = new Bojo(null, "refB29", null, false, UnidadeMedida.PARES, 1.0,  fornec2, tipBoj10);
        Bojo boj30 = new Bojo(null, "refB30", null, false, UnidadeMedida.PARES, 1.0,  fornec3, tipBoj10);
        Bojo boj31 = new Bojo(null, "refB31", null, false, UnidadeMedida.PARES, 1.0,  fornec1, tipBoj11);
        Bojo boj32 = new Bojo(null, "refB32", null, false, UnidadeMedida.PARES, 1.0,  fornec2, tipBoj11);
        Bojo boj33 = new Bojo(null, "refB33", null, false, UnidadeMedida.PARES, 1.0,  fornec3, tipBoj11);
        Bojo boj34 = new Bojo(null, "refB34", null, false, UnidadeMedida.PARES, 1.0,  fornec1, tipBoj12);
        Bojo boj35 = new Bojo(null, "refB35", null, false, UnidadeMedida.PARES, 1.0,  fornec2, tipBoj12);
        Bojo boj36 = new Bojo(null, "refB36", null, false, UnidadeMedida.PARES, 1.0,  fornec3, tipBoj12);
        Bojo boj37 = new Bojo(null, "refB37", null, false, UnidadeMedida.PARES, 1.0,  fornec1, tipBoj13);
        Bojo boj38 = new Bojo(null, "refB38", null, false, UnidadeMedida.PARES, 1.0,  fornec2, tipBoj13);
        Bojo boj39 = new Bojo(null, "refB39", null, false, UnidadeMedida.PARES, 1.0,  fornec3, tipBoj13);
        Bojo boj40 = new Bojo(null, "refB40", null, false, UnidadeMedida.PARES, 1.0,  fornec1, tipBoj14);
        Bojo boj41 = new Bojo(null, "refB41", null, false, UnidadeMedida.PARES, 1.0,  fornec2, tipBoj14);
        Bojo boj42 = new Bojo(null, "refB42", null, false, UnidadeMedida.PARES, 1.0,  fornec3, tipBoj14);
        Bojo boj43 = new Bojo(null, "refB43", null, false, UnidadeMedida.PARES, 1.0,  fornec1, tipBoj15);
        Bojo boj44 = new Bojo(null, "refB44", null, false, UnidadeMedida.PARES, 1.0,  fornec2, tipBoj15);
        Bojo boj45 = new Bojo(null, "refB45", null, false, UnidadeMedida.PARES, 1.0,  fornec3, tipBoj15);
        Bojo boj46 = new Bojo(null, "refB46", null, false, UnidadeMedida.PARES, 1.0,  fornec1, tipBoj16);
        Bojo boj47 = new Bojo(null, "refB47", null, false, UnidadeMedida.PARES, 1.0,  fornec2, tipBoj16);
        Bojo boj48 = new Bojo(null, "refB48", null, false, UnidadeMedida.PARES, 1.0,  fornec3, tipBoj16);
        Bojo boj49 = new Bojo(null, "refB49", null, false, UnidadeMedida.PARES, 1.0,  fornec1, tipBoj17);
        Bojo boj50 = new Bojo(null, "refB50", null, false, UnidadeMedida.PARES, 1.0,  fornec2, tipBoj17);
        Bojo boj51 = new Bojo(null, "refB51", null, false, UnidadeMedida.PARES, 1.0,  fornec3, tipBoj17);
        Bojo boj52 = new Bojo(null, "refB52", null, false, UnidadeMedida.PARES, 1.0,  fornec1, tipBoj18);
        Bojo boj53 = new Bojo(null, "refB53", null, false, UnidadeMedida.PARES, 1.0,  fornec2, tipBoj18);
        Bojo boj54 = new Bojo(null, "refB54", null, false, UnidadeMedida.PARES, 1.0,  fornec3, tipBoj18);

        Alca alca1 = new Alca(null, "refAlca1", null, false, UnidadeMedida.PARES, 4.0, fornec1, tipoAlca1);
        Alca alca2 = new Alca(null, "refAlca2", "fragil", false, UnidadeMedida.PARES, 4.0, fornec2, tipoAlca2);
        Alca alca3 = new Alca(null, "refAlca3", null, false, UnidadeMedida.PARES, 4.0, fornec3, tipoAlca1);
        Alca alca4 = new Alca(null, "refAlca4", null, false, UnidadeMedida.PARES, 4.0, fornec1, tipoAlca2);
        Alca alca5 = new Alca(null, "refAlca5", null, true, UnidadeMedida.PARES, 4.0, fornec2, tipoAlca1);
        Alca alca6 = new Alca(null, "refAlca6", "esgaca", false, UnidadeMedida.PARES, 4.0, fornec1, tipoAlca2);
        Alca alca7 = new Alca(null, "refAlca7", null, false, UnidadeMedida.PARES, 4.0, fornec1, tipoAlca1);

        Elastico elastico1 = new Elastico(null, "refElastico1", null, false, UnidadeMedida.METROS, 50.00, fornec1, tipoElastico1);
        Elastico elastico2 = new Elastico(null, "refElastico2", null, true, UnidadeMedida.METROS,  50.00, fornec1, tipoElastico2);
        Elastico elastico3 = new Elastico(null, "refElastico3", null, false, UnidadeMedida.METROS,  50.00, fornec1, tipoElastico1);
        Elastico elastico4 = new Elastico(null, "refElastico4", null, false, UnidadeMedida.METROS,  50.00, fornec1, tipoElastico2);
        Elastico elastico5 = new Elastico(null, "refElastico5", null, true, UnidadeMedida.METROS,  50.00, fornec1, tipoElastico1);
        Elastico elastico6 = new Elastico(null, "refElastico6", "muito fraco", false, UnidadeMedida.METROS, 50.00,  fornec1, tipoElastico2);
        Elastico elastico7 = new Elastico(null, "refElastico7", null, false, UnidadeMedida.METROS,  50.00, fornec1, tipoElastico1);

        Linha linha1 = new Linha(null, "refLinha1", null, false, UnidadeMedida.PEÇAS, 1.0, fornec1, tipoLinha1);
        Linha linha2 = new Linha(null, "refLinha1", null, false, UnidadeMedida.PEÇAS, 1.0,  fornec1, tipoLinha2);
        Linha linha3 = new Linha(null, "refLinha1", null, true, UnidadeMedida.PEÇAS, 1.0,  fornec1, tipoLinha1);
        Linha linha4 = new Linha(null, "refLinha1", "desfia", false, UnidadeMedida.PEÇAS, 1.0,  fornec1, tipoLinha2);
        Linha linha5 = new Linha(null, "refLinha1", null, false, UnidadeMedida.PEÇAS, 1.0,  fornec1, tipoLinha1);
        Linha linha6 = new Linha(null, "refLinha1", "ninguem quer", true, UnidadeMedida.PEÇAS, 1.0,  fornec1, tipoLinha2);
        Linha linha7 = new Linha(null, "refLinha1", null, false, UnidadeMedida.PEÇAS, 1.0,  fornec1, tipoLinha1);

        Renda renda1 = new Renda(null, "refRenda1", null, false, UnidadeMedida.METROS, 30.00, fornec1, tipoRenda1);
        Renda renda2 = new Renda(null, "refRenda2", null, false, UnidadeMedida.METROS, 30.00,  fornec1, tipoRenda2);
        Renda renda3 = new Renda(null, "refRenda3", null, false, UnidadeMedida.METROS, 30.00,  fornec1, tipoRenda1);
        Renda renda4 = new Renda(null, "refRenda4", null, false, UnidadeMedida.METROS, 30.00,  fornec1, tipoRenda2);
        Renda renda5 = new Renda(null, "refRenda5", null, false, UnidadeMedida.METROS, 30.00,  fornec1, tipoRenda1);
        Renda renda6 = new Renda(null, "refRenda6", null, false, UnidadeMedida.METROS, 30.00,  fornec1, tipoRenda2);
        Renda renda7 = new Renda(null, "refRenda7", null, false, UnidadeMedida.METROS,30.00, fornec1, tipoRenda1);



        //criando cores
        CorTecido corTec1 = new CorTecido(null, "ref01", "corA", null, 50.00,  0.5, UnidadeMedida.QUILOS, tec1, comp1);
        CorTecido corTec2 = new CorTecido(null, "ref02", "corB", null, 50.00, 0.5, UnidadeMedida.QUILOS,tec2, comp2);
        CorTecido corTec3 = new CorTecido(null, "ref03", "corC", null, 50.00, 0.5, UnidadeMedida.QUILOS, tec3, comp3);
        CorTecido corTec4 = new CorTecido(null, "ref04", "corD", "feia", 50.00, 0.5, UnidadeMedida.QUILOS, tec4, comp2);
        CorTecido corTec5 = new CorTecido(null, "ref05", "corE", null, 50.00, 0.5, UnidadeMedida.QUILOS, tec5, comp1);
        CorTecido corTec6 = new CorTecido(null, "ref06", "corF", null, 50.00, 0.5, UnidadeMedida.QUILOS, tec6, comp1);
        CorTecido corTec7 = new CorTecido(null, "ref07", "corG", null, 50.00, 0.5, UnidadeMedida.QUILOS, tec7, comp3);
        CorTecido corTec8 = new CorTecido(null, "ref08", "corH", "fina", 50.00, 0.5, UnidadeMedida.QUILOS, tec8, comp2);
        CorTecido corTec9 = new CorTecido(null, "ref09", "corI", null, 50.00, 0.5, UnidadeMedida.QUILOS, tec9, comp3);
        CorTecido corTec10 = new CorTecido(null, "ref010", "corJ", null, 50.00, 0.5, UnidadeMedida.QUILOS, tec10, comp3);
        CorTecido corTec11 = new CorTecido(null, "ref011", "corK", null, 50.00, 0.5, UnidadeMedida.QUILOS, tec11, comp2);
        CorTecido corTec12 = new CorTecido(null, "ref012", "corL", null, 50.00, 0.5, UnidadeMedida.QUILOS, tec12, comp2);
        CorTecido corTec13 = new CorTecido(null, "ref013", "corM", null, 50.00, 0.5, UnidadeMedida.QUILOS, tec13, comp1);
        CorTecido corTec14 = new CorTecido(null, "ref014", "corN", "tosca", 50.00, 0.5, UnidadeMedida.QUILOS, tec14, comp2);
        CorTecido corTec15 = new CorTecido(null, "ref015", "corO", null, 50.00, 0.5, UnidadeMedida.QUILOS, tec15, comp1);
        CorTecido corTec16 = new CorTecido(null, "ref016", "corP", null, 50.00, 0.5, UnidadeMedida.QUILOS, tec1, comp1);
        CorTecido corTec17 = new CorTecido(null, "ref017", "corQ", null, 50.00, 0.5, UnidadeMedida.QUILOS, tec2, comp3);
        CorTecido corTec18 = new CorTecido(null, "ref018", "corR", null, 50.00, 0.5, UnidadeMedida.QUILOS, tec3, comp1);
        CorTecido corTec19 = new CorTecido(null, "ref019", "corS", "amarelada", 50.00, 0.5, UnidadeMedida.QUILOS, tec4, comp2);
        CorTecido corTec20 = new CorTecido(null, "ref020", "corT", null, 50.00, 0.5, UnidadeMedida.QUILOS, tec5, comp1);
        CorTecido corTec21 = new CorTecido(null, "ref021", "corU", null, 50.00, 0.5, UnidadeMedida.QUILOS, tec6, comp3);
        CorTecido corTec22 = new CorTecido(null, "ref022", "corV", null, 50.00, 0.5, UnidadeMedida.QUILOS, tec7, comp1);
        CorTecido corTec23 = new CorTecido(null, "ref023", "corX", null, 50.00, 0.5, UnidadeMedida.QUILOS, tec8, comp1);
        CorTecido corTec24 = new CorTecido(null, "ref024", "corY", "desbota", 50.00, 0.5, UnidadeMedida.QUILOS, tec9, comp2);
        CorTecido corTec25 = new CorTecido(null, "ref025", "corW", null, 50.00, 0.5, UnidadeMedida.QUILOS, tec10, comp1);
        CorTecido corTec26 = new CorTecido(null, "ref026", "corZ", null, 50.00, 0.5, UnidadeMedida.QUILOS, tec11, comp1);
        CorTecido corTec27 = new CorTecido(null, "ref027", "corAB", null, 50.00, 0.5, UnidadeMedida.QUILOS, tec12, comp1);
        CorTecido corTec28 = new CorTecido(null, "ref028", "corAC", null, 50.00, 0.5, UnidadeMedida.QUILOS, tec13, comp2);
        CorTecido corTec29 = new CorTecido(null, "ref029", "corAD", null, 50.00, 0.5, UnidadeMedida.QUILOS, tec14, comp1);
        CorTecido corTec30 = new CorTecido(null, "ref030", "corAE", null, 50.00, 0.5, UnidadeMedida.QUILOS, tec15, comp3);

        CorColchete corColc1 = new CorColchete(null, "ref101", "corColcA", null, 50.00, 2.0, UnidadeMedida.UNIDADES, colc1);
        CorColchete corColc2 = new CorColchete(null, "ref102", "corColcB", null, 50.00, 2.0, UnidadeMedida.UNIDADES, colc1);
        CorColchete corColc3 = new CorColchete(null, "ref103", "corColcC", null, 50.00, 2.0, UnidadeMedida.UNIDADES, colc1);
        CorColchete corColc4 = new CorColchete(null, "ref104", "corColcD", null, 50.00, 2.0, UnidadeMedida.UNIDADES, colc2);
        CorColchete corColc5 = new CorColchete(null, "ref105", "corColcE", null, 50.00, 2.0, UnidadeMedida.UNIDADES, colc2);
        CorColchete corColc6 = new CorColchete(null, "ref106", "corColcF", null, 50.00, 2.0, UnidadeMedida.UNIDADES, colc2);

        CorBojo corBojo2 = new CorBojo(null, "corBojo1", "Vermelho", null, 100.00, 1.0, UnidadeMedida.PARES, boj1);
        CorBojo corBojo3 = new CorBojo(null, "corBojo2", "Preto", null, 100.00,  1.0, UnidadeMedida.PARES, boj1);
        CorBojo corBojo4 = new CorBojo(null, "corBojo3", "Branco", null, 100.00,  1.0, UnidadeMedida.PARES, boj1);
        CorBojo corBojo5 = new CorBojo(null, "corBojo4", "Amarelo", null, 100.00,  1.0, UnidadeMedida.PARES, boj1);
        CorBojo corBojo6 = new CorBojo(null, "corBojo5", "Vermelho", null, 100.00, 1.0, UnidadeMedida.PARES,  boj2);
        CorBojo corBojo7 = new CorBojo(null, "corBojo6", "Preto", null, 100.00, 1.0, UnidadeMedida.PARES,  boj2);
        CorBojo corBojo8 = new CorBojo(null, "corBojo7", "Branco", null, 100.00, 1.0, UnidadeMedida.PARES,  boj2);
        CorBojo corBojo9 = new CorBojo(null, "corBojo8", "Amarelo", null, 100.00, 1.0, UnidadeMedida.PARES,  boj2);
        CorBojo corBojo10 = new CorBojo(null, "corBojo9", "Vermelho", null, 100.00, 1.0, UnidadeMedida.PARES,  boj3);
        CorBojo corBojo11 = new CorBojo(null, "corBojo10", "Preto", null, 100.00, 1.0, UnidadeMedida.PARES,  boj3);
        CorBojo corBojo12 = new CorBojo(null, "corBojo11", "Branco", null, 100.00, 1.0, UnidadeMedida.PARES,  boj3);
        CorBojo corBojo13 = new CorBojo(null, "corBojo12", "Amarelo", null, 100.00, 1.0, UnidadeMedida.PARES,  boj3);
        CorBojo corBojo14 = new CorBojo(null, "corBojo13", "Vermelho", null, 100.00, 1.0, UnidadeMedida.PARES,  boj4);
        CorBojo corBojo15 = new CorBojo(null, "corBojo14", "Preto", null, 100.00, 1.0, UnidadeMedida.PARES,  boj4);
        CorBojo corBojo16 = new CorBojo(null, "corBojo15", "Branco", null, 100.00, 1.0, UnidadeMedida.PARES,  boj4);
        CorBojo corBojo17 = new CorBojo(null, "corBojo16", "Amarelo", null, 100.00, 1.0, UnidadeMedida.PARES,  boj4);
        CorBojo corBojo18 = new CorBojo(null, "corBojo17", "Vermelho", null, 100.00, 1.0, UnidadeMedida.PARES,  boj5);
        CorBojo corBojo19 = new CorBojo(null, "corBojo18", "Preto", null, 100.00, 1.0, UnidadeMedida.PARES,  boj5);
        CorBojo corBojo20 = new CorBojo(null, "corBojo19", "Branco", null, 100.00, 1.0, UnidadeMedida.PARES,  boj5);
        CorBojo corBojo21 = new CorBojo(null, "corBojo20", "Amarelo", null, 100.00, 1.0, UnidadeMedida.PARES,  boj5);
        CorBojo corBojo22 = new CorBojo(null, "corBojo21", "Vermelho", null, 100.00, 1.0, UnidadeMedida.PARES,  boj6);
        CorBojo corBojo23 = new CorBojo(null, "corBojo22", "Preto", null, 100.00, 1.0, UnidadeMedida.PARES,  boj6);
        CorBojo corBojo24 = new CorBojo(null, "corBojo23", "Branco", null, 100.00, 1.0, UnidadeMedida.PARES,  boj6);
        CorBojo corBojo25 = new CorBojo(null, "corBojo24", "Amarelo", null, 100.00, 1.0, UnidadeMedida.PARES,  boj6);
        CorBojo corBojo26 = new CorBojo(null, "corBojo25", "Vermelho", null, 100.00, 1.0, UnidadeMedida.PARES,  boj7);
        CorBojo corBojo27 = new CorBojo(null, "corBojo26", "Preto", null, 100.00, 1.0, UnidadeMedida.PARES,  boj7);
        CorBojo corBojo28 = new CorBojo(null, "corBojo27", "Branco", null, 100.00, 1.0, UnidadeMedida.PARES,  boj7);
        CorBojo corBojo29 = new CorBojo(null, "corBojo28", "Amarelo", null, 100.00, 1.0, UnidadeMedida.PARES,  boj7);
        CorBojo corBojo30 = new CorBojo(null, "corBojo29", "Vermelho", null, 100.00, 1.0, UnidadeMedida.PARES,  boj8);
        CorBojo corBojo31 = new CorBojo(null, "corBojo30", "Preto", null, 100.00, 1.0, UnidadeMedida.PARES,  boj8);
        CorBojo corBojo32 = new CorBojo(null, "corBojo31", "Branco", null, 100.00, 1.0, UnidadeMedida.PARES,  boj8);
        CorBojo corBojo33 = new CorBojo(null, "corBojo32", "Amarelo", null, 100.00, 1.0, UnidadeMedida.PARES,  boj8);
        CorBojo corBojo34 = new CorBojo(null, "corBojo33", "Vermelho", null, 100.00, 1.0, UnidadeMedida.PARES,  boj9);
        CorBojo corBojo35 = new CorBojo(null, "corBojo34", "Preto", null, 100.00, 1.0, UnidadeMedida.PARES,  boj9);
        CorBojo corBojo36 = new CorBojo(null, "corBojo35", "Branco", null, 100.00, 1.0, UnidadeMedida.PARES,  boj9);
        CorBojo corBojo37 = new CorBojo(null, "corBojo36", "Amarelo", null, 100.00, 1.0, UnidadeMedida.PARES,  boj9);
        CorBojo corBojo38 = new CorBojo(null, "corBojo37", "Vermelho", null, 100.00, 1.0, UnidadeMedida.PARES,  boj10);
        CorBojo corBojo39 = new CorBojo(null, "corBojo38", "Preto", null, 100.00, 1.0, UnidadeMedida.PARES,  boj10);
        CorBojo corBojo40 = new CorBojo(null, "corBojo39", "Branco", null, 100.00, 1.0, UnidadeMedida.PARES,  boj10);
        CorBojo corBojo41 = new CorBojo(null, "corBojo40", "Amarelo", null, 100.00, 1.0, UnidadeMedida.PARES,  boj10);
        CorBojo corBojo42 = new CorBojo(null, "corBojo41", "Vermelho", null, 100.00, 1.0, UnidadeMedida.PARES,  boj11);
        CorBojo corBojo43 = new CorBojo(null, "corBojo42", "Preto", null, 100.00, 1.0, UnidadeMedida.PARES,  boj11);
        CorBojo corBojo44 = new CorBojo(null, "corBojo43", "Branco", null, 100.00, 1.0, UnidadeMedida.PARES,  boj11);
        CorBojo corBojo45 = new CorBojo(null, "corBojo44", "Amarelo", null, 100.00, 1.0, UnidadeMedida.PARES,  boj11);
        CorBojo corBojo46 = new CorBojo(null, "corBojo45", "Vermelho", null, 100.00, 1.0, UnidadeMedida.PARES,  boj12);
        CorBojo corBojo47 = new CorBojo(null, "corBojo46", "Preto", null, 100.00, 1.0, UnidadeMedida.PARES,  boj12);
        CorBojo corBojo48 = new CorBojo(null, "corBojo47", "Branco", null, 100.00, 1.0, UnidadeMedida.PARES,  boj12);
        CorBojo corBojo49 = new CorBojo(null, "corBojo48", "Amarelo", null, 100.00, 1.0, UnidadeMedida.PARES,  boj12);
        CorBojo corBojo50 = new CorBojo(null, "corBojo49", "Vermelho", null, 100.00, 1.0, UnidadeMedida.PARES,  boj13);
        CorBojo corBojo51 = new CorBojo(null, "corBojo50", "Preto", null, 100.00, 1.0, UnidadeMedida.PARES,  boj13);
        CorBojo corBojo52 = new CorBojo(null, "corBojo51", "Branco", null, 100.00, 1.0, UnidadeMedida.PARES,  boj13);
        CorBojo corBojo53 = new CorBojo(null, "corBojo52", "Amarelo", null, 100.00, 1.0, UnidadeMedida.PARES,  boj13);
        CorBojo corBojo54 = new CorBojo(null, "corBojo53", "Vermelho", null, 100.00, 1.0, UnidadeMedida.PARES,  boj14);
        CorBojo corBojo55 = new CorBojo(null, "corBojo54", "Preto", null, 100.00, 1.0, UnidadeMedida.PARES,  boj14);
        CorBojo corBojo56 = new CorBojo(null, "corBojo55", "Branco", null, 100.00, 1.0, UnidadeMedida.PARES,  boj14);
        CorBojo corBojo57 = new CorBojo(null, "corBojo56", "Amarelo", null, 100.00, 1.0, UnidadeMedida.PARES,  boj14);
        CorBojo corBojo58 = new CorBojo(null, "corBojo57", "Vermelho", null, 100.00, 1.0, UnidadeMedida.PARES,  boj15);
        CorBojo corBojo59 = new CorBojo(null, "corBojo58", "Preto", null, 100.00, 1.0, UnidadeMedida.PARES,  boj15);
        CorBojo corBojo60 = new CorBojo(null, "corBojo59", "Branco", null, 100.00, 1.0, UnidadeMedida.PARES,  boj15);
        CorBojo corBojo61 = new CorBojo(null, "corBojo60", "Amarelo", null, 100.00, 1.0, UnidadeMedida.PARES,  boj15);
        CorBojo corBojo62 = new CorBojo(null, "corBojo61", "Vermelho", null, 100.00, 1.0, UnidadeMedida.PARES,  boj16);
        CorBojo corBojo63 = new CorBojo(null, "corBojo62", "Preto", null, 100.00, 1.0, UnidadeMedida.PARES,  boj16);
        CorBojo corBojo64 = new CorBojo(null, "corBojo63", "Branco", null, 100.00, 1.0, UnidadeMedida.PARES,  boj16);
        CorBojo corBojo65 = new CorBojo(null, "corBojo64", "Amarelo", null, 100.00, 1.0, UnidadeMedida.PARES,  boj16);
        CorBojo corBojo66 = new CorBojo(null, "corBojo65", "Vermelho", null, 100.00, 1.0, UnidadeMedida.PARES,  boj17);
        CorBojo corBojo67 = new CorBojo(null, "corBojo66", "Preto", null, 100.00, 1.0, UnidadeMedida.PARES,  boj17);
        CorBojo corBojo68 = new CorBojo(null, "corBojo67", "Branco", null, 100.00, 1.0, UnidadeMedida.PARES,  boj17);
        CorBojo corBojo69 = new CorBojo(null, "corBojo68", "Amarelo", null, 100.00, 1.0, UnidadeMedida.PARES,  boj17);
        CorBojo corBojo70 = new CorBojo(null, "corBojo69", "Vermelho", null, 100.00, 1.0, UnidadeMedida.PARES,  boj18);
        CorBojo corBojo71 = new CorBojo(null, "corBojo70", "Preto", null, 100.00, 1.0, UnidadeMedida.PARES,  boj18);
        CorBojo corBojo72 = new CorBojo(null, "corBojo71", "Branco", null, 100.00, 1.0, UnidadeMedida.PARES,  boj18);
        CorBojo corBojo73 = new CorBojo(null, "corBojo72", "Amarelo", null, 100.00, 1.0, UnidadeMedida.PARES,  boj18);
        CorBojo corBojo74 = new CorBojo(null, "corBojo73", "Vermelho", null, 100.00, 1.0, UnidadeMedida.PARES,  boj19);
        CorBojo corBojo75 = new CorBojo(null, "corBojo74", "Preto", null, 100.00, 1.0, UnidadeMedida.PARES,  boj19);
        CorBojo corBojo76 = new CorBojo(null, "corBojo75", "Branco", null, 100.00, 1.0, UnidadeMedida.PARES,  boj19);
        CorBojo corBojo77 = new CorBojo(null, "corBojo76", "Amarelo", null, 100.00, 1.0, UnidadeMedida.PARES,  boj19);
        CorBojo corBojo78 = new CorBojo(null, "corBojo77", "Vermelho", null, 100.00, 1.0, UnidadeMedida.PARES,  boj20);
        CorBojo corBojo79 = new CorBojo(null, "corBojo78", "Preto", null, 100.00, 1.0, UnidadeMedida.PARES,  boj20);
        CorBojo corBojo80 = new CorBojo(null, "corBojo79", "Branco", null, 100.00, 1.0, UnidadeMedida.PARES,  boj20);
        CorBojo corBojo81 = new CorBojo(null, "corBojo80", "Amarelo", null, 100.00, 1.0, UnidadeMedida.PARES, boj20);
        CorBojo corBojo82 = new CorBojo(null, "corBojo81", "Vermelho", null, 100.00, 1.0, UnidadeMedida.PARES,  boj21);
        CorBojo corBojo83 = new CorBojo(null, "corBojo82", "Preto", null, 100.00, 1.0, UnidadeMedida.PARES,  boj21);
        CorBojo corBojo84 = new CorBojo(null, "corBojo83", "Branco", null, 100.00, 1.0, UnidadeMedida.PARES,  boj21);
        CorBojo corBojo85 = new CorBojo(null, "corBojo84", "Amarelo", null, 100.00, 1.0, UnidadeMedida.PARES,  boj21);
        CorBojo corBojo86 = new CorBojo(null, "corBojo85", "Vermelho", null, 100.00, 1.0, UnidadeMedida.PARES,  boj22);
        CorBojo corBojo87 = new CorBojo(null, "corBojo86", "Preto", null, 100.00, 1.0, UnidadeMedida.PARES,  boj22);
        CorBojo corBojo88 = new CorBojo(null, "corBojo87", "Branco", null, 100.00, 1.0, UnidadeMedida.PARES,  boj22);
        CorBojo corBojo89 = new CorBojo(null, "corBojo88", "Amarelo", null, 100.00, 1.0, UnidadeMedida.PARES,  boj22);
        CorBojo corBojo90 = new CorBojo(null, "corBojo89", "Vermelho", null, 100.00, 1.0, UnidadeMedida.PARES,  boj23);
        CorBojo corBojo91 = new CorBojo(null, "corBojo90", "Preto", null, 100.00, 1.0, UnidadeMedida.PARES,  boj23);
        CorBojo corBojo92 = new CorBojo(null, "corBojo91", "Branco", null, 100.00, 1.0, UnidadeMedida.PARES,  boj23);
        CorBojo corBojo93 = new CorBojo(null, "corBojo92", "Amarelo", null, 100.00, 1.0, UnidadeMedida.PARES,  boj23);
        CorBojo corBojo94 = new CorBojo(null, "corBojo93", "Vermelho", null, 100.00, 1.0, UnidadeMedida.PARES,  boj24);
        CorBojo corBojo95 = new CorBojo(null, "corBojo94", "Preto", null, 100.00, 1.0, UnidadeMedida.PARES,  boj24);
        CorBojo corBojo96 = new CorBojo(null, "corBojo95", "Branco", null, 100.00, 1.0, UnidadeMedida.PARES,  boj24);
        CorBojo corBojo97 = new CorBojo(null, "corBojo96", "Amarelo", null, 100.00, 1.0, UnidadeMedida.PARES,  boj24);
        CorBojo corBojo98 = new CorBojo(null, "corBojo97", "Vermelho", null, 100.00, 1.0, UnidadeMedida.PARES,  boj25);
        CorBojo corBojo99 = new CorBojo(null, "corBojo98", "Preto", null, 100.00, 1.0, UnidadeMedida.PARES,  boj25);
        CorBojo corBojo100 = new CorBojo(null, "corBojo99", "Branco", null, 100.00, 1.0, UnidadeMedida.PARES,  boj25);
        CorBojo corBojo101 = new CorBojo(null, "corBojo100", "Amarelo", null, 100.00, 1.0, UnidadeMedida.PARES,  boj25);
        CorBojo corBojo102 = new CorBojo(null, "corBojo101", "Vermelho", null, 100.00, 1.0, UnidadeMedida.PARES,  boj26);
        CorBojo corBojo103 = new CorBojo(null, "corBojo102", "Preto", null, 100.00, 1.0, UnidadeMedida.PARES,  boj26);
        CorBojo corBojo104 = new CorBojo(null, "corBojo103", "Branco", null, 100.00, 1.0, UnidadeMedida.PARES,  boj26);
        CorBojo corBojo105 = new CorBojo(null, "corBojo104", "Amarelo", null, 100.00, 1.0, UnidadeMedida.PARES,  boj26);
        CorBojo corBojo106 = new CorBojo(null, "corBojo106", "Vermelho", null, 100.00, 1.0, UnidadeMedida.PARES,  boj27);
        CorBojo corBojo107 = new CorBojo(null, "corBojo107", "Preto", null, 100.00, 1.0, UnidadeMedida.PARES,  boj27);
        CorBojo corBojo108 = new CorBojo(null, "corBojo108", "Branco", null, 100.00, 1.0, UnidadeMedida.PARES,  boj27);
        CorBojo corBojo109 = new CorBojo(null, "corBojo109", "Amarelo", null, 100.00, 1.0, UnidadeMedida.PARES,  boj27);
        CorBojo corBojo110 = new CorBojo(null, "corBojo110", "Vermelho", null, 100.00, 1.0, UnidadeMedida.PARES,  boj28);
        CorBojo corBojo111 = new CorBojo(null, "corBojo111", "Preto", null, 100.00, 1.0, UnidadeMedida.PARES,  boj28);
        CorBojo corBojo112 = new CorBojo(null, "corBojo112", "Branco", null, 100.00, 1.0, UnidadeMedida.PARES,  boj28);
        CorBojo corBojo113 = new CorBojo(null, "corBojo113", "Amarelo", null, 100.00, 1.0, UnidadeMedida.PARES,  boj28);
        CorBojo corBojo114 = new CorBojo(null, "corBojo114", "Vermelho", null, 100.00, 1.0, UnidadeMedida.PARES,  boj29);
        CorBojo corBojo115 = new CorBojo(null, "corBojo115", "Preto", null, 100.00, 1.0, UnidadeMedida.PARES,  boj29);
        CorBojo corBojo116 = new CorBojo(null, "corBojo116", "Branco", null, 100.00, 1.0, UnidadeMedida.PARES,  boj29);
        CorBojo corBojo117 = new CorBojo(null, "corBojo117", "Amarelo", null, 100.00, 1.0, UnidadeMedida.PARES,  boj29);
        CorBojo corBojo118 = new CorBojo(null, "corBojo118", "Vermelho", null, 100.00, 1.0, UnidadeMedida.PARES,  boj30);
        CorBojo corBojo119 = new CorBojo(null, "corBojo119", "Preto", null, 100.00, 1.0, UnidadeMedida.PARES,  boj30);
        CorBojo corBojo120 = new CorBojo(null, "corBojo120", "Branco", null, 100.00,  1.0, UnidadeMedida.PARES, boj30);
        CorBojo corBojo121 = new CorBojo(null, "corBojo121", "Amarelo", null, 100.00, 1.0, UnidadeMedida.PARES,  boj30);
        CorBojo corBojo122 = new CorBojo(null, "corBojo122", "Vermelho", null, 100.00, 1.0, UnidadeMedida.PARES,  boj31);
        CorBojo corBojo123 = new CorBojo(null, "corBojo123", "Preto", null, 100.00, 1.0, UnidadeMedida.PARES,  boj31);
        CorBojo corBojo124 = new CorBojo(null, "corBojo124", "Branco", null, 100.00, 1.0, UnidadeMedida.PARES,  boj31);
        CorBojo corBojo125 = new CorBojo(null, "corBojo125", "Amarelo", null, 100.00, 1.0, UnidadeMedida.PARES,  boj31);
        CorBojo corBojo126 = new CorBojo(null, "corBojo126", "Vermelho", null, 100.00, 1.0, UnidadeMedida.PARES,  boj32);
        CorBojo corBojo127 = new CorBojo(null, "corBojo127", "Preto", null, 100.00, 1.0, UnidadeMedida.PARES,  boj32);
        CorBojo corBojo128 = new CorBojo(null, "corBojo128", "Branco", null, 100.00, 1.0, UnidadeMedida.PARES,  boj32);
        CorBojo corBojo129 = new CorBojo(null, "corBojo129", "Amarelo", null, 100.00,  1.0, UnidadeMedida.PARES, boj32);
        CorBojo corBojo130 = new CorBojo(null, "corBojo130", "Vermelho", null, 100.00, 1.0, UnidadeMedida.PARES,  boj33);
        CorBojo corBojo131 = new CorBojo(null, "corBojo131", "Preto", null, 100.00, 1.0, UnidadeMedida.PARES,  boj33);
        CorBojo corBojo132 = new CorBojo(null, "corBojo132", "Branco", null, 100.00, 1.0, UnidadeMedida.PARES,  boj33);
        CorBojo corBojo133 = new CorBojo(null, "corBojo133", "Amarelo", null, 100.00, 1.0, UnidadeMedida.PARES,  boj33);
        CorBojo corBojo134 = new CorBojo(null, "corBojo134", "Vermelho", null, 100.00, 1.0, UnidadeMedida.PARES,  boj34);
        CorBojo corBojo135 = new CorBojo(null, "corBojo135", "Preto", null, 100.00, 1.0, UnidadeMedida.PARES,  boj34);
        CorBojo corBojo136 = new CorBojo(null, "corBojo136", "Branco", null, 100.00, 1.0, UnidadeMedida.PARES,  boj34);
        CorBojo corBojo137 = new CorBojo(null, "corBojo137", "Amarelo", null, 100.00, 1.0, UnidadeMedida.PARES,  boj34);
        CorBojo corBojo138 = new CorBojo(null, "corBojo138", "Vermelho", null, 100.00, 1.0, UnidadeMedida.PARES,  boj35);
        CorBojo corBojo139 = new CorBojo(null, "corBojo139", "Preto", null, 100.00, 1.0, UnidadeMedida.PARES,  boj35);
        CorBojo corBojo140 = new CorBojo(null, "corBojo140", "Branco", null, 100.00, 1.0, UnidadeMedida.PARES,  boj35);
        CorBojo corBojo141 = new CorBojo(null, "corBojo141", "Amarelo", null, 100.00, 1.0, UnidadeMedida.PARES,  boj35);
        CorBojo corBojo142 = new CorBojo(null, "corBojo142", "Vermelho", null, 100.00, 1.0, UnidadeMedida.PARES,  boj36);
        CorBojo corBojo143 = new CorBojo(null, "corBojo143", "Preto", null, 100.00, 1.0, UnidadeMedida.PARES,  boj36);
        CorBojo corBojo144 = new CorBojo(null, "corBojo144", "Branco", null, 100.00, 1.0, UnidadeMedida.PARES,  boj36);
        CorBojo corBojo145 = new CorBojo(null, "corBojo145", "Amarelo", null, 100.00, 1.0, UnidadeMedida.PARES,  boj36);
        CorBojo corBojo146 = new CorBojo(null, "corBojo146", "Vermelho", null, 100.00, 1.0, UnidadeMedida.PARES,  boj37);
        CorBojo corBojo147 = new CorBojo(null, "corBojo147", "Preto", null, 100.00, 1.0, UnidadeMedida.PARES,  boj37);
        CorBojo corBojo148 = new CorBojo(null, "corBojo148", "Branco", null, 100.00, 1.0, UnidadeMedida.PARES,  boj37);
        CorBojo corBojo149 = new CorBojo(null, "corBojo149", "Amarelo", null, 100.00, 1.0, UnidadeMedida.PARES,  boj37);
        CorBojo corBojo150 = new CorBojo(null, "corBojo150", "Vermelho", null, 100.00, 1.0, UnidadeMedida.PARES,  boj38);
        CorBojo corBojo151 = new CorBojo(null, "corBojo151", "Preto", null, 100.00, 1.0, UnidadeMedida.PARES,  boj38);
        CorBojo corBojo152 = new CorBojo(null, "corBojo152", "Branco", null, 100.00, 1.0, UnidadeMedida.PARES,  boj38);
        CorBojo corBojo153 = new CorBojo(null, "corBojo153", "Amarelo", null, 100.00, 1.0, UnidadeMedida.PARES,  boj38);
        CorBojo corBojo154 = new CorBojo(null, "corBojo154", "Vermelho", null, 100.00, 1.0, UnidadeMedida.PARES,  boj39);
        CorBojo corBojo155 = new CorBojo(null, "corBojo155", "Preto", null, 100.00, 1.0, UnidadeMedida.PARES,  boj39);
        CorBojo corBojo156 = new CorBojo(null, "corBojo156", "Branco", null, 100.00, 1.0, UnidadeMedida.PARES,  boj39);
        CorBojo corBojo157 = new CorBojo(null, "corBojo157", "Amarelo", null, 100.00, 1.0, UnidadeMedida.PARES,  boj39);
        CorBojo corBojo158 = new CorBojo(null, "corBojo158", "Vermelho", null, 100.00, 1.0, UnidadeMedida.PARES,  boj40);
        CorBojo corBojo159 = new CorBojo(null, "corBojo159", "Preto", null, 100.00, 1.0, UnidadeMedida.PARES,  boj40);
        CorBojo corBojo160 = new CorBojo(null, "corBojo160", "Branco", null, 100.00, 1.0, UnidadeMedida.PARES,  boj40);
        CorBojo corBojo161 = new CorBojo(null, "corBojo161", "Amarelo", null, 100.00, 1.0, UnidadeMedida.PARES,  boj40);
        CorBojo corBojo162 = new CorBojo(null, "corBojo162", "Vermelho", null, 100.00, 1.0, UnidadeMedida.PARES,  boj41);
        CorBojo corBojo163 = new CorBojo(null, "corBojo163", "Preto", null, 100.00, 1.0, UnidadeMedida.PARES,  boj41);
        CorBojo corBojo164 = new CorBojo(null, "corBojo164", "Branco", null, 100.00, 1.0, UnidadeMedida.PARES,  boj41);
        CorBojo corBojo165 = new CorBojo(null, "corBojo165", "Amarelo", null, 100.00, 1.0, UnidadeMedida.PARES,  boj41);
        CorBojo corBojo166 = new CorBojo(null, "corBojo166", "Vermelho", null, 100.00, 1.0, UnidadeMedida.PARES,  boj42);
        CorBojo corBojo167 = new CorBojo(null, "corBojo167", "Preto", null, 100.00, 1.0, UnidadeMedida.PARES,  boj42);
        CorBojo corBojo168 = new CorBojo(null, "corBojo168", "Branco", null, 100.00, 1.0, UnidadeMedida.PARES,  boj42);
        CorBojo corBojo169 = new CorBojo(null, "corBojo169", "Amarelo", null, 100.00, 1.0, UnidadeMedida.PARES,  boj42);
        CorBojo corBojo170 = new CorBojo(null, "corBojo170", "Vermelho", null, 100.00, 1.0, UnidadeMedida.PARES,  boj43);
        CorBojo corBojo171 = new CorBojo(null, "corBojo171", "Preto", null, 100.00, 1.0, UnidadeMedida.PARES,  boj43);
        CorBojo corBojo172 = new CorBojo(null, "corBojo172", "Branco", null, 100.00, 1.0, UnidadeMedida.PARES,  boj43);
        CorBojo corBojo173 = new CorBojo(null, "corBojo173", "Amarelo", null, 100.00, 1.0, UnidadeMedida.PARES,  boj43);
        CorBojo corBojo174 = new CorBojo(null, "corBojo174", "Vermelho", null, 100.00, 1.0, UnidadeMedida.PARES,  boj44);
        CorBojo corBojo175 = new CorBojo(null, "corBojo175", "Preto", null, 100.00, 1.0, UnidadeMedida.PARES,  boj44);
        CorBojo corBojo176 = new CorBojo(null, "corBojo176", "Branco", null, 100.00, 1.0, UnidadeMedida.PARES,  boj44);
        CorBojo corBojo177 = new CorBojo(null, "corBojo177", "Amarelo", null, 100.00, 1.0, UnidadeMedida.PARES,  boj44);
        CorBojo corBojo178 = new CorBojo(null, "corBojo178", "Vermelho", null, 100.00, 1.0, UnidadeMedida.PARES,  boj45);
        CorBojo corBojo179 = new CorBojo(null, "corBojo179", "Preto", null, 100.00, 1.0, UnidadeMedida.PARES,  boj45);
        CorBojo corBojo180 = new CorBojo(null, "corBojo180", "Branco", null, 100.00, 1.0, UnidadeMedida.PARES,  boj45);
        CorBojo corBojo181 = new CorBojo(null, "corBojo181", "Amarelo", null, 100.00, 1.0, UnidadeMedida.PARES,  boj45);
        CorBojo corBojo182 = new CorBojo(null, "corBojo182", "Vermelho", null, 100.00, 1.0, UnidadeMedida.PARES,  boj46);
        CorBojo corBojo183 = new CorBojo(null, "corBojo183", "Preto", null, 100.00, 1.0, UnidadeMedida.PARES,  boj46);
        CorBojo corBojo184 = new CorBojo(null, "corBojo184", "Branco", null, 100.00, 1.0, UnidadeMedida.PARES,  boj46);
        CorBojo corBojo185 = new CorBojo(null, "corBojo185", "Amarelo", null, 100.00,  1.0, UnidadeMedida.PARES, boj46);
        CorBojo corBojo186 = new CorBojo(null, "corBojo186", "Vermelho", null, 100.00, 1.0, UnidadeMedida.PARES,  boj47);
        CorBojo corBojo187 = new CorBojo(null, "corBojo187", "Preto", null, 100.00, 1.0, UnidadeMedida.PARES,  boj47);
        CorBojo corBojo188 = new CorBojo(null, "corBojo188", "Branco", null, 100.00, 1.0, UnidadeMedida.PARES,  boj47);
        CorBojo corBojo189 = new CorBojo(null, "corBojo189", "Amarelo", null, 100.00, 1.0, UnidadeMedida.PARES,  boj47);
        CorBojo corBojo190 = new CorBojo(null, "corBojo190", "Vermelho", null, 100.00, 1.0, UnidadeMedida.PARES,  boj48);
        CorBojo corBojo191 = new CorBojo(null, "corBojo191", "Preto", null,   100.00, 1.0, UnidadeMedida.PARES, boj48);
        CorBojo corBojo192 = new CorBojo(null, "corBojo192", "Branco", null, 100.00, 1.0, UnidadeMedida.PARES, boj48);
        CorBojo corBojo193 = new CorBojo(null, "corBojo193", "Amarelo", null,   100.00, 1.0, UnidadeMedida.PARES,boj48);
        CorBojo corBojo194 = new CorBojo(null, "corBojo194", "Vermelho", null, 100.00, 1.0, UnidadeMedida.PARES,   boj49);
        CorBojo corBojo195 = new CorBojo(null, "corBojo195", "Preto", null, 100.00, 1.0, UnidadeMedida.PARES,   boj49);
        CorBojo corBojo196 = new CorBojo(null, "corBojo196", "Branco", null,  100.00, 1.0, UnidadeMedida.PARES,   boj49);
        CorBojo corBojo197 = new CorBojo(null, "corBojo197", "Amarelo", null,  100.00, 1.0, UnidadeMedida.PARES,   boj49);
        CorBojo corBojo198 = new CorBojo(null, "corBojo198", "Vermelho", null,  100.00, 1.0, UnidadeMedida.PARES,   boj50);
        CorBojo corBojo199 = new CorBojo(null, "corBojo199", "Preto", null,  100.00, 1.0, UnidadeMedida.PARES,   boj50);
        CorBojo corBojo200 = new CorBojo(null, "corBojo200", "Branco", null,  100.00, 1.0, UnidadeMedida.PARES,   boj50);
        CorBojo corBojo201 = new CorBojo(null, "corBojo201", "Amarelo", null,  100.00, 1.0, UnidadeMedida.PARES,   boj50);
        CorBojo corBojo202 = new CorBojo(null, "corBojo202", "Vermelho", null,  100.00, 1.0, UnidadeMedida.PARES,   boj51);
        CorBojo corBojo203 = new CorBojo(null, "corBojo203", "Preto", null,  100.00, 1.0, UnidadeMedida.PARES,   boj51);
        CorBojo corBojo204 = new CorBojo(null, "corBojo204", "Branco", null,  100.00, 1.0, UnidadeMedida.PARES,   boj51);
        CorBojo corBojo205 = new CorBojo(null, "corBojo205", "Amarelo", null,  100.00, 1.0, UnidadeMedida.PARES,   boj51);
        CorBojo corBojo206 = new CorBojo(null, "corBojo206", "Vermelho", null,  100.00, 1.0, UnidadeMedida.PARES,   boj52);
        CorBojo corBojo207 = new CorBojo(null, "corBojo207", "Preto", null,  100.00, 1.0, UnidadeMedida.PARES,   boj52);
        CorBojo corBojo208 = new CorBojo(null, "corBojo208", "Branco", null,  100.00, 1.0, UnidadeMedida.PARES,   boj52);
        CorBojo corBojo209 = new CorBojo(null, "corBojo209", "Amarelo", null,  100.00, 1.0, UnidadeMedida.PARES,   boj52);
        CorBojo corBojo210 = new CorBojo(null, "corBojo210", "Vermelho", null,  100.00, 1.0, UnidadeMedida.PARES,   boj53);
        CorBojo corBojo211 = new CorBojo(null, "corBojo211", "Preto", null,  100.00, 1.0, UnidadeMedida.PARES,  boj53);
        CorBojo corBojo212 = new CorBojo(null, "corBojo212", "Branco", null,  100.00, 1.0, UnidadeMedida.PARES,   boj53);
        CorBojo corBojo213 = new CorBojo(null, "corBojo213", "Amarelo", null,  100.00, 1.0, UnidadeMedida.PARES,   boj53);
        CorBojo corBojo214 = new CorBojo(null, "corBojo214", "Vermelho", null,  100.00, 1.0, UnidadeMedida.PARES,   boj54);
        CorBojo corBojo215 = new CorBojo(null, "corBojo215", "Preto", null,  100.00, 1.0, UnidadeMedida.PARES,   boj54);
        CorBojo corBojo216 = new CorBojo(null, "corBojo216", "Branco", null,  100.00, 1.0, UnidadeMedida.PARES,   boj54);
        CorBojo corBojo217 = new CorBojo(null, "corBojo217", "Amarelo", null,  100.00, 1.0, UnidadeMedida.PARES,   boj54);

        CorAlca corAlca1 = new CorAlca(null, "corAlca1", "Vermelha", null, 100.00, 4.0, UnidadeMedida.PARES, alca1);
        CorAlca corAlca2 = new CorAlca(null, "corAlca2", "Amarela", null, 100.00, 4.0, UnidadeMedida.PARES, alca1);
        CorAlca corAlca3 = new CorAlca(null, "corAlca3", "Vermelha", null, 100.00, 4.0, UnidadeMedida.PARES, alca2);
        CorAlca corAlca4 = new CorAlca(null, "corAlca4", "Amarela", null, 100.00, 4.0, UnidadeMedida.PARES, alca2);

        CorElastico corElastico1 = new CorElastico(null, "corElastico1", "Preto", null, 100.00, 50.00, UnidadeMedida.METROS, elastico1);
        CorElastico corElastico2 = new CorElastico(null, "corElastico2", "Branco", null, 100.00,50.00, UnidadeMedida.METROS, elastico1);
        CorElastico corElastico3 = new CorElastico(null, "corElastico3", "Preto", null, 100.00, 50.00, UnidadeMedida.METROS, elastico2);
        CorElastico corElastico4 = new CorElastico(null, "corElastico4", "Branco", null, 100.00, 50.00, UnidadeMedida.METROS, elastico2);

        CorRenda corRenda1 = new CorRenda(null, "corRenda1", "Mescla Vermelha", null, 100.00, 30.00, UnidadeMedida.METROS,  renda1);
        CorRenda corRenda2 = new CorRenda(null, "corRenda2", "Mescla Amarela", null, 100.00, 30.00, UnidadeMedida.METROS,  renda1);
        CorRenda corRenda3 = new CorRenda(null, "corRenda3", "Mescla Preta", null, 100.00,  30.00, UnidadeMedida.METROS, renda2);
        CorRenda corRenda4 = new CorRenda(null, "corRenda4", "Mescla Verde", null, 100.0, 30.00, UnidadeMedida.METROS, renda2);

        CorLinha corLinha1 = new CorLinha(null, "corLinha1", "Azul", null, 100.00, 1.0, UnidadeMedida.METROS, linha1);
        CorLinha corLinha2 = new CorLinha(null, "corLinha2", "Azul-agua", null, 100.00, 1.0, UnidadeMedida.METROS, linha1);
        CorLinha corLinha3 = new CorLinha(null, "corLinha3", "Azul", null, 100.00, 1.0, UnidadeMedida.METROS, linha2);
        CorLinha corLinha4 = new CorLinha(null, "corLinha4", "Azul-agua", null, 100.00, 1.0, UnidadeMedida.METROS, linha2);


        //instanciado cor entrada
        CorEntradas corEnt1 = new CorEntradas(null, LocalDate.of(2020, Month.MAY, 15), 50.00, 20.00, corTec1);
        CorEntradas corEnt2 = new CorEntradas(null, LocalDate.of(2020, Month.MARCH, 15), 60.00, 30.00, corTec1);
        CorEntradas corEnt3 = new CorEntradas(null, LocalDate.of(2020, Month.DECEMBER, 15), 70.00, 40.00, corTec2);
        CorEntradas corEnt4 = new CorEntradas(null, LocalDate.of(2020, Month.AUGUST, 15), 80.00, 50.00, corTec3);
        CorEntradas corEnt5 = new CorEntradas(null, LocalDate.of(2021, Month.JANUARY, 15), 90.00, 60.00, corTec4);
        CorEntradas corEnt6 = new CorEntradas(null, LocalDate.of(2020, Month.JANUARY, 15), 100.00, 70.00, corTec4);
        CorEntradas corEnt7 = new CorEntradas(null, LocalDate.of(2019, Month.AUGUST, 15), 40.00, 80.00, corTec1);
        CorEntradas corEnt8 = new CorEntradas(null, LocalDate.of(2018, Month.AUGUST, 15), 30.00, 90.00, corTec5);
        CorEntradas corEnt9 = new CorEntradas(null, LocalDate.of(2020, Month.JANUARY, 15), 20.00, 100.00, corTec6);
        CorEntradas corEnt10 = new CorEntradas(null, LocalDate.of(2021, Month.FEBRUARY, 15), 15.00, 90.00, corTec7);
        CorEntradas corEnt11 = new CorEntradas(null, LocalDate.of(2021, Month.MARCH, 15), 18.00, 80.00, corTec8);
        CorEntradas corEnt12 = new CorEntradas(null, LocalDate.of(2021, Month.APRIL, 15), 10.00, 70.00, corTec8);
        CorEntradas corEnt13 = new CorEntradas(null, LocalDate.of(2021, Month.JANUARY, 15), 5.00, 60.00, corTec5);

        CorEntradas corEnt14 = new CorEntradas(null, LocalDate.of(2019, Month.AUGUST, 15), 10.00, 50.00, corColc1);
        CorEntradas corEnt15 = new CorEntradas(null, LocalDate.of(2020, Month.AUGUST, 15), 11.00, 51.00, corColc2);
        CorEntradas corEnt16 = new CorEntradas(null, LocalDate.of(2020, Month.AUGUST, 15), 12.00, 52.00, corColc3);
        CorEntradas corEnt17 = new CorEntradas(null, LocalDate.of(2029, Month.AUGUST, 15), 13.00, 53.00, corColc4);
        CorEntradas corEnt18 = new CorEntradas(null, LocalDate.of(2018, Month.AUGUST, 15), 14.00, 54.00, corColc5);
        CorEntradas corEnt19 = new CorEntradas(null, LocalDate.of(2028, Month.AUGUST, 15), 15.00, 55.00, corColc6);
        CorEntradas corEnt20 = new CorEntradas(null, LocalDate.of(2019, Month.AUGUST, 15), 16.00, 56.00, corColc1);
        CorEntradas corEnt21 = new CorEntradas(null, LocalDate.of(2020, Month.AUGUST, 15), 17.00, 57.00, corColc2);

        //criando caixas de cor bojo

        CaixaBojo caixa1 = new CaixaBojo(null, "Caixa1");
        CaixaBojo caixa2 = new CaixaBojo(null, "Caixa2");
        CaixaBojo caixa3 = new CaixaBojo(null, "Caixa3");
        CaixaBojo caixa4 = new CaixaBojo(null, "Caixa4");
        CaixaBojo caixa5 = new CaixaBojo(null, "Caixa5");
        CaixaBojo caixa6 = new CaixaBojo(null, "Caixa6");
        CaixaBojo caixa7 = new CaixaBojo(null, "Caixa7");
        CaixaBojo caixa8 = new CaixaBojo(null, "Caixa8");
        CaixaBojo caixa9 = new CaixaBojo(null, "Caixa9");
        CaixaBojo caixa10 = new CaixaBojo(null, "Caixa10");
        CaixaBojo caixa11 = new CaixaBojo(null, "Caixa11");
        CaixaBojo caixa12 = new CaixaBojo(null, "Caixa12");

        //associando fornecedor a materia prima
        fornec1.getMateriasPrimas().addAll(Arrays.asList(tec3, tec10, tec12, tec13, tec14));
        fornec2.getMateriasPrimas().addAll(Arrays.asList(tec1, tec4, tec9, tec15, tec16));
        fornec3.getMateriasPrimas().addAll(Arrays.asList(tec2, tec7, tec8));
        fornec4.getMateriasPrimas().addAll(Arrays.asList(tec5, tec6, tec11));

        //associando os materias primas aos seus tipos
        tipo1.getTecidos().addAll(Arrays.asList(tec1, tec10, tec12, tec15, tec16));
        tipo2.getTecidos().addAll(Arrays.asList(tec2, tec11, tec13));
        tipo3.getTecidos().addAll(Arrays.asList(tec3, tec7, tec14));
        tipo4.getTecidos().addAll(Arrays.asList(tec4));
        tipo5.getTecidos().addAll(Arrays.asList(tec5));
        tipo6.getTecidos().addAll(Arrays.asList(tec6));
        tipo7.getTecidos().addAll(Arrays.asList(tec7));
        tipo8.getTecidos().addAll(Arrays.asList(tec8));

        tipColc1.getColchetes().addAll(Arrays.asList(colc1));
        tipColc2.getColchetes().addAll(Arrays.asList(colc2, colc3));

        tipBoj1.getBojos().addAll(Arrays.asList(boj1, boj2, boj3));
        tipBoj2.getBojos().addAll(Arrays.asList(boj4, boj5, boj6));
        tipBoj3.getBojos().addAll(Arrays.asList(boj7, boj8, boj9));
        tipBoj4.getBojos().addAll(Arrays.asList(boj10, boj11, boj12));
        tipBoj5.getBojos().addAll(Arrays.asList(boj13, boj14, boj15));
        tipBoj6.getBojos().addAll(Arrays.asList(boj16, boj17, boj18));
        tipBoj7.getBojos().addAll(Arrays.asList(boj19, boj20, boj21));
        tipBoj8.getBojos().addAll(Arrays.asList(boj22, boj23, boj24));
        tipBoj9.getBojos().addAll(Arrays.asList(boj25, boj26, boj27));
        tipBoj10.getBojos().addAll(Arrays.asList(boj28, boj29, boj30));
        tipBoj11.getBojos().addAll(Arrays.asList(boj31, boj32, boj33));
        tipBoj12.getBojos().addAll(Arrays.asList(boj34, boj35, boj36));
        tipBoj13.getBojos().addAll(Arrays.asList(boj37, boj38, boj39));
        tipBoj14.getBojos().addAll(Arrays.asList(boj40, boj41, boj42));
        tipBoj15.getBojos().addAll(Arrays.asList(boj43, boj44, boj45));
        tipBoj16.getBojos().addAll(Arrays.asList(boj46, boj47, boj48));
        tipBoj17.getBojos().addAll(Arrays.asList(boj49, boj50, boj51));
        tipBoj18.getBojos().addAll(Arrays.asList(boj52, boj53, boj54));

        tipoLinha1.getLinhas().addAll(Arrays.asList(linha1, linha3, linha5, linha7));
        tipoLinha2.getLinhas().addAll(Arrays.asList(linha2, linha4, linha6));

        tipoRenda1.getRendas().addAll(Arrays.asList(renda1, renda3, renda5, renda7));
        tipoRenda2.getRendas().addAll(Arrays.asList(renda2, renda4, renda6));

        tipoElastico1.getElasticos().addAll(Arrays.asList(elastico1, elastico3, elastico5, elastico7));
        tipoElastico2.getElasticos().addAll(Arrays.asList(elastico2, elastico4, elastico6));

        tipoAlca1.getAlcas().addAll(Arrays.asList(alca1, alca3, alca5, alca7));
        tipoAlca2.getAlcas().addAll(Arrays.asList(alca2, alca4, alca6));



        //associando os tecidos as suas classes
        tecClass1.getTecidos().addAll(Arrays.asList(tec4, tec15, tec16));
        tecClass2.getTecidos().addAll(Arrays.asList(tec1, tec2, tec5, tec10, tec11, tec12, tec13));
        tecClass3.getTecidos().addAll(Arrays.asList(tec3, tec7, tec14));
        tecClass4.getTecidos().addAll(Arrays.asList(tec6, tec8, tec9));

        //associando as materiasprimas as suas cores
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

        colc1.getCores().addAll(Arrays.asList(corColc1, corColc2, corColc3));
        colc2.getCores().addAll(Arrays.asList(corColc4, corColc5, corColc6));

        boj1.getCores().addAll(Arrays.asList(corBojo2, corBojo3, corBojo4, corBojo5));
        boj2.getCores().addAll(Arrays.asList(corBojo6, corBojo7, corBojo8, corBojo9));
        boj3.getCores().addAll(Arrays.asList(corBojo10, corBojo11, corBojo12, corBojo13));
        boj4.getCores().addAll(Arrays.asList(corBojo14, corBojo15, corBojo16, corBojo17));
        boj5.getCores().addAll(Arrays.asList(corBojo18, corBojo19, corBojo20, corBojo21));
        boj6.getCores().addAll(Arrays.asList(corBojo22, corBojo23, corBojo24, corBojo25));
        boj7.getCores().addAll(Arrays.asList(corBojo26, corBojo27, corBojo28, corBojo29));
        boj8.getCores().addAll(Arrays.asList(corBojo30, corBojo31, corBojo32, corBojo33));
        boj9.getCores().addAll(Arrays.asList(corBojo34, corBojo35, corBojo36, corBojo37));
        boj10.getCores().addAll(Arrays.asList(corBojo38, corBojo39, corBojo40, corBojo41));
        boj11.getCores().addAll(Arrays.asList(corBojo42, corBojo43, corBojo44, corBojo45));
        boj12.getCores().addAll(Arrays.asList(corBojo46, corBojo47, corBojo48, corBojo49));
        boj13.getCores().addAll(Arrays.asList(corBojo50, corBojo51, corBojo52, corBojo53));
        boj14.getCores().addAll(Arrays.asList(corBojo54, corBojo55, corBojo56, corBojo57));
        boj15.getCores().addAll(Arrays.asList(corBojo58, corBojo59, corBojo60, corBojo61));
        boj16.getCores().addAll(Arrays.asList(corBojo62, corBojo63, corBojo64, corBojo65));
        boj17.getCores().addAll(Arrays.asList(corBojo66, corBojo67, corBojo68, corBojo69));
        boj18.getCores().addAll(Arrays.asList(corBojo70, corBojo71, corBojo72, corBojo73));
        boj19.getCores().addAll(Arrays.asList(corBojo74, corBojo75, corBojo76, corBojo77));
        boj20.getCores().addAll(Arrays.asList(corBojo78, corBojo79, corBojo80, corBojo81));
        boj21.getCores().addAll(Arrays.asList(corBojo82, corBojo83, corBojo84, corBojo85));
        boj22.getCores().addAll(Arrays.asList(corBojo86, corBojo87, corBojo88, corBojo89));
        boj23.getCores().addAll(Arrays.asList(corBojo90, corBojo91, corBojo92, corBojo93));
        boj24.getCores().addAll(Arrays.asList(corBojo94, corBojo95, corBojo96, corBojo97));
        boj25.getCores().addAll(Arrays.asList(corBojo98, corBojo99, corBojo100, corBojo101));
        boj26.getCores().addAll(Arrays.asList(corBojo102, corBojo103, corBojo104, corBojo105));
        boj27.getCores().addAll(Arrays.asList(corBojo106, corBojo107, corBojo108, corBojo109));
        boj28.getCores().addAll(Arrays.asList(corBojo110, corBojo111, corBojo112, corBojo113));
        boj29.getCores().addAll(Arrays.asList(corBojo114, corBojo115, corBojo116, corBojo117));
        boj30.getCores().addAll(Arrays.asList(corBojo118, corBojo119, corBojo120, corBojo121));
        boj31.getCores().addAll(Arrays.asList(corBojo122, corBojo123, corBojo124, corBojo125));
        boj32.getCores().addAll(Arrays.asList(corBojo126, corBojo127, corBojo128, corBojo129));
        boj33.getCores().addAll(Arrays.asList(corBojo130, corBojo131, corBojo132, corBojo133));
        boj34.getCores().addAll(Arrays.asList(corBojo134, corBojo135, corBojo136, corBojo137));
        boj35.getCores().addAll(Arrays.asList(corBojo138, corBojo139, corBojo140, corBojo141));
        boj36.getCores().addAll(Arrays.asList(corBojo142, corBojo143, corBojo144, corBojo145));
        boj37.getCores().addAll(Arrays.asList(corBojo146, corBojo147, corBojo148, corBojo149));
        boj38.getCores().addAll(Arrays.asList(corBojo150, corBojo151, corBojo152, corBojo153));
        boj39.getCores().addAll(Arrays.asList(corBojo154, corBojo155, corBojo156, corBojo157));
        boj40.getCores().addAll(Arrays.asList(corBojo158, corBojo159, corBojo160, corBojo161));
        boj41.getCores().addAll(Arrays.asList(corBojo162, corBojo163, corBojo164, corBojo165));
        boj42.getCores().addAll(Arrays.asList(corBojo166, corBojo167, corBojo168, corBojo169));
        boj43.getCores().addAll(Arrays.asList(corBojo170, corBojo171, corBojo172, corBojo173));
        boj44.getCores().addAll(Arrays.asList(corBojo174, corBojo175, corBojo176, corBojo177));
        boj45.getCores().addAll(Arrays.asList(corBojo178, corBojo179, corBojo180, corBojo181));
        boj46.getCores().addAll(Arrays.asList(corBojo182, corBojo183, corBojo184, corBojo185));
        boj47.getCores().addAll(Arrays.asList(corBojo186, corBojo187, corBojo188, corBojo189));
        boj48.getCores().addAll(Arrays.asList(corBojo190, corBojo191, corBojo192, corBojo193));
        boj49.getCores().addAll(Arrays.asList(corBojo194, corBojo195, corBojo196, corBojo197));
        boj50.getCores().addAll(Arrays.asList(corBojo198, corBojo199, corBojo200, corBojo201));
        boj51.getCores().addAll(Arrays.asList(corBojo202, corBojo203, corBojo204, corBojo205));
        boj52.getCores().addAll(Arrays.asList(corBojo206, corBojo207, corBojo208, corBojo209));
        boj53.getCores().addAll(Arrays.asList(corBojo210, corBojo211, corBojo212, corBojo213));
        boj54.getCores().addAll(Arrays.asList(corBojo214, corBojo215, corBojo216, corBojo217));

        renda1.getCores().addAll(Arrays.asList(corRenda1, corRenda2));
        renda2.getCores().addAll(Arrays.asList(corRenda3, corRenda4));

        elastico1.getCores().addAll(Arrays.asList(corElastico1, corElastico2));
        elastico2.getCores().addAll(Arrays.asList(corElastico3, corElastico4));

        linha1.getCores().addAll(Arrays.asList(corLinha1, corLinha2));
        linha2.getCores().addAll(Arrays.asList(corLinha3, corLinha4));

        alca1.getCores().addAll(Arrays.asList(corAlca1, corAlca2));
        alca2.getCores().addAll(Arrays.asList(corAlca3, corAlca4));

        //associando as cores de tecido as suas entradas
        corTec1.getEntradas().addAll(Arrays.asList(corEnt1, corEnt2, corEnt7));
        corTec2.getEntradas().addAll(Arrays.asList(corEnt3));
        corTec3.getEntradas().addAll(Arrays.asList(corEnt4));
        corTec4.getEntradas().addAll(Arrays.asList(corEnt5, corEnt6));
        corTec5.getEntradas().addAll(Arrays.asList(corEnt8, corEnt13));
        corTec6.getEntradas().addAll(Arrays.asList(corEnt9));
        corTec7.getEntradas().addAll(Arrays.asList(corEnt10));
        corTec8.getEntradas().addAll(Arrays.asList(corEnt11, corEnt12));

        corColc1.getEntradas().addAll(Arrays.asList(corEnt14, corEnt20));
        corColc2.getEntradas().addAll(Arrays.asList(corEnt15, corEnt21));
        corColc3.getEntradas().addAll(Arrays.asList(corEnt16));
        corColc4.getEntradas().addAll(Arrays.asList(corEnt17));
        corColc5.getEntradas().addAll(Arrays.asList(corEnt18));
        corColc6.getEntradas().addAll(Arrays.asList(corEnt19));

        //associando as caixas de bojos a suas cores
        caixa1.getCoresArmazenadas().addAll(Arrays.asList(corBojo2, corBojo3, corBojo4, corBojo5, corBojo6, corBojo7,
                corBojo8, corBojo9, corBojo10, corBojo11, corBojo12, corBojo13, corBojo14, corBojo15, corBojo16,
                corBojo17, corBojo18, corBojo19, corBojo20, corBojo21, corBojo22, corBojo23, corBojo24, corBojo25,
                corBojo26, corBojo27, corBojo28, corBojo29, corBojo30, corBojo31));
        caixa2.getCoresArmazenadas().addAll(Arrays.asList(corBojo32, corBojo33, corBojo34, corBojo35, corBojo36,
                corBojo37, corBojo38, corBojo39, corBojo40, corBojo41, corBojo42, corBojo43, corBojo44, corBojo45,
                corBojo46, corBojo47, corBojo48, corBojo49, corBojo50, corBojo51, corBojo52, corBojo53, corBojo54,
                corBojo55, corBojo56, corBojo57, corBojo58, corBojo59, corBojo60, corBojo61));
        caixa3.getCoresArmazenadas().addAll(Arrays.asList(corBojo62, corBojo63, corBojo64, corBojo65, corBojo66,
                corBojo67, corBojo68, corBojo69, corBojo70, corBojo71, corBojo72, corBojo73, corBojo74, corBojo75,
                corBojo76, corBojo77, corBojo78, corBojo79, corBojo80, corBojo81, corBojo82, corBojo83, corBojo84,
                corBojo85, corBojo86, corBojo87, corBojo88, corBojo89, corBojo90, corBojo91));
        caixa4.getCoresArmazenadas().addAll(Arrays.asList(corBojo92, corBojo93, corBojo94, corBojo95, corBojo96,
                corBojo97, corBojo98, corBojo99, corBojo100, corBojo101, corBojo102, corBojo103, corBojo104, corBojo105,
                corBojo106, corBojo107, corBojo108, corBojo109, corBojo110, corBojo111, corBojo112, corBojo113,
                corBojo114, corBojo115, corBojo116, corBojo117, corBojo118, corBojo119, corBojo120, corBojo121));
        caixa5.getCoresArmazenadas().addAll(Arrays.asList(corBojo122, corBojo123, corBojo124, corBojo125, corBojo126,
                corBojo127, corBojo128, corBojo129, corBojo130, corBojo131, corBojo132, corBojo133, corBojo134,
                corBojo135, corBojo136, corBojo137, corBojo138, corBojo139, corBojo140, corBojo141, corBojo142,
                corBojo143, corBojo144, corBojo145, corBojo146, corBojo147, corBojo148, corBojo149, corBojo150,
                corBojo151));
        caixa6.getCoresArmazenadas().addAll(Arrays.asList(corBojo152, corBojo153, corBojo154, corBojo155, corBojo156,
                corBojo157, corBojo158, corBojo159, corBojo160, corBojo161, corBojo162, corBojo163, corBojo164,
                corBojo165, corBojo166, corBojo167, corBojo168, corBojo169, corBojo170, corBojo171, corBojo172,
                corBojo173, corBojo174, corBojo175, corBojo176, corBojo177, corBojo178, corBojo179, corBojo180,
                corBojo181));
        caixa7.getCoresArmazenadas().addAll(Arrays.asList(corBojo182, corBojo183, corBojo184, corBojo185, corBojo186,
                corBojo187, corBojo188, corBojo189, corBojo190, corBojo191, corBojo192, corBojo193, corBojo194,
                corBojo195, corBojo196, corBojo197, corBojo198, corBojo199, corBojo200, corBojo201, corBojo202,
                corBojo203, corBojo204, corBojo205, corBojo206, corBojo207, corBojo208, corBojo209, corBojo210,
                corBojo211));
        caixa8.getCoresArmazenadas().addAll(Arrays.asList(corBojo212, corBojo213, corBojo214, corBojo215, corBojo216,
                corBojo217, corBojo2, corBojo3, corBojo4, corBojo5, corBojo6, corBojo7, corBojo8, corBojo9, corBojo10,
                corBojo11, corBojo12, corBojo13, corBojo14, corBojo15, corBojo16, corBojo17, corBojo18, corBojo19,
                corBojo20, corBojo21, corBojo22, corBojo23, corBojo24, corBojo25));

        //associando as cores de bojos a suas caixas

        corBojo2.getCaixas().addAll(Arrays.asList(caixa1, caixa8));
        corBojo3.getCaixas().addAll(Arrays.asList(caixa1, caixa8));
        corBojo4.getCaixas().addAll(Arrays.asList(caixa1, caixa8));
        corBojo5.getCaixas().addAll(Arrays.asList(caixa1, caixa8));
        corBojo6.getCaixas().addAll(Arrays.asList(caixa1, caixa8));
        corBojo7.getCaixas().addAll(Arrays.asList(caixa1, caixa8));
        corBojo8.getCaixas().addAll(Arrays.asList(caixa1, caixa8));
        corBojo9.getCaixas().addAll(Arrays.asList(caixa1, caixa8));
        corBojo10.getCaixas().addAll(Arrays.asList(caixa1, caixa8));
        corBojo11.getCaixas().addAll(Arrays.asList(caixa1, caixa8));
        corBojo12.getCaixas().addAll(Arrays.asList(caixa1, caixa8));
        corBojo13.getCaixas().addAll(Arrays.asList(caixa1, caixa8));
        corBojo14.getCaixas().addAll(Arrays.asList(caixa1, caixa8));
        corBojo15.getCaixas().addAll(Arrays.asList(caixa1, caixa8));
        corBojo16.getCaixas().addAll(Arrays.asList(caixa1, caixa8));
        corBojo17.getCaixas().addAll(Arrays.asList(caixa1, caixa8));
        corBojo18.getCaixas().addAll(Arrays.asList(caixa1, caixa8));
        corBojo19.getCaixas().addAll(Arrays.asList(caixa1, caixa8));
        corBojo20.getCaixas().addAll(Arrays.asList(caixa1, caixa8));
        corBojo21.getCaixas().addAll(Arrays.asList(caixa1, caixa8));
        corBojo22.getCaixas().addAll(Arrays.asList(caixa1, caixa8));
        corBojo23.getCaixas().addAll(Arrays.asList(caixa1, caixa8));
        corBojo24.getCaixas().addAll(Arrays.asList(caixa1, caixa8));
        corBojo25.getCaixas().addAll(Arrays.asList(caixa1, caixa8));
        corBojo26.getCaixas().addAll(Arrays.asList(caixa1));
        corBojo27.getCaixas().addAll(Arrays.asList(caixa1));
        corBojo28.getCaixas().addAll(Arrays.asList(caixa1));
        corBojo29.getCaixas().addAll(Arrays.asList(caixa1));
        corBojo30.getCaixas().addAll(Arrays.asList(caixa1));
        corBojo31.getCaixas().addAll(Arrays.asList(caixa1));
        corBojo32.getCaixas().addAll(Arrays.asList(caixa2));
        corBojo33.getCaixas().addAll(Arrays.asList(caixa2));
        corBojo34.getCaixas().addAll(Arrays.asList(caixa2));
        corBojo35.getCaixas().addAll(Arrays.asList(caixa2));
        corBojo36.getCaixas().addAll(Arrays.asList(caixa2));
        corBojo37.getCaixas().addAll(Arrays.asList(caixa2));
        corBojo38.getCaixas().addAll(Arrays.asList(caixa2));
        corBojo39.getCaixas().addAll(Arrays.asList(caixa2));
        corBojo40.getCaixas().addAll(Arrays.asList(caixa2));
        corBojo41.getCaixas().addAll(Arrays.asList(caixa2));
        corBojo42.getCaixas().addAll(Arrays.asList(caixa2));
        corBojo43.getCaixas().addAll(Arrays.asList(caixa2));
        corBojo44.getCaixas().addAll(Arrays.asList(caixa2));
        corBojo45.getCaixas().addAll(Arrays.asList(caixa2));
        corBojo46.getCaixas().addAll(Arrays.asList(caixa2));
        corBojo47.getCaixas().addAll(Arrays.asList(caixa2));
        corBojo48.getCaixas().addAll(Arrays.asList(caixa2));
        corBojo49.getCaixas().addAll(Arrays.asList(caixa2));
        corBojo50.getCaixas().addAll(Arrays.asList(caixa2));
        corBojo51.getCaixas().addAll(Arrays.asList(caixa2));
        corBojo52.getCaixas().addAll(Arrays.asList(caixa2));
        corBojo53.getCaixas().addAll(Arrays.asList(caixa2));
        corBojo54.getCaixas().addAll(Arrays.asList(caixa2));
        corBojo55.getCaixas().addAll(Arrays.asList(caixa2));
        corBojo56.getCaixas().addAll(Arrays.asList(caixa2));
        corBojo57.getCaixas().addAll(Arrays.asList(caixa2));
        corBojo58.getCaixas().addAll(Arrays.asList(caixa2));
        corBojo59.getCaixas().addAll(Arrays.asList(caixa2));
        corBojo60.getCaixas().addAll(Arrays.asList(caixa2));
        corBojo61.getCaixas().addAll(Arrays.asList(caixa2));
        corBojo62.getCaixas().addAll(Arrays.asList(caixa3));
        corBojo63.getCaixas().addAll(Arrays.asList(caixa3));
        corBojo64.getCaixas().addAll(Arrays.asList(caixa3));
        corBojo65.getCaixas().addAll(Arrays.asList(caixa3));
        corBojo66.getCaixas().addAll(Arrays.asList(caixa3));
        corBojo67.getCaixas().addAll(Arrays.asList(caixa3));
        corBojo68.getCaixas().addAll(Arrays.asList(caixa3));
        corBojo69.getCaixas().addAll(Arrays.asList(caixa3));
        corBojo70.getCaixas().addAll(Arrays.asList(caixa3));
        corBojo71.getCaixas().addAll(Arrays.asList(caixa3));
        corBojo72.getCaixas().addAll(Arrays.asList(caixa3));
        corBojo73.getCaixas().addAll(Arrays.asList(caixa3));
        corBojo74.getCaixas().addAll(Arrays.asList(caixa3));
        corBojo75.getCaixas().addAll(Arrays.asList(caixa3));
        corBojo76.getCaixas().addAll(Arrays.asList(caixa3));
        corBojo77.getCaixas().addAll(Arrays.asList(caixa3));
        corBojo78.getCaixas().addAll(Arrays.asList(caixa3));
        corBojo79.getCaixas().addAll(Arrays.asList(caixa3));
        corBojo80.getCaixas().addAll(Arrays.asList(caixa3));
        corBojo81.getCaixas().addAll(Arrays.asList(caixa3));
        corBojo82.getCaixas().addAll(Arrays.asList(caixa3));
        corBojo83.getCaixas().addAll(Arrays.asList(caixa3));
        corBojo84.getCaixas().addAll(Arrays.asList(caixa3));
        corBojo85.getCaixas().addAll(Arrays.asList(caixa3));
        corBojo86.getCaixas().addAll(Arrays.asList(caixa3));
        corBojo87.getCaixas().addAll(Arrays.asList(caixa3));
        corBojo88.getCaixas().addAll(Arrays.asList(caixa3));
        corBojo89.getCaixas().addAll(Arrays.asList(caixa3));
        corBojo90.getCaixas().addAll(Arrays.asList(caixa3));
        corBojo91.getCaixas().addAll(Arrays.asList(caixa3));
        corBojo92.getCaixas().addAll(Arrays.asList(caixa4));
        corBojo93.getCaixas().addAll(Arrays.asList(caixa4));
        corBojo94.getCaixas().addAll(Arrays.asList(caixa4));
        corBojo95.getCaixas().addAll(Arrays.asList(caixa4));
        corBojo96.getCaixas().addAll(Arrays.asList(caixa4));
        corBojo97.getCaixas().addAll(Arrays.asList(caixa4));
        corBojo98.getCaixas().addAll(Arrays.asList(caixa4));
        corBojo99.getCaixas().addAll(Arrays.asList(caixa4));
        corBojo100.getCaixas().addAll(Arrays.asList(caixa4));
        corBojo101.getCaixas().addAll(Arrays.asList(caixa4));
        corBojo102.getCaixas().addAll(Arrays.asList(caixa4));
        corBojo103.getCaixas().addAll(Arrays.asList(caixa4));
        corBojo104.getCaixas().addAll(Arrays.asList(caixa4));
        corBojo105.getCaixas().addAll(Arrays.asList(caixa4));
        corBojo106.getCaixas().addAll(Arrays.asList(caixa4));
        corBojo107.getCaixas().addAll(Arrays.asList(caixa4));
        corBojo108.getCaixas().addAll(Arrays.asList(caixa4));
        corBojo109.getCaixas().addAll(Arrays.asList(caixa4));
        corBojo110.getCaixas().addAll(Arrays.asList(caixa4));
        corBojo111.getCaixas().addAll(Arrays.asList(caixa4));
        corBojo112.getCaixas().addAll(Arrays.asList(caixa4));
        corBojo113.getCaixas().addAll(Arrays.asList(caixa4));
        corBojo114.getCaixas().addAll(Arrays.asList(caixa4));
        corBojo115.getCaixas().addAll(Arrays.asList(caixa4));
        corBojo116.getCaixas().addAll(Arrays.asList(caixa4));
        corBojo117.getCaixas().addAll(Arrays.asList(caixa4));
        corBojo118.getCaixas().addAll(Arrays.asList(caixa4));
        corBojo119.getCaixas().addAll(Arrays.asList(caixa4));
        corBojo120.getCaixas().addAll(Arrays.asList(caixa4));
        corBojo121.getCaixas().addAll(Arrays.asList(caixa4));
        corBojo122.getCaixas().addAll(Arrays.asList(caixa5));
        corBojo123.getCaixas().addAll(Arrays.asList(caixa5));
        corBojo124.getCaixas().addAll(Arrays.asList(caixa5));
        corBojo125.getCaixas().addAll(Arrays.asList(caixa5));
        corBojo126.getCaixas().addAll(Arrays.asList(caixa5));
        corBojo127.getCaixas().addAll(Arrays.asList(caixa5));
        corBojo128.getCaixas().addAll(Arrays.asList(caixa5));
        corBojo129.getCaixas().addAll(Arrays.asList(caixa5));
        corBojo130.getCaixas().addAll(Arrays.asList(caixa5));
        corBojo131.getCaixas().addAll(Arrays.asList(caixa5));
        corBojo132.getCaixas().addAll(Arrays.asList(caixa5));
        corBojo133.getCaixas().addAll(Arrays.asList(caixa5));
        corBojo134.getCaixas().addAll(Arrays.asList(caixa5));
        corBojo135.getCaixas().addAll(Arrays.asList(caixa5));
        corBojo136.getCaixas().addAll(Arrays.asList(caixa5));
        corBojo137.getCaixas().addAll(Arrays.asList(caixa5));
        corBojo138.getCaixas().addAll(Arrays.asList(caixa5));
        corBojo139.getCaixas().addAll(Arrays.asList(caixa5));
        corBojo140.getCaixas().addAll(Arrays.asList(caixa5));
        corBojo141.getCaixas().addAll(Arrays.asList(caixa5));
        corBojo142.getCaixas().addAll(Arrays.asList(caixa5));
        corBojo143.getCaixas().addAll(Arrays.asList(caixa5));
        corBojo144.getCaixas().addAll(Arrays.asList(caixa5));
        corBojo145.getCaixas().addAll(Arrays.asList(caixa5));
        corBojo146.getCaixas().addAll(Arrays.asList(caixa5));
        corBojo147.getCaixas().addAll(Arrays.asList(caixa5));
        corBojo148.getCaixas().addAll(Arrays.asList(caixa5));
        corBojo149.getCaixas().addAll(Arrays.asList(caixa5));
        corBojo150.getCaixas().addAll(Arrays.asList(caixa5));
        corBojo151.getCaixas().addAll(Arrays.asList(caixa5));
        corBojo152.getCaixas().addAll(Arrays.asList(caixa6));
        corBojo153.getCaixas().addAll(Arrays.asList(caixa6));
        corBojo154.getCaixas().addAll(Arrays.asList(caixa6));
        corBojo155.getCaixas().addAll(Arrays.asList(caixa6));
        corBojo156.getCaixas().addAll(Arrays.asList(caixa6));
        corBojo157.getCaixas().addAll(Arrays.asList(caixa6));
        corBojo158.getCaixas().addAll(Arrays.asList(caixa6));
        corBojo159.getCaixas().addAll(Arrays.asList(caixa6));
        corBojo160.getCaixas().addAll(Arrays.asList(caixa6));
        corBojo161.getCaixas().addAll(Arrays.asList(caixa6));
        corBojo162.getCaixas().addAll(Arrays.asList(caixa6));
        corBojo163.getCaixas().addAll(Arrays.asList(caixa6));
        corBojo164.getCaixas().addAll(Arrays.asList(caixa6));
        corBojo165.getCaixas().addAll(Arrays.asList(caixa6));
        corBojo166.getCaixas().addAll(Arrays.asList(caixa6));
        corBojo167.getCaixas().addAll(Arrays.asList(caixa6));
        corBojo168.getCaixas().addAll(Arrays.asList(caixa6));
        corBojo169.getCaixas().addAll(Arrays.asList(caixa6));
        corBojo170.getCaixas().addAll(Arrays.asList(caixa6));
        corBojo171.getCaixas().addAll(Arrays.asList(caixa6));
        corBojo172.getCaixas().addAll(Arrays.asList(caixa6));
        corBojo173.getCaixas().addAll(Arrays.asList(caixa6));
        corBojo174.getCaixas().addAll(Arrays.asList(caixa6));
        corBojo175.getCaixas().addAll(Arrays.asList(caixa6));
        corBojo176.getCaixas().addAll(Arrays.asList(caixa6));
        corBojo177.getCaixas().addAll(Arrays.asList(caixa6));
        corBojo178.getCaixas().addAll(Arrays.asList(caixa6));
        corBojo179.getCaixas().addAll(Arrays.asList(caixa6));
        corBojo180.getCaixas().addAll(Arrays.asList(caixa6));
        corBojo181.getCaixas().addAll(Arrays.asList(caixa6));
        corBojo182.getCaixas().addAll(Arrays.asList(caixa7));
        corBojo183.getCaixas().addAll(Arrays.asList(caixa7));
        corBojo184.getCaixas().addAll(Arrays.asList(caixa7));
        corBojo185.getCaixas().addAll(Arrays.asList(caixa7));
        corBojo186.getCaixas().addAll(Arrays.asList(caixa7));
        corBojo187.getCaixas().addAll(Arrays.asList(caixa7));
        corBojo188.getCaixas().addAll(Arrays.asList(caixa7));
        corBojo189.getCaixas().addAll(Arrays.asList(caixa7));
        corBojo190.getCaixas().addAll(Arrays.asList(caixa7));
        corBojo191.getCaixas().addAll(Arrays.asList(caixa7));
        corBojo192.getCaixas().addAll(Arrays.asList(caixa7));
        corBojo193.getCaixas().addAll(Arrays.asList(caixa7));
        corBojo194.getCaixas().addAll(Arrays.asList(caixa7));
        corBojo195.getCaixas().addAll(Arrays.asList(caixa7));
        corBojo196.getCaixas().addAll(Arrays.asList(caixa7));
        corBojo197.getCaixas().addAll(Arrays.asList(caixa7));
        corBojo198.getCaixas().addAll(Arrays.asList(caixa7));
        corBojo199.getCaixas().addAll(Arrays.asList(caixa7));
        corBojo200.getCaixas().addAll(Arrays.asList(caixa7));
        corBojo201.getCaixas().addAll(Arrays.asList(caixa7));
        corBojo202.getCaixas().addAll(Arrays.asList(caixa7));
        corBojo203.getCaixas().addAll(Arrays.asList(caixa7));
        corBojo204.getCaixas().addAll(Arrays.asList(caixa7));
        corBojo205.getCaixas().addAll(Arrays.asList(caixa7));
        corBojo206.getCaixas().addAll(Arrays.asList(caixa7));
        corBojo207.getCaixas().addAll(Arrays.asList(caixa7));
        corBojo208.getCaixas().addAll(Arrays.asList(caixa7));
        corBojo209.getCaixas().addAll(Arrays.asList(caixa7));
        corBojo210.getCaixas().addAll(Arrays.asList(caixa7));
        corBojo211.getCaixas().addAll(Arrays.asList(caixa7));
        corBojo212.getCaixas().addAll(Arrays.asList(caixa8));
        corBojo213.getCaixas().addAll(Arrays.asList(caixa8));
        corBojo214.getCaixas().addAll(Arrays.asList(caixa8));
        corBojo215.getCaixas().addAll(Arrays.asList(caixa8));
        corBojo216.getCaixas().addAll(Arrays.asList(caixa8));
        corBojo217.getCaixas().addAll(Arrays.asList(caixa8));


        //persistindo o admin
        usuarioRepository.saveAll(Arrays.asList(admin));

        //persistindo cidades
        cidadeRepository.saveAll(Arrays.asList(cidade1, cidade2));

        //persistindo dados de Contato
        contatoRepository.saveAll(Arrays.asList(cont1, cont2, cont3, cont4, cont5, cont6));

        //persistindo dados de Telefone
        telefoneRepository.saveAll(Arrays.asList(tel1, tel2, tel3, tel4, tel5, tel6, tel7));

        //persistindo dados de fornecedor
        fornecedorRepository.saveAll(Arrays.asList(fornec1, fornec2, fornec3, fornec4));

        //persistindo classe de tecido
        tecidoClasseRepository.saveAll(Arrays.asList(tecClass1, tecClass2, tecClass3, tecClass4));

        //persistindo tipos
        tipoTecidoRepository.saveAll(Arrays.asList(tipo1, tipo2, tipo3, tipo4, tipo5, tipo6, tipo7, tipo8));
        tipoColcheteRepository.saveAll(Arrays.asList(tipColc1, tipColc2, tipColc3));
        tipoBojoRepository.saveAll(Arrays.asList(tipBoj1, tipBoj2, tipBoj3, tipBoj4, tipBoj5, tipBoj6, tipBoj7,
                tipBoj8, tipBoj9, tipBoj10, tipBoj11, tipBoj12, tipBoj13, tipBoj14, tipBoj15, tipBoj16, tipBoj17,
                tipBoj18));
        tipoAlcaRepository.saveAll(Arrays.asList(tipoAlca1, tipoAlca2));
        tipoRendaRepository.saveAll(Arrays.asList(tipoRenda1, tipoRenda2));
        tipoElasticoRepository.saveAll(Arrays.asList(tipoElastico1, tipoElastico2));
        tipoLinhaRepository.saveAll(Arrays.asList(tipoLinha1, tipoLinha2));

        //persistindo composicao
        composicaoRepository.saveAll(Arrays.asList(comp1, comp2, comp3));

        fioRepository.saveAll(Arrays.asList(fio1, fio2, fio3, fio4, fio5));

        composicaoFioRepository.saveAll(Arrays.asList(composicaoFio1, composicaoFio2, composicaoFio3, composicaoFio4,
                composicaoFio5, composicaoFio6));

        modoLavarRepository.saveAll(Arrays.asList(modoLavar1, modoLavar2, modoLavar3, modoLavar4, modoLavar5));

        //persistindo materias primas
        tecidoRepository.saveAll(Arrays.asList(tec1, tec2, tec3, tec4, tec5, tec6, tec7, tec8,
                tec9, tec10, tec11, tec12, tec13, tec14, tec15, tec16));

        colcheteRepository.saveAll(Arrays.asList(colc1, colc2, colc3));

        bojoRepository.saveAll(Arrays.asList(boj1, boj2, boj3, boj4, boj5, boj6, boj7, boj8, boj9, boj10, boj11, boj12,
                boj13, boj14, boj15, boj16, boj17, boj18, boj19, boj20, boj21, boj22, boj23, boj24, boj25, boj26, boj27,
                boj28, boj29, boj30, boj31, boj32, boj33, boj34, boj35, boj36, boj37, boj38, boj39, boj40, boj41, boj42,
                boj43, boj44, boj45, boj46, boj47, boj48, boj49, boj50, boj51, boj52, boj53, boj54));

        alcaRepository.saveAll(Arrays.asList(alca1, alca2, alca3, alca4, alca5, alca6, alca7));

        elasticoRepository.saveAll(Arrays.asList(elastico1, elastico2, elastico3, elastico4, elastico5, elastico6,
                elastico7));

        linhaRepository.saveAll(Arrays.asList(linha1, linha2, linha3, linha4, linha5, linha6, linha7));

        rendaRepository.saveAll(Arrays.asList(renda1, renda2, renda3, renda4, renda5, renda6, renda7));

        //persistindo cores
        corTecidoRepository.saveAll(Arrays.asList(corTec1, corTec2, corTec3, corTec4, corTec5, corTec6,
                corTec7, corTec8, corTec9, corTec10, corTec11, corTec12, corTec13, corTec14,
                corTec15, corTec16, corTec17, corTec18, corTec19, corTec20, corTec21, corTec22,
                corTec23, corTec24, corTec25, corTec26, corTec27, corTec28, corTec29, corTec30));

        corColcheteRepository.saveAll(Arrays.asList(corColc1, corColc2, corColc3, corColc4, corColc5, corColc6));

        corBojoRepository.saveAll(Arrays.asList(corBojo2, corBojo3, corBojo4, corBojo5, corBojo6, corBojo7, corBojo8,
                corBojo9, corBojo10, corBojo11, corBojo12, corBojo13, corBojo14, corBojo15, corBojo16, corBojo17,
                corBojo18, corBojo19, corBojo20, corBojo21, corBojo22, corBojo23, corBojo24, corBojo25, corBojo26,
                corBojo27, corBojo28, corBojo29, corBojo30, corBojo31, corBojo32, corBojo33, corBojo34, corBojo35,
                corBojo36, corBojo37, corBojo38, corBojo39, corBojo40, corBojo41, corBojo42, corBojo43, corBojo44,
                corBojo45, corBojo46, corBojo47, corBojo48, corBojo49, corBojo50, corBojo51, corBojo52, corBojo53,
                corBojo54, corBojo55, corBojo56, corBojo57, corBojo58, corBojo59, corBojo60, corBojo61, corBojo62,
                corBojo63, corBojo64, corBojo65, corBojo66, corBojo67, corBojo68, corBojo69, corBojo70, corBojo71,
                corBojo72, corBojo73, corBojo74, corBojo75, corBojo76, corBojo77, corBojo78, corBojo79, corBojo80,
                corBojo81, corBojo82, corBojo83, corBojo84, corBojo85, corBojo86, corBojo87, corBojo88, corBojo89,
                corBojo90, corBojo91, corBojo92, corBojo93, corBojo94, corBojo95, corBojo96, corBojo97, corBojo98,
                corBojo99, corBojo100, corBojo101, corBojo102, corBojo103, corBojo104, corBojo105, corBojo106,
                corBojo107, corBojo108, corBojo109, corBojo110, corBojo111, corBojo112, corBojo113, corBojo114,
                corBojo115, corBojo116, corBojo117, corBojo118, corBojo119, corBojo120, corBojo121, corBojo122,
                corBojo123, corBojo124, corBojo125, corBojo126, corBojo127, corBojo128, corBojo129, corBojo130,
                corBojo131, corBojo132, corBojo133, corBojo134, corBojo135, corBojo136, corBojo137, corBojo138,
                corBojo139, corBojo140, corBojo141, corBojo142, corBojo143, corBojo144, corBojo145, corBojo146,
                corBojo147, corBojo148, corBojo149, corBojo150, corBojo151, corBojo152, corBojo153, corBojo154,
                corBojo155, corBojo156, corBojo157, corBojo158, corBojo159, corBojo160, corBojo161, corBojo162,
                corBojo163, corBojo164, corBojo165, corBojo166, corBojo167, corBojo168, corBojo169, corBojo170,
                corBojo171, corBojo172, corBojo173, corBojo174, corBojo175, corBojo176, corBojo177, corBojo178,
                corBojo179, corBojo180, corBojo181, corBojo182, corBojo183, corBojo184, corBojo185, corBojo186,
                corBojo187, corBojo188, corBojo189, corBojo190, corBojo191, corBojo192, corBojo193, corBojo194,
                corBojo195, corBojo196, corBojo197, corBojo198, corBojo199, corBojo200, corBojo201, corBojo202,
                corBojo203, corBojo204, corBojo205, corBojo206, corBojo207, corBojo208, corBojo209, corBojo210,
                corBojo211, corBojo212, corBojo213, corBojo214, corBojo215, corBojo216, corBojo217));

        corAlcaRepository.saveAll(Arrays.asList(corAlca1, corAlca2, corAlca3, corAlca4));

        corElasticoRepository.saveAll(Arrays.asList(corElastico1, corElastico2, corElastico3, corElastico4));

        corLinhaRepository.saveAll(Arrays.asList(corLinha1, corLinha2, corLinha3, corLinha4));

        corRendaRepository.saveAll(Arrays.asList(corRenda1, corRenda2, corRenda3, corRenda4));

        corEntradasRepository.saveAll(Arrays.asList(corEnt1, corEnt2, corEnt3, corEnt4, corEnt5,
                corEnt6, corEnt7, corEnt8, corEnt9, corEnt10, corEnt11, corEnt12, corEnt13,
                corEnt14, corEnt15, corEnt16, corEnt17, corEnt18, corEnt19, corEnt20, corEnt21));

        caixaBojoRepository.saveAll(Arrays.asList(caixa1, caixa2, caixa3, caixa4, caixa5, caixa6, caixa7, caixa8,
                caixa9, caixa10, caixa11, caixa12));

    }
}
