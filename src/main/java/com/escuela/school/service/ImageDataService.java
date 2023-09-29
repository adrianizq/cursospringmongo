package com.escuela.school.service;

import com.escuela.school.model.ImageData;
import com.escuela.school.utils.ImageUtils;
import com.escuela.school.repository.ImageDataRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service

public class ImageDataService {
    private ImageDataRespository imageDataRespository;

    @Autowired
    public ImageDataService(ImageDataRespository imageDataRespository) {
        this.imageDataRespository = imageDataRespository;
    }
    //Upload
    public  String uploadImage(MultipartFile file) throws IOException {
        ImageData imageData = imageDataRespository.save(
                ImageData.builder()
                        .name(file.getName())
                        .type(file.getContentType())
                        .imageData(ImageUtils.compressImage(file.getBytes())).build());
                if(imageData!=null){
                    return "File uploaded succesfully:" + file.getName();
                }

                return null;
    }


    //Download
    public byte[] downloadImage(String fileName) {
        Optional<ImageData> imageData = imageDataRespository.findByName(fileName);
        byte[] image = ImageUtils.decompressImage(imageData.get().getImageData());
        return image;
    }
}
