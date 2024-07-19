package org.example.developer.controller;

import org.example.developer.dto.SensorData;
import org.example.developer.entity.Accelerometer;
import org.example.developer.entity.Gyroscope;
import org.example.developer.entity.Magnetometer;
import org.example.developer.entity.GPS;
import org.example.developer.repository.AccelerometerRepository;
import org.example.developer.repository.GyroscopeRepository;
import org.example.developer.repository.MagnetometerRepository;
import org.example.developer.repository.GPSRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/sensor")
public class SensorDataController {

    @Autowired
    private AccelerometerRepository accelerometerRepository;

    @Autowired
    private GyroscopeRepository gyroscopeRepository;

    @Autowired
    private MagnetometerRepository magnetometerRepository;

    @Autowired
    private GPSRepository gpsRepository;

    @PostMapping("/data")
    public Object receiveSensorData(@RequestBody SensorData sensorData) {
        String type = sensorData.getType();

        switch (type) {
            case "accelerometer":
                Accelerometer accelerometer = new Accelerometer();
                accelerometer.setX(sensorData.getX());
                accelerometer.setY(sensorData.getY());
                accelerometer.setZ(sensorData.getZ());
                accelerometer.setTimestamp(sensorData.getTimestamp());
                return accelerometerRepository.save(accelerometer);

            case "gyroscope":
                Gyroscope gyroscope = new Gyroscope();
                gyroscope.setX(sensorData.getX());
                gyroscope.setY(sensorData.getY());
                gyroscope.setZ(sensorData.getZ());
                gyroscope.setTimestamp(sensorData.getTimestamp());
                return gyroscopeRepository.save(gyroscope);

            case "magnetometer":
                Magnetometer magnetometer = new Magnetometer();
                magnetometer.setX(sensorData.getX());
                magnetometer.setY(sensorData.getY());
                magnetometer.setZ(sensorData.getZ());
                magnetometer.setTimestamp(sensorData.getTimestamp());
                return magnetometerRepository.save(magnetometer);

            case "gps":
                GPS gps = new GPS();
                gps.setLatitude(sensorData.getLatitude());
                gps.setLongitude(sensorData.getLongitude());
                gps.setTimestamp(sensorData.getTimestamp());
                return gpsRepository.save(gps);

            default:
                throw new IllegalArgumentException("Unknown sensor type: " + type);
        }
    }
}
