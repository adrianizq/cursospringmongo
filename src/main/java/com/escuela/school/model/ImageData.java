package com.escuela.school.model;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jbosslog.JBossLog;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document
@Data
@Builder
public class ImageData {
    @Id
    private String id;
    String name;
    String type;
    private byte[] imageData;
}
