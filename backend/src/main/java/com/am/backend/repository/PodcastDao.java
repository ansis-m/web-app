package com.am.backend.repository;

import com.am.backend.models.Podcast;

import java.util.LinkedList;

public interface PodcastDao {
    void savePodcast(Podcast podcast);

    LinkedList<Podcast> getPodcasts();

    Podcast getPodcast(String fileName);
}
