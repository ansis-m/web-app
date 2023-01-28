package com.am.backend.services;

import com.am.backend.models.Podcast;
import com.am.backend.repository.PodcastDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;

@Service
public class PodcastRedisServiceImp implements PodcastRedisService {


    @Autowired
    PodcastDao podcastDao;

    @Override
    public void savePodcast(Podcast podcast) {
        podcastDao.savePodcast(podcast);
    }

    @Override
    public LinkedList<Podcast> getPodcasts() {
        return podcastDao.getPodcasts();
    }

    @Override
    public Podcast getPodcast(String fileName) {
        return podcastDao.getPodcast(fileName);
    }

    @Override
    public int addTimeStamp(String fileName, String trackTitle, int timestamp) {
        return podcastDao.addTimeStamp(fileName, trackTitle, timestamp);
    }

    @Override
    public int removeTimeStamp(String fileName, String trackTitle) {
        return podcastDao.removeTimeStamp(fileName, trackTitle);
    }
}
