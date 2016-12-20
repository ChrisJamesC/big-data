package com.chris.training;

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
            System.out.println(OwmJapis.getTemperatureForCity("New York"));
            System.out.println(OwmJapis.getTemperatureForCity("Zurich"));
        } catch(IOException e) {
            System.err.println(e);
        }
    }
}
