import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import com.example.demo.model.Drone;
import com.example.demo.service.DroneService;

@RestController
@RequestMapping("/api/drones")
public class DroneController {
    @Autowired
    private DroneService droneService;

    @PostMapping
    public ResponseEntity<Drone> registerDrone(@RequestBody Drone drone) {
        return ResponseEntity.ok(droneService.registerDrone(drone));
    }

    @GetMapping("/available")
    public ResponseEntity<List<Drone>> getAvailableDrones() {
        return ResponseEntity.ok(droneService.getAvailableDrones());
    }

    @GetMapping("/{droneId}/battery")
    public ResponseEntity<Integer> getBatteryLevel(@PathVariable Long droneId) {
        return ResponseEntity.ok(droneService.getBatteryLevel(droneId));
    }
}