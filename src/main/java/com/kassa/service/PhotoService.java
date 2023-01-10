package com.kassa.service;

import com.kassa.dto.PhotoDTO;
import com.kassa.entity.Photo;
import com.kassa.repository.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PhotoService implements IPhotoService {
    @Autowired
    private PhotoRepository photoRepository;

    @Override
    public PhotoDTO addPhoto(PhotoDTO photoDTO) {
        Photo photo = Photo.builder()
                .id(photoDTO.getId())
                .fileId(photoDTO.getFileId())
                .messageDate(photoDTO.getMessageDate())
                .addedDate(photoDTO.getAddedDate())
                .processed(photoDTO.getProcessed())
                .path(photoDTO.getPath())
                .build();
        photoRepository.save(photo);
        return photoDTO;
    }
    @Override
    public List<PhotoDTO> getNotProcessedPhotos() {
        List<PhotoDTO> photoDTOS = new ArrayList<>();
        for (Photo photo : photoRepository.getPhotoByProcessedFalse()) {
            PhotoDTO photoDTO = PhotoDTO.builder()
                    .id(photo.getId())
                    .fileId(photo.getFileId())
                    .messageDate(photo.getMessageDate())
                    .addedDate(photo.getAddedDate())
                    .processed(photo.getProcessed())
                    .path(photo.getPath())
                    .build();
            photoDTOS.add(photoDTO);
        }
        return photoDTOS;
    }
}
