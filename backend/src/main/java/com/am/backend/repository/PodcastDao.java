package com.am.backend.repository;

import com.am.backend.models.Podcast;

import java.util.List;

public interface PodcastDao {
    void savePodcast(Podcast podcast);

    List<Object> getPodcasts();
}
