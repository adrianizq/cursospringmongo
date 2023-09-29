package com.escuela.school.controller;

import com.escuela.school.service.ImageDataService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping ("api/imagedata")
@AllArgsConstructor
public class ImageDataController {
    ImageDataService imageDataService;

    //Metodo para subir la imagen POST
    @PostMapping ("/upload")
    public ResponseEntity<?> uploadImage(@RequestParam ("image")MultipartFile file) throws IOException {
        String strImage = imageDataService.uploadImage(file);
        return ResponseEntity.status(HttpStatus.OK).body(strImage);
    }

    @GetMapping("/download/{fileName}")
    public ResponseEntity<?> downloadImage(@PathVariable String fileName){
        byte[] imageData = imageDataService.downloadImage(fileName);
        return ResponseEntity.status(HttpStatus.OK).contentType(
                MediaType.valueOf("image/png")).body(imageData);

    }

}
