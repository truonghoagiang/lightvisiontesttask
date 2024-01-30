package com.example.testtask.entity;


import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.awt.*;
import java.util.UUID;

@Data
@Entity()
@Table(name = "image")
public class ImageEntity {

    @Id
    @GeneratedValue()
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private String type;

    @Lob
    @Column(name = "data")
    private byte[] data;

    public ImageEntity(String name, String type, byte[] data){
        this.name = name;
        this.type = type;
        this.data = data;
    }

    public ImageEntity(){

    }
}
