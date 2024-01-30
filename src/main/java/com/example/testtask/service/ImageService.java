package com.example.testtask.service;


import com.example.testtask.entity.ImageEntity;
import com.example.testtask.repository.ImageRepository;
import com.example.testtask.service.imp.ImageServiceImp;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class ImageService implements ImageServiceImp {

    @Autowired
    private ImageRepository imageRepository;


    @Override
    public ImageEntity store(MultipartFile file) throws IOException {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        ImageEntity image = new ImageEntity(fileName, file.getContentType(), file.getBytes());

        return imageRepository.save(image);
    }

    @Override
    public Stream<ImageEntity> getAllFiles() {
        return imageRepository.findAll().stream();
    }

    @Override
    public Optional<ImageEntity> getImage(UUID id) {
        return Optional.ofNullable(imageRepository.findById(id));
    }
}
