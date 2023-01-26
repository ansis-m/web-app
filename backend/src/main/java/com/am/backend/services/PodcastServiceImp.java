package com.am.backend.services;

import com.am.backend.models.PodcastModel;
import com.am.backend.repository.PodcastDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PodcastServiceImp implements PodcastService{


    @Autowired
    PodcastDao podcastDao;

    @Override
    public void savePodcast(PodcastModel podcast) {
        podcastDao.savePodcast(podcast);
    }

    @Override
    public List<Object> getPodcasts() {
        return podcastDao.getPodcasts();
    }
}
