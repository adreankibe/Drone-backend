package com.example.demo.task;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import java.util.List;
import com.example.demo.model.Drone;
import com.example.demo.repository.DroneRepository;


@Component
public class BatteryCheckTask {
    @Autowired
    private DroneRepository droneRepository;

    @Scheduled(fixedRate = 60000)
    public void checkDronesBattery() {
        List<Drone> drones = droneRepository.findAll();
        for (Drone drone : drones) {
            System.out.println("Drone ID: " + drone.getId() + ", Battery Level: " + drone.getBatteryCapacity() + "%");
        }
    }
}