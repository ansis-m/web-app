package com.am.backend.repository;

import com.am.backend.models.Podcast;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PodcastDaoImpl implements PodcastDao{

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
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
    public List<Object> getPodcasts() {

        List<Object> result;
        result =  redisTemplate.opsForHash().values(KEY);
        return result;
    }
}
