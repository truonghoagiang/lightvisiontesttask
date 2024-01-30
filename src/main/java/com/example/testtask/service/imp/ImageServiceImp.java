package com.example.testtask.service.imp;

import com.example.testtask.entity.ImageEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;

@Service
public interface ImageServiceImp {
    ImageEntity store(MultipartFile file) throws IOException;
    Stream<ImageEntity> getAllFiles();
    Optional<ImageEntity> getImage(UUID id);
}
