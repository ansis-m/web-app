package com.am.backend.services;

import com.am.backend.models.Podcast;
import com.am.backend.repository.PodcastDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PodcastRedisServiceImp implements PodcastRedisService {


    @Autowired
    PodcastDao podcastDao;

    @Override
    public void savePodcast(Podcast podcast) {
        podcastDao.savePodcast(podcast);
    }

    @Override
    public List<Object> getPodcasts() {
        return podcastDao.getPodcasts();
    }
}
