package br.net.luana.sistema.services.imagesServices;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ImageResolver {

    private String defaultURI = "https://sistema-estoque.s3.sa-east-1.amazonaws.com/";

    private String defaultFormat = ".webp";

    private String prefixoCor = "cor";

    private String[] sufixo = {"mini", "default", "big"};
    private int[] largura = {70, 680, 1035};
    private int[] altura = {80, 680, 1200};

    public String createImageName(Integer corId) {
        StringBuilder imageName = new StringBuilder();
        imageName.append(prefixoCor).append(corId).append("_")
                .append(createHash()).append("_");
        return imageName.toString();
    }

    public String createHash() {
        List<Character> characters = new ArrayList<>();
        characters.addAll(Arrays.asList('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
                'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'));

        Random random = new Random();

        StringBuilder hash = new StringBuilder();
        hash.append(Long.toString(System.currentTimeMillis() + Math.abs(random.nextLong())))
                .append(Long.toString(System.currentTimeMillis() + Math.abs(random.nextLong())));

        int quantidadeTrocas = random.nextInt(hash.length());

        for(int j = 0; j <= quantidadeTrocas; j++) {
            int posicaoTroca = random.nextInt(hash.length());
            char caractereSubstituto = characters.get(random.nextInt(characters.size()));
            hash.setCharAt(posicaoTroca, caractereSubstituto);
        }

        return hash.toString();
    }

    public List<String> getListFileNames(String fileName) {
        List<String> listFileNames = new ArrayList<>();
        for(String sufixoCor : sufixo) {
            String createFileName = new StringBuilder().append(fileName)
                    .append(sufixoCor).append(defaultFormat).toString();
            listFileNames.add(createFileName);
        }
        return listFileNames;
    }

    public List<String> getUrisImagens(String imageName) {
        List<String> listUrisImagens = new ArrayList<>();
        for(String fileName : getListFileNames(imageName)) {
            String createUri = new StringBuilder().append(defaultURI)
                    .append(fileName).toString();
            listUrisImagens.add(createUri);
        }
        return listUrisImagens;
    }

    public Set<String> getUriImagensPrincipais(Set<String> imagensPrincipais) {
        Set<String> urisImagensPrincipais = new HashSet<>();
        for(String imagemPrincipal : imagensPrincipais) {
            String uriImagem = new StringBuilder().append(defaultURI)
                    .append(imagemPrincipal).append(sufixo[1]).append(defaultFormat).toString();
            urisImagensPrincipais.add(uriImagem);
        }
        return urisImagensPrincipais;
    }

    public String getFileNameByURI(String prefixo, String uri) {
        int inicio = uri.lastIndexOf(prefixo);
        int fim = uri.lastIndexOf('_');
        String fileName = uri.substring(inicio, (fim+1));
        System.out.println(fileName);
        return fileName;
    }

    public int getLargura(int indice) {
        return largura[indice];
    }

    public int getAltura(int indice) {
        return altura[indice];
    }
}
