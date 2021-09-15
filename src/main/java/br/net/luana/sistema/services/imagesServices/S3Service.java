package br.net.luana.sistema.services.imagesServices;

import br.net.luana.sistema.services.exceptions.FileException;
import com.amazonaws.services.s3.AmazonS3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;

@Service
public class S3Service {

    @Autowired
    private AmazonS3 s3client;

    @Value("${s3.bucket}")
    private String bucketName;


    public URI uploadFile(File file, String fileName) {
        try {
            s3client.putObject(bucketName, fileName, file);
            return s3client.getUrl(bucketName, fileName).toURI();
        } catch (URISyntaxException e) {
            throw new FileException("Erro ao converter URL para URI");
        }
    }

    public void deleteFile(String fileName) {
        s3client.deleteObject(bucketName, fileName);
    }

    public String getFileName(String URIFile) {
        String[] parts = URIFile.split("/");
        return parts[(parts.length) - 1];
    }

}
