package com.am.backend.utils.trackListParser;

import com.am.backend.models.PodcastModel;
import com.am.backend.models.Song;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

public class TrackListParser {

    private TrackListParser(){

    }

    public static ArrayList<PodcastModel> getFilenames(String files) {

        ArrayList<PodcastModel> result = new ArrayList<>();
        File folder = new File(files);
        Arrays.stream(Objects.requireNonNull(folder.listFiles())).forEach(subfolder -> {
            if(subfolder.isDirectory()) {
                AtomicBoolean add = new AtomicBoolean(false);
                PodcastModel podcast = new PodcastModel();
                Arrays.stream(Objects.requireNonNull(subfolder.listFiles())).forEach(file -> {
                    if (isAudio(file)) {
                        add.set(true);
                        podcast.setFileName(file.getName());
                    }
                    try {
                        if (file.getName().equals("tracklist.txt") && Files.size(Path.of(file.getAbsolutePath())) > 100) {
                            podcast.setShowTrackList(true);
                            parseFile(file, podcast);
                        }
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });
                if (add.get()) {
                    result.add(podcast);
                }
            }
        });
        return result;
    }

    private static void parseFile(File file, PodcastModel podcast) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        StringBuilder stringBuilder = new StringBuilder(" ");
        while (scanner.hasNextLine()) {
            stringBuilder.append(scanner.nextLine()).append(" ");
        }
        Arrays.asList(stringBuilder.toString().split("((?=[^0-9|$][0-2][0-9] ))")).forEach(track -> podcast.getTrackList().add(new Song(track.trim())));
    }

    private static boolean isAudio(File file) {
        return file.isFile() &&
                (file.getName().endsWith(".mp3") ||
                        file.getName().endsWith(".m4a") ||
                        file.getName().endsWith(".wma"));
    }

}
