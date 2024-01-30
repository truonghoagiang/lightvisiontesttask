package com.example.testtask.repository;

import com.example.testtask.entity.ImageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ImageRepository extends JpaRepository<ImageEntity, String> {
    ImageEntity findById(UUID id);
}
