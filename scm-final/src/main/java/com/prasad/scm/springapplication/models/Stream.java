package com.prasad.scm.springapplication.models;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "data")
public class Stream {
    private int Device_ID;// Device ID associated with the stream
    private double Battery_Level; // Battery level of the device
    private double First_Sensor_temperature; // Temperature measured by the first sensor
    private String Route_From; // Starting route location
    private String Route_To; // Destination route location

    /**
     * Get the device ID associated with the stream.
     *
     * @return The device ID.
     */
    public int getDevice_Id() {
        return Device_ID;
    }

    /**
     * Set the device ID associated with the stream.
     *
     * @param device_Id The device ID.
     */
    public void setDevice_Id(int device_Id) {
        Device_ID = device_Id;
    }

    /**
     * Get the battery level of the device.
     *
     * @return The battery level.
     */
    public double getBattery_Level() {
        return Battery_Level;
    }

    /**
     * Set the battery level of the device.
     *
     * @param battery_Level The battery level.
     */
    public void setBattery_Level(double battery_Level) {
        Battery_Level = battery_Level;
    }

    /**
     * Get the temperature measured by the first sensor.
     *
     * @return The temperature.
     */
    public double getFirst_Sensor_temperature() {
        return First_Sensor_temperature;
    }

    /**
     * Set the temperature measured by the first sensor.
     *
     * @param first_Sensor_temperature The temperature.
     */
    public void setFirst_Sensor_temperature(double first_Sensor_temperature) {
        First_Sensor_temperature = first_Sensor_temperature;
    }

    /**
     * Get the starting route location.
     *
     * @return The starting route location.
     */
    public String getRoute_From() {
        return Route_From;
    }

    /**
     * Set the starting route location.
     *
     * @param route_From The starting route location.
     */
    public void setRoute_From(String route_From) {
        Route_From = route_From;
    }

    /**
     * Get the destination route location.
     *
     * @return The destination route location.
     */
    public String getRoute_To() {
        return Route_To;
    }

    /**
     * Set the destination route location.
     *
     * @param route_To The destination route location.
     */
    public void setRoute_To(String route_To) {
        Route_To = route_To;
    }
}
