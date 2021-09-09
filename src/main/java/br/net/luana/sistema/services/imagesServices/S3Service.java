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

//    public URI uploadFile(MultipartFile multipartFile) {
//        try {
//            String fileName = multipartFile.getOriginalFilename();
//            InputStream is = multipartFile.getInputStream();
//            String contentType = multipartFile.getContentType();
//
//            //return uploadFile(is, fileName, contentType);
//            return uploadFileTeste(multipartFile);
//
//        } catch (IOException e) {
//            throw new FileException("Erro de IO: " + e.getMessage());
//        }
//    }
//    public URI uploadFile(InputStream is, String fileName, String contentType) {
//        try {
//            ObjectMetadata meta = new ObjectMetadata();
//            meta.setContentType(contentType);
//
//            s3client.putObject(bucketName, fileName, is, meta);
//
//            return s3client.getUrl(bucketName, fileName).toURI();
//
//        } catch (URISyntaxException e) {
//            throw new RuntimeException("Erro ao converter URL para URI");
//        }
//    }

//    public URI uploadFile(InputStream is, String fileName, String contentType) {
//        try {
//            ObjectMetadata meta = new ObjectMetadata();
//            meta.setContentType("webp");
//
//            s3client.putObject(bucketName, "teste.webp", is, meta);
//
//            return s3client.getUrl(bucketName, "teste.webp").toURI();
//
//        } catch (URISyntaxException e) {
//            throw new RuntimeException("Erro ao converter URL para URI");
//        }
//    }
//    ESTE ABAIXO FUNCIONA
//    public URI uploadFileTeste(MultipartFile multipartFile) throws IOException {
//        try {
//            long time1 = System.currentTimeMillis();
//            System.out.println("Time1: " + time1);
//            File file = new File("testeteste.webp");
//            long time2 = System.currentTimeMillis();
//            System.out.println("Time2: " + time2);
//            System.out.println("Demorou: " + (time2 - time1));
//            ImmutableImage image = ImmutableImage.loader()
//                    .fromStream(multipartFile.getInputStream());
//            long time3 = System.currentTimeMillis();
//            System.out.println("Time3: " + time3);
//            System.out.println("Demorou: " + (time3 - time2));
//            WebpWriter webpWriter = new WebpWriter();
//            long time4 = System.currentTimeMillis();
//            System.out.println("Time4: " + time4);
//            System.out.println("Demorou: " + (time4 - time3));
//            image.output(WebpWriter.DEFAULT, "testeteste.webp");
//            long time5 = System.currentTimeMillis();
//            System.out.println("Time5: " + time5);
//            System.out.println("Demorou: " + (time5 - time4));
//
//            ObjectMetadata meta = new ObjectMetadata();
//            meta.setContentType("webp");
//            long time6 = System.currentTimeMillis();
//            System.out.println("Time6: " + time6);
//            System.out.println("Demorou: " + (time6 - time5));
//
//            s3client.putObject(bucketName, "teste.webp", file);
//            long time7 = System.currentTimeMillis();
//            System.out.println("Time7: " + time7);
//            System.out.println("Demorou: " + (time7 - time6));
//
//            return s3client.getUrl(bucketName, "teste.webp").toURI();
//
//        } catch (URISyntaxException e) {
//            throw new RuntimeException("Erro ao converter URL para URI");
//        } catch (IOException e) {
//            throw new IOException("Arquivo de imagem inválido");
//        }
//    }

    public URI uploadFile(File file, String fileName) {
        try {
////            long time1 = System.currentTimeMillis();
////            System.out.println("Time1: " + time1);
//            File file = new File("testeteste.jpeg");
////            long time2 = System.currentTimeMillis();
////            System.out.println("Time2: " + time2);
////            System.out.println("Demorou: " + (time2 - time1));
//            ImmutableImage image = ImmutableImage.loader()
//                    .fromStream(multipartFile.getInputStream());
////            long time3 = System.currentTimeMillis();
////            System.out.println("Time3: " + time3);
////            System.out.println("Demorou: " + (time3 - time2));
//            WebpWriter webpWriter = new WebpWriter();
////            long time4 = System.currentTimeMillis();
////            System.out.println("Time4: " + time4);
////            System.out.println("Demorou: " + (time4 - time3));
//            image.output(JpegWriter.compression(50), "testeteste.jpeg");
////            long time5 = System.currentTimeMillis();
////            System.out.println("Time5: " + time5);
////            System.out.println("Demorou: " + (time5 - time4));
//
//            ObjectMetadata meta = new ObjectMetadata();
//            meta.setContentType("webp");
////            long time6 = System.currentTimeMillis();
////            System.out.println("Time6: " + time6);
////            System.out.println("Demorou: " + (time6 - time5));

            s3client.putObject(bucketName, fileName, file);
//            long time7 = System.currentTimeMillis();
//            System.out.println("Time7: " + time7);
//            System.out.println("Demorou: " + (time7 - time6));

            return s3client.getUrl(bucketName, fileName).toURI();

        } catch (URISyntaxException e) {
            throw new FileException("Erro ao converter URL para URI");
        }
    }

    public void deleteFile(String URIFile) {
        String fileName = getFileName(URIFile);
        s3client.deleteObject(bucketName, fileName);
    }

    public String getFileName(String URIFile) {
        String[] parts = URIFile.split("/");
        return parts[(parts.length) - 1];
    }

}
