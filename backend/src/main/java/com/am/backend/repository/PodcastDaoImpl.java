package com.am.backend.repository;

import com.am.backend.models.Podcast;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;

@Repository
public class PodcastDaoImpl implements PodcastDao{


    private final RedisTemplate<String, Podcast> redisTemplate;
    @Autowired
    PodcastDaoImpl(RedisTemplate<String, Podcast> redisTemplate){
        this.redisTemplate = redisTemplate;
    }
    private static final String KEY = "PODCAST";

    @Override
    public void savePodcast(Podcast podcast) {

        try {
            redisTemplate.opsForHash().put(KEY, podcast.getFileName(), podcast);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public LinkedList<Podcast> getPodcasts() {
        ObjectMapper om = new ObjectMapper();
        LinkedList<Podcast> result = new LinkedList<>();
        redisTemplate.opsForHash().values(KEY).forEach(podcast -> result.add(om.convertValue(podcast, Podcast.class)));
        return result;
    }

    @Override
    public Podcast getPodcast(String fileName) {
        ObjectMapper om = new ObjectMapper();
        return om.convertValue(redisTemplate.opsForHash().get(KEY, fileName), Podcast.class);
    }
}
