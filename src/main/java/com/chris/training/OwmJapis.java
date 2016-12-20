package com.chris.training;

import java.io.IOException;
import java.net.MalformedURLException;
import net.aksingh.owmjapis.CurrentWeather;
import net.aksingh.owmjapis.OpenWeatherMap;
import org.json.JSONException;

/**
 * Created by christopherchiche on 20.12.16.
 */
public class OwmJapis {
    private static String apiKey = "ece9cca20d3e975185a1883005177a0b";
    public static CityReport getTemperatureForCity(String cityName) throws IOException, JSONException {
        OpenWeatherMap owm = new OpenWeatherMap(apiKey);

        // getting current weather data for the "London" city
        CurrentWeather cwd = owm.currentWeatherByCityName(cityName);

        // checking data retrieval was successful or not
        if (cwd.isValid() && cwd.getMainInstance().hasTemperature() && cwd.hasDateTime()) {
            return new CityReport(cityName, cwd.getMainInstance().getTemperature(), cwd.getDateTime());
        } else {
            throw new IOException("No temperature for the city");
        }

    }

    public static void singleImport()
            throws IOException, MalformedURLException, JSONException {

        // declaring object of "OpenWeatherMap" class
        OpenWeatherMap owm = new OpenWeatherMap(apiKey);

        // getting current weather data for the "London" city
        CurrentWeather cwd = owm.currentWeatherByCityName("London");

        // checking data retrieval was successful or not
        if (cwd.isValid()) {

            // checking if city name is available
            if (cwd.hasCityName()) {
                //printing city name from the retrieved data
                System.out.println("City: " + cwd.getCityName());
            }

            // checking if max. temp. and min. temp. is available
            if (cwd.getMainInstance().hasMaxTemperature() && cwd.getMainInstance().hasMinTemperature()) {
                // printing the max./min. temperature
                System.out.println("Temperature: " + cwd.getMainInstance().getMaxTemperature()
                        + "/" + cwd.getMainInstance().getMinTemperature() + "\'F");
            }
        }
    }
}
