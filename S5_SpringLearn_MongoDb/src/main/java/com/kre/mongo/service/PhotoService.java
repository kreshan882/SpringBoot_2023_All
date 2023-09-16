package com.kre.mongo.service;

import org.springframework.web.multipart.MultipartFile;

import com.kre.mongo.collection.Photo;

import java.io.IOException;

public interface PhotoService {
    String addPhoto(String originalFilename, MultipartFile image) throws IOException;

    Photo getPhoto(String id);
}
