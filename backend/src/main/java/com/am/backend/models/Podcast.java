package com.am.backend.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;
import java.util.LinkedList;

@Data
@RedisHash("PODCAST")
@NoArgsConstructor
public class Podcast implements Serializable {

    @Id
    String fileName;
    Boolean showTrackList;
    LinkedList<Track> trackList = new LinkedList<>();

    public Podcast(String fileName, boolean showTrackList){
        this.fileName = fileName;
        this.showTrackList = showTrackList;
    }
}
