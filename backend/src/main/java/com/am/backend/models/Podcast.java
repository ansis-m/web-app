package com.am.backend.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;
import java.util.LinkedList;

@Data
@RedisHash("PODCAST")
@NoArgsConstructor
public class PodcastModel implements Serializable {

    String fileName;
    boolean showTrackList;
    LinkedList<Song> trackList = new LinkedList<>();

    public PodcastModel(String fileName, boolean showTrackList){
        this.fileName = fileName;
        this.showTrackList = showTrackList;
    }
}
