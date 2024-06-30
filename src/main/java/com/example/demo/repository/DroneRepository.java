package com.example.demo.repository;
import com.example.demo.model.Drone;
import com.example.demo.model.DroneState;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface DroneRepository extends JpaRepository<Drone, Long> {
    List<Drone> findByState(DroneState state);
}