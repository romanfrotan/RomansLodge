package com.example.RomansLodge.rest;

import com.example.RomansLodge.locale.ReadWelcomeMessage;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@RestController
@RequestMapping("/resources")
@CrossOrigin
public class ResourceController {

    // Create 2 executors
    private Executor executor = Executors.newFixedThreadPool(2);

    @GetMapping("welcome")
    public ResponseEntity<List<String>>getWelcomeMessage() {
        List<String> messages = new ArrayList<String>();


        executor.execute(() -> {
            ReadWelcomeMessage EN = new ReadWelcomeMessage("en", "US");
            messages.add(EN.getWelcomeMessage());
        });

        executor.execute(() -> {
            ReadWelcomeMessage FR = new ReadWelcomeMessage("fr", "CA");
            messages.add(FR.getWelcomeMessage());

        });

        return ResponseEntity.ok(messages);

    }
}