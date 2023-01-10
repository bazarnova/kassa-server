package com.kassa.repository;

import com.kassa.entity.Photo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PhotoRepository extends JpaRepository<Photo, Long> {
    Photo save(Photo photo);

    List<Photo> getPhotoByProcessedFalse();
}
