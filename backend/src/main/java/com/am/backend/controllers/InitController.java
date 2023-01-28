package com.am.backend.controllers;

import com.am.backend.models.Podcast;
import com.am.backend.services.PodcastRedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class InitController {

    @Value("${hostname}")
    private String hostname;

    @Autowired
    InitController(PodcastRedisService podcastRedisService){
        this.podcastRedisService = podcastRedisService;
    }
    PodcastRedisService podcastRedisService;

    @GetMapping("/filenames")
    public List<Podcast> listOfFilenames(){
        System.out.println("Yes!!!!");
        return podcastRedisService.getPodcasts();//TODO refraktorēt, lai atgriež PodcastRedisService
    }

    @PostMapping("/timestamp/add/{title}")
    public void addTimestamp(@PathVariable String title, @RequestBody Integer timestamp){
        /*TODO: update the persistence and return the new model
          Frontend does not update the model itself
        */
    }

    @PostMapping("/timestamp/remove/{title}")
    public void removeTimestamp(@PathVariable String title, @RequestBody Integer timestamp){
        /*TODO: update the persistence and return the new model
          Frontend does not update the model itself
        */
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
