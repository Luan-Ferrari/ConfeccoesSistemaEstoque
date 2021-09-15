package br.net.luana.sistema.services.imagesServices;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
                .append(System.currentTimeMillis()).append("_");
        return imageName.toString();
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
