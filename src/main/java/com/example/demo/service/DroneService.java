package com.example.demo.service;
import com.example.demo.model.Drone;
import com.example.demo.model.DroneState;
import com.example.demo.repository.DroneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DroneService {
    @Autowired
    private DroneRepository droneRepository;

    public Drone registerDrone(Drone drone) {
        return droneRepository.save(drone);
    }

    public List<Drone> getAvailableDrones() {
        return droneRepository.findByState(DroneState.IDLE);
    }

    public int getBatteryLevel(Long droneId) {
        return droneRepository.findById(droneId).orElseThrow().getBatteryCapacity();
    }
}