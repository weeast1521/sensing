package org.example.developer.repository;

import org.example.developer.entity.Accelerometer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccelerometerRepository extends JpaRepository<Accelerometer, Long> {}
