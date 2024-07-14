package org.example.developer.repository;

import org.example.developer.entity.Magnetometer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MagnetometerRepository extends JpaRepository<Magnetometer, Long> {}
