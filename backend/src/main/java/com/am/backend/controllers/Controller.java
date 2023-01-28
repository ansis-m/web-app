package com.am.backend.controllers;

import com.am.backend.models.Podcast;
import com.am.backend.services.PodcastRedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class Controller {

    @Value("${hostname}")
    private String hostname;

    @Autowired
    Controller(PodcastRedisService podcastRedisService){
        this.podcastRedisService = podcastRedisService;
    }
    PodcastRedisService podcastRedisService;

    @GetMapping("/filenames")
    public List<Podcast> listOfFilenames(){
        return podcastRedisService.getPodcasts();
    }

    @PostMapping("/timestamp/add/{fileName}/{trackTitle}")
    public int addTimestamp(@PathVariable String fileName, @PathVariable String trackTitle, @RequestBody Integer timestamp){
        return podcastRedisService.addTimeStamp(fileName, trackTitle, timestamp);
    }

    @PostMapping("/timestamp/remove/{fileName}/{trackTitle}")
    public int removeTimestamp(@PathVariable String fileName, @PathVariable String trackTitle ){
        return podcastRedisService.removeTimeStamp(fileName, trackTitle);
    }

    @PostMapping("/save")
    public void savePodcast(@RequestBody String filename){
        podcastRedisService.savePodcast(new Podcast(filename, true));
    }

    @GetMapping("/podcasts")
    public List<Podcast> getPodcast(){
        return podcastRedisService.getPodcasts();
    }

}
