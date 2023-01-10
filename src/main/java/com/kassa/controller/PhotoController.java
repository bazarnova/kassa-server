package com.kassa.controller;

import com.kassa.dto.PhotoDTO;
import com.kassa.entity.Check;
import com.kassa.entity.Photo;
import com.kassa.service.CheckListWrapper;
import com.kassa.service.ICheckService;
import com.kassa.service.IPhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
public class PhotoController {

    @Autowired
    ApplicationContext applicationContext;

    private final IPhotoService photoService;

    public PhotoController(IPhotoService photoService) {
        this.photoService = photoService;
    }

    @GetMapping(value = "/photos")
    @ResponseBody
    public List<PhotoDTO> photoList() {
        return photoService.getNotProcessedPhotos();
    }



}
