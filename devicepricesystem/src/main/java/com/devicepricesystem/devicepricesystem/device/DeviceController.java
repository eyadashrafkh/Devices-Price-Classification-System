package com.devicepricesystem.devicepricesystem.device;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/devices")
public class DeviceController {

    private final DeviceService deviceService;
    
    // Constructors
    public DeviceController(DeviceService deviceService) {
        this.deviceService = deviceService;
    }
    
    @GetMapping
	public List<Device> getDevices() {
		return deviceService.getDevices();
	}

    @GetMapping("/{id}")
    public Device getDeviceById(@PathVariable Long id) {
        return deviceService.getDeviceById(id);
    }

    @PostMapping()
    public void addDevice(@RequestBody Device device) {
        deviceService.addDevice(device);
    }

    @PostMapping("/predict/{deviceId}")
    public String predictAndSavePrice(@PathVariable Long deviceId) {
        String price = deviceService.predictAndSavePrice(deviceId);
        return price;
    }

}