package br.net.luana.sistema.services.imagesServices;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ImageResolver {

    @Value("${s3.default_uri}")
    private String defaultURI;

    @Value("${s3.default_format}")
    private String defaultFormat;

    @Value("${image.prefix.cores}")
    private String prefixo;

    private String[] sufixo = {"mini", "default", "big"};
    private int[] largura = {70, 680, 1035};
    private int[] altura = {80, 680, 1200};


    public String createImageName(Integer corId) {
        StringBuilder imageName = new StringBuilder();
        imageName.append(prefixo).append(corId).append("_")
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

    public int getLargura(int indice) {
        return largura[indice];
    }

    public int getAltura(int indice) {
        return altura[indice];
    }
}
