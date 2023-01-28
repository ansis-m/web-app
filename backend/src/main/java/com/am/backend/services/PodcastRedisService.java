package com.am.backend.services;

import com.am.backend.models.Podcast;

import java.util.List;

public interface PodcastService {

    void savePodcast(Podcast podcast);
    List<Object> getPodcasts();

}
