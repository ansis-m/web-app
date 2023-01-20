package com.am.backend.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

@RestController
@CrossOrigin
public class TestController {

    @Value("${hostname}")
    private String hostname;

    @Value("${files}")
    private String files;

    @GetMapping("/filenames")
    public ArrayList<String> listOfFilenames(){
        return filenames();
    }

    private boolean isAudio(File file) {
        return file.isFile() &&
                (file.getName().endsWith(".mp3") ||
                        file.getName().endsWith(".m4a") ||
                        file.getName().endsWith(".wma"));
    }

    private ArrayList<String> filenames() {
        ArrayList<String> result = new ArrayList<>();
        File folder = new File(files);
        Arrays.stream(folder.listFiles()).forEach(subfolder -> {
            if(subfolder.isDirectory()) {
                Arrays.stream(subfolder.listFiles()).forEach(file -> {
                    if (isAudio(file))
                        result.add(file.getName());});
            }
        });
        return result;
    }
}
