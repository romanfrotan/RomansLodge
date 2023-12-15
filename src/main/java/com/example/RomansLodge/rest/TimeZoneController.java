package com.example.RomansLodge.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

@RestController
@RequestMapping("/time")
@CrossOrigin
public class TimeZoneController {
    final private String[] timeZones = new String[]{"EST","MST","UTC"};
    final private String timeFormat = "hh:mma z";
    final private String startTime = "03:45PM EST";


    private SimpleDateFormat formater = new SimpleDateFormat(timeFormat);
    @GetMapping("/presentation")
    public ResponseEntity<List<String>> getLivePresentationTimes() {
        List<String> presentationTimes = new ArrayList<String>();
        try {
            Date date = formater.parse(startTime);

            for (String zone : timeZones) {

                TimeZone timeZone = TimeZone.getTimeZone(zone);
                formater.setTimeZone(timeZone);

                String newDate = formater.format(date);
                presentationTimes.add(newDate);
            }

            TimeZone EST = TimeZone.getTimeZone("EST");
            formater.setTimeZone(EST);

            TimeZone UTC = TimeZone.getTimeZone("UTC");

            TimeZone MST = TimeZone.getTimeZone("MST");

        } catch (Exception e) {
            System.out.println(e.toString());
            presentationTimes.add(e.toString());
        }
        return ResponseEntity.ok(presentationTimes);
    }


}
