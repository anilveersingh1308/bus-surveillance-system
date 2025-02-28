package com.dtc.bus_surveillance_system.service;


import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dtc.bus_surveillance_system.model.Bus;
import com.dtc.bus_surveillance_system.repository.BusRepository;

@Service
public class BusService {
    @Autowired
    private BusRepository busRepository;

    public void updateBusLocation(Long busId, Double latitude, Double longitude, Double speed) {
        Bus bus = busRepository.findById(busId).orElseThrow(() -> new RuntimeException("Bus not found"));
        bus.setCurrentLatitude(latitude);
        bus.setCurrentLongitude(longitude);
        bus.setSpeed(speed);
        bus.setLastUpdated(LocalDateTime.now());
        busRepository.save(bus);
    }

    public Bus getBusById(Long id) {
        return busRepository.findById(id).orElseThrow(() -> new RuntimeException("Bus not found"));
    }

    public List<Bus> getAllBuses() {
        return busRepository.findAll();
    }
}
