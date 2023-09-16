package com.kre.mongo.service;

import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.kre.mongo.collection.Photo;
import com.kre.mongo.repository.PhotoRepository;

import java.io.IOException;

@Service
public class PhotoServiceImpl implements PhotoService{

    @Autowired
    private PhotoRepository photoRepository;

    @Override
    public String addPhoto(String originalFilename, MultipartFile image) throws IOException {
        
    	  Photo photo = new Photo();
	    	  photo.setTitle(originalFilename);
	    	  photo.setPhoto(new Binary(BsonBinarySubType.BINARY,image.getBytes()));
        
	      return photoRepository.save(photo).getId();
       // return photoRepository.save(photo).toString();
    }

    @Override
    public Photo getPhoto(String id) {
        return photoRepository.findById(id).get();
    }
}