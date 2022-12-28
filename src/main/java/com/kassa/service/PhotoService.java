package com.kassa.service;

import com.kassa.entity.Photo;
import com.kassa.flyway.PhotoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhotoService implements IPhotoService {
    @Autowired
    private PhotoMapper photoMapper;

    @Override
    public Photo addPhoto(Photo photo) {
        photoMapper.addPhoto(photo);
        return photo;
    }
    @Override
    public List<Photo> getNotProcessedPhotos() {
        return photoMapper.getNotProcessedPhotos();
    }
}
