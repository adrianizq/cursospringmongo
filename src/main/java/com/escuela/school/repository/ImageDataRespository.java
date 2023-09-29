package com.escuela.school.repository;

import com.escuela.school.model.ImageData;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface ImageDataRespository extends MongoRepository<ImageData, String> {
    Optional<ImageData> findByName(String name);

}
