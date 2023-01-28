package com.am.backend.utils.trackListParser;

import com.am.backend.models.Podcast;
import com.am.backend.models.Track;
import com.am.backend.services.PodcastRedisService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

@Component
public class TrackListParser {

    private static String files;
    private static PodcastRedisService podcastRedisService;
    private TrackListParser(
            @Value("${files}") String files,
            PodcastRedisService podcastRedisService
    ){
        TrackListParser.files = files;
        TrackListParser.podcastRedisService = podcastRedisService;
        initPodcasts();
    }
    public static void initPodcasts(){
        File folder = new File(files);
        Arrays.stream(Objects.requireNonNull(folder.listFiles())).forEach(subfolder -> {
            if(subfolder.isDirectory()) {
                AtomicBoolean add = new AtomicBoolean(false);
                Podcast podcast = new Podcast();
                Arrays.stream(Objects.requireNonNull(subfolder.listFiles())).forEach(file -> {
                    if (isAudio(file)) {
                        add.set(true);
                        podcast.setFileName(file.getName());
                    }
                    try {
                        if (file.getName().equals("tracklist.txt") && Files.size(Path.of(file.getAbsolutePath())) > 100) {
                            podcast.setShowTrackList(true);
                            podcast.setTrackList(parseFile(file));
                        }
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });
                if (add.get()) {
                    syncWithRedis(podcast);
                }
            }
        });
    }

    private static void syncWithRedis(Podcast podcast) {
        Podcast redisPodcast = podcastRedisService.getPodcast(podcast.getFileName());
        if (redisPodcast == null) {
            podcastRedisService.savePodcast(podcast);
        } else {
            System.out.println("podcast found: " + podcast.getFileName() + "\n\n");
        }
    }

    private static LinkedList<Track> parseFile(File file) throws FileNotFoundException {
        LinkedList<Track> trackList = new LinkedList<>();
        Scanner scanner = new Scanner(file);
        StringBuilder stringBuilder = new StringBuilder(" ");
        while (scanner.hasNextLine()) {
            stringBuilder.append(scanner.nextLine()).append(" ");
        }
        Arrays.asList(stringBuilder.toString().split("((?=[^0-9|$][0-2][0-9] ))")).forEach(string -> trackList.add(getTrack(string)));
        return trackList;
    }

    private static Track getTrack(String string) {

        int i = string.indexOf("(");
        if (i == -1){
            return new Track(string);
        } else {
            return new Track(string.substring(0, i), string.substring(i));
        }
    }

    private static boolean isAudio(File file) {
        return file.isFile() &&
                (file.getName().endsWith(".mp3") ||
                        file.getName().endsWith(".m4a") ||
                        file.getName().endsWith(".wma"));
    }
}
