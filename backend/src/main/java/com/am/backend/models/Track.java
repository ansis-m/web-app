package com.am.backend.models;

import lombok.Data;

import java.io.Serializable;

@Data
public class Song implements Serializable {


    public Song(String title){
        this.title = title;
    }
    Integer timestamp;
    String title;
    String info;
}
