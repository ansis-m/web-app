package com.am.backend.repository;

import com.am.backend.models.PodcastModel;

import java.util.List;

public interface PodcastDao {
    void savePodcast(PodcastModel podcast);

    List<Object> getPodcasts();
}
