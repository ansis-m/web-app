package com.am.backend.services;

import com.am.backend.models.Podcast;

import java.util.List;

public interface PodcastRedisService {

    void savePodcast(Podcast podcast);
    List<Object> getPodcasts();

}
