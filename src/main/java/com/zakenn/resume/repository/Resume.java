package com.zakenn.resume.repository;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class Resume {
    @Id
    private String id;
    private String resume;
}
