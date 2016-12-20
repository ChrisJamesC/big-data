package com.chris.training;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.TimerTask;

/**
 * Created by christopherchiche on 20.12.16.
 *
 * Ingest temperatures for Zurich and New York
 */
public class IngestTemperatures extends TimerTask {
    public void run() {
        try {
            ObjectMapper mapper = new ObjectMapper();

            CityReport ny = OwmJapis.getTemperatureForCity("New York");
            CityReport zh = OwmJapis.getTemperatureForCity("Zurich");

            String ny_message = mapper.writeValueAsString(ny);
            String zh_message = mapper.writeValueAsString(zh);

            System.out.println(ny_message);
            System.out.println(zh_message);
        } catch(IOException e) {
            System.err.println(e);
        }
    }
}
