package org.example.developer.controller;

import java.time.LocalDateTime;

public class Request {
    private String type;
    private double latitude;
    private double longtitude;
    private LocalDateTime timestamp;

    // Getters and Setters
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongtitude() {
        return longtitude;
    }

    public void setLongtitude(double longtitude) {
        this.longtitude = longtitude;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Request{" +
                "type='" + type + '\'' +
                ", latitude=" + latitude +
                ", longtitude=" + longtitude +
                ", timestamp=" + timestamp +
                '}';
    }
}
