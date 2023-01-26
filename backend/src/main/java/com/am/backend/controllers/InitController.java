package com.am.backend.controllers;

import com.am.backend.services.PodcastService;
import com.am.backend.models.PodcastModel;
import com.am.backend.utils.trackListParser.TrackListParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class InitController {

    @Value("${hostname}")
    private String hostname;

    @Value("${files}")
    private String files;

    @Autowired
    InitController(PodcastService podcastService){
        this.podcastService = podcastService;
    }
    PodcastService podcastService;

    @GetMapping("/filenames")
    public ArrayList<PodcastModel> listOfFilenames(){
        return TrackListParser.getFilenames(files);
    }

    @PostMapping("/timestamp/add/{title}")
    public ArrayList<PodcastModel> addTimestamp(@PathVariable String title, @RequestBody Integer timestamp){
        /*TODO: update the persistence and return the new model
          Frontend does not update the model itself
        */
        return TrackListParser.getFilenames(files);
    }

    @PostMapping("/timestamp/remove/{title}")
    public ArrayList<PodcastModel> removeTimestamp(@PathVariable String title, @RequestBody Integer timestamp){
        /*TODO: update the persistence and return the new model
          Frontend does not update the model itself
        */
        return TrackListParser.getFilenames(files);
    }

    @PostMapping("/save")
    public void savePodcast(@RequestBody String filename){
        podcastService.savePodcast(new PodcastModel(filename, true));
    }

    @GetMapping("/podcasts")
    public List<Object> getPodcast(){
        return podcastService.getPodcasts();
    }
}
