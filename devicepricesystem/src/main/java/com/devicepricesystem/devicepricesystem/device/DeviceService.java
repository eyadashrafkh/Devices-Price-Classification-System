package com.devicepricesystem.devicepricesystem.device;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class DeviceService {

    private final DeviceRepository deviceRepository;

    public DeviceService(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }

    public List<Device> getDevices() {
		return deviceRepository.findAll();
	}

    public Device getDeviceById(Long id) {
        Optional<Device> deviceOptional = deviceRepository.findDeviceById(id);
        if (deviceOptional.isEmpty()) {
            throw new IllegalStateException("Device with id " + id + " does not exist");
        }
        return deviceOptional.get();
    }

    @Transactional
    public void addDevice(Device device) {
        Optional<Device> deviceOptional = deviceRepository.findDeviceById(device.getId());
        if (deviceOptional.isPresent()) {
            throw new IllegalStateException("Device already exists");
        }
        deviceRepository.save(device); 
    }

    @Transactional
    public void addDevices(List<Device> devices) {
        for (Device device : devices) {
            addDevice(device);
        }
    }

    @Transactional
    public String predictAndSavePrice(Long deviceId) {
        Device device = getDeviceById(deviceId);
        // Load device features
        int battery_power = device.getBatteryPower();
        int blue = device.isBlue();
        double clock_speed = device.getClockSpeed();
        int dual_sim = device.isDualSim();
        int fc = device.getFc();
        int four_g = device.isFourG();
        int int_memory = device.getIntMemory();
        double m_dep = device.getmDep();
        double mobile_wt = device.getMobileWt();
        int n_cores = device.getnCores();
        int pc = device.getPc();
        int px_height = device.getPxHeight();
        int px_width = device.getPxWidth();
        int ram = device.getRam();
        int touch_screen = device.isTouchScreen();
        int wifi = device.isWifi();
        int three_g = device.isThreeG();
        int talk_time = device.getTalkTime();
        // Fit device features into machine learning model
        // Machine learning model to predict price range
        int price_range = 2; // Mimic prediction

        String price;
        if(price_range == 0) {
           price = "Low Cost"; // Predicted price range
        } else if(price_range == 1){
            price = "Medium Cost"; // Predicted price range
        } else if(price_range == 2){
            price = "Medium Cost";
        } else{
            price = "Medium Cost";
        }
        // Save predicted price range
        device.setPriceRange(price_range);
        deviceRepository.save(device);
        
        return price;
    }
}
