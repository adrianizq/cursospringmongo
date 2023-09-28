package com.escuela.school;

import lombok.Builder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service

public class ImageDataService {
    private ImageDataRespository imageDataRespository;
    //Upload
    public  String uploadImage(MultipartFile file) throws IOException {
        ImageData imageData = imageDataRespository.save(
                ImageData.builder()
                        .name(file.getName())
                        .type(file.getContentType())
                        .imageData(ImageUtils.compressImage(file.getBytes())).build();
                if(imageData!=null){
                    return "File uploaded succesfully:" + file.getName();
                }

                return null;
        )
    }


    //Download
}
