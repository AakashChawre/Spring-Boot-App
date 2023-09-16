package com.rest.test.rest_test.utills;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUpload {

    // private final String UPLOAD_PATH = "S:\\Spring\\rest_test\\src\\main\\resources\\static\\images";
    private final String UPLOAD_PATH = new ClassPathResource("static/images/").getFile().getAbsolutePath();

    public FileUpload() throws IOException {
        
    }

    public Boolean fileUpload(MultipartFile file) {
        boolean f = false;

        try {
            Files.copy(file.getInputStream(), Paths.get(UPLOAD_PATH + File.separator + file.getOriginalFilename()),
                    StandardCopyOption.REPLACE_EXISTING);
            f = true;
        } catch (IOException e) { 
            e.printStackTrace();
            f = false;
        }

        return f;
    }

}
