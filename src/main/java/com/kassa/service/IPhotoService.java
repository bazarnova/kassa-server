package com.kassa.service;

import com.kassa.entity.Photo;

import java.util.List;

public interface IPhotoService {
    Photo addPhoto(Photo photo);
    List<Photo> getNotProcessedPhotos();
}
