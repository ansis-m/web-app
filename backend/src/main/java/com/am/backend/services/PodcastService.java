package com.am.backend.services;

import com.am.backend.models.PodcastModel;

import java.util.List;

public interface PodcastService {

    void savePodcast(PodcastModel podcast);
    List<Object> getPodcasts();

}
