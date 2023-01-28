package com.am.backend.services;

import com.am.backend.models.Podcast;
import java.util.LinkedList;

public interface PodcastRedisService {

    void savePodcast(Podcast podcast);
    LinkedList<Podcast> getPodcasts();
    Podcast getPodcast(String fileName);

    int addTimeStamp(String fileName, String trackTitle, int timestamp);

    int removeTimeStamp(String fileName, String trackTitle);
}
