package com.example.demo.services;

import com.example.demo.entitiesRequest.FileRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.stereotype.Service;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class FileServiceImpl implements FileService, ServletContextAware {

    private ServletContext servletContext;

    @Override
    public String upload(String originName, byte[] bytes) {
        try{
            String name = UUID.randomUUID().toString().replace("-","");
            int lastIndex = originName.lastIndexOf(".");
            String filename = name +  originName.substring(lastIndex);

            Path path = Paths.get(servletContext.getRealPath("/uploads/" + filename));
            System.out.println("File name:" + filename);

            System.out.println("File path:" + path.toString());
            Files.write(path,bytes);
            return filename;

        } catch (Exception e){
            return null;
        }
    }

    @Override
    public MultipartFile getFile(String path) throws IOException {

        File file = new File(path);
        InputStream stream =  new FileInputStream(file);
      //  multipartFileToSend = new MockMultipartFile("file", file.getName(), MediaType.ALL_VALUE, stream);

          int lastIndex = path.lastIndexOf("\\");
          String filename = path.substring(lastIndex);
//        Path path1 = Paths.get(path);
//        String name = filename;
//        String originalFileName = filename;
//        String contentType =  Files.probeContentType(path1);
//        byte[] content = null;
//        try {
//            content = Files.readAllBytes(path1);
//        } catch (final IOException e) {
//        }
        MultipartFile result = new MockMultipartFile(path, file.getName(), MediaType.ALL_VALUE, stream);

        return result;
    }


    @Override
    public void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
    }

    @Bean
    public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        MappingJackson2HttpMessageConverter converter =
                new MappingJackson2HttpMessageConverter(mapper);
        return converter;
    }
}
