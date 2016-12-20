package com.chris.training;

import java.util.Date;

/**
 * Created by christopherchiche on 20.12.16.
 * Object meant to be serialized and sent over Kafka as an aggregate of a city report
 *
 */
public class CityReport {
    String cityName;
    Float temperature;
    Date eventTime;

    /**
     *
     * @param cityName the name of the city
     * @param temperature the temperature in the city
     * @param eventTime the time of the event as reported by open weather map
     */
    public CityReport(String cityName, Float temperature, Date eventTime) {
        this.cityName = cityName;
        this.temperature = temperature;
        this.eventTime = eventTime;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Float getTemperature() {
        return temperature;
    }

    public void setTemperature(Float temperature) {
        this.temperature = temperature;
    }

    public Date getEventTime() {
        return eventTime;
    }

    public void setEventTime(Date eventTime) {
        this.eventTime = eventTime;
    }
}
