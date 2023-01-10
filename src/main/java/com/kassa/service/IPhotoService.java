package com.kassa.service;

import com.kassa.dto.PhotoDTO;
import com.kassa.entity.Photo;

import java.util.List;

public interface IPhotoService {
    PhotoDTO addPhoto(PhotoDTO photoDTO);
    List<PhotoDTO> getNotProcessedPhotos();
}
