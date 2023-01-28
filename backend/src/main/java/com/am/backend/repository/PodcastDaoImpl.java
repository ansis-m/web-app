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

    @Override
    public int addTimeStamp(String fileName, String trackTitle, int timestamp) {
        try {
            ObjectMapper om = new ObjectMapper();
            Podcast podcast = om.convertValue(redisTemplate.opsForHash().get(KEY, fileName), Podcast.class);
            podcast.getTrackList().forEach(track -> {   if (track.getTitle().trim().equals(trackTitle.trim())) {
                                                            track.setTimestamp(timestamp);
                                                        }
                                                    });
            redisTemplate.opsForHash().put(KEY, fileName, podcast);
            return 1;
        } catch (Exception e){
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public int removeTimeStamp(String fileName, String trackTitle) {
        try {
            ObjectMapper om = new ObjectMapper();
            Podcast podcast = om.convertValue(redisTemplate.opsForHash().get(KEY, fileName), Podcast.class);
            podcast.getTrackList().forEach(track -> {   if (track.getTitle().trim().equals(trackTitle.trim())) {
                                                            track.setTimestamp(-1);
                                                        }
                                                    });
            redisTemplate.opsForHash().put(KEY, fileName, podcast);
            return 1;
        } catch (Exception e){
            e.printStackTrace();
            return -1;
        }
    }
}
