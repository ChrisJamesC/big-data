package com.chris.training;

import java.io.IOException;
import java.util.Timer;

/**
 * Hello world!
 *
 */
public class App 
{
    /**
     *  Ingest temperatures every 5 seconds
     */
    public static void ingest() throws IOException {
        Timer timer = new Timer();
        int period = 5000; // 5 seconds
        timer.schedule(new IngestTemperatures(), 0, period);
    }
    public static void main( String[] args ) throws IOException {
        ingest();
    }
}
