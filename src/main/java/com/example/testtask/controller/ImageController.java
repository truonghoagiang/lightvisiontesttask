package com.example.testtask.controller;


import com.example.testtask.entity.ImageEntity;
import com.example.testtask.payload.response.BasicResponse;
import com.example.testtask.repository.ImageRepository;
import com.example.testtask.service.imp.ImageServiceImp;
import jakarta.persistence.Basic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/image")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ImageController {

    @Autowired
    private ImageRepository imageRepository;

    @Autowired
    private ImageServiceImp imageServiceImp;

    @PostMapping("/save")
    public ResponseEntity<?>uploadFile(@RequestParam("file")MultipartFile file){
        BasicResponse basicResponse = new BasicResponse();
        try {
            imageServiceImp.store(file);
            basicResponse.setMessage("File uploaded successfull!");
            basicResponse.setData(file.getOriginalFilename());
        } catch (Exception e) {
            //message = "File upload error: " + file.getOriginalFilename() + "!";
            basicResponse.setMessage("Upload file error: " + e.getLocalizedMessage());
        }

        return new ResponseEntity<>(basicResponse, HttpStatus.OK);
    }

    //Get all images
    @GetMapping("")
    public ResponseEntity<?> getAllImages(){
        return ResponseEntity.ok(imageServiceImp.getAllFiles());
    }

    //View image
    @GetMapping("/{id}")
    public ResponseEntity<?>viewImage(@PathVariable UUID id){
        Optional<ImageEntity> image = imageServiceImp.getImage(id);
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(image.get().getType()))
                .body(image.get().getData());
    }
}
