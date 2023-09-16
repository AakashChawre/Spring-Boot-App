package com.rest.test.rest_test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.rest.test.rest_test.utills.FileUpload;

@RestController
public class FileController {

    @Autowired
    FileUpload fileUpload;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {

        try {

            boolean f = fileUpload.fileUpload(file);

            if (file.isEmpty() && f == false) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Please select image.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went Wrong.");
        }

        // return ResponseEntity.ok("Image upload successfully");

          return ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath().path("/images/").path(file.getOriginalFilename()).toUriString());
    }

}
