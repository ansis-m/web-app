package com.am.backend.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class Track implements Serializable {


    public Track(String title){
        this.title = title;
        this.timestamp = -1;
    }

    public Track(String title, String info){
        this.title = title;
        this.info = info;
        this.timestamp = -1;
    }
    Integer timestamp;
    String title;
    String info;
}
