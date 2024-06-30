package com.example.demo;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;

import com.example.demo.model.Drone;
import com.example.demo.model.DroneState;
import com.example.demo.service.DroneService;

@SpringBootTest
public class DroneServiceTests {

    @Autowired
    private DroneService droneService;


    @Test
    public void testGetAvailableDrones() {
        Drone drone = new Drone();
        drone.setState(DroneState.IDLE);
        droneService.registerDrone(drone);

        List<Drone> availableDrones = droneService.getAvailableDrones();
        assertFalse(availableDrones.isEmpty());
        assertTrue(availableDrones.contains(drone));
    }

    @Test
    public void testGetBatteryLevel() {
        Drone drone = new Drone();
        drone.setBatteryCapacity(100);
        Drone savedDrone = droneService.registerDrone(drone);

        int batteryLevel = droneService.getBatteryLevel(savedDrone.getId());
        assertEquals(100, batteryLevel);
    }
}