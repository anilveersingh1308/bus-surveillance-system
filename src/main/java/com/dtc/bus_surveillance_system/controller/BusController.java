package com.dtc.bus_surveillance_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dtc.bus_surveillance_system.model.Bus;
import com.dtc.bus_surveillance_system.service.BusService;

@RestController
@RequestMapping("/api/bus")
public class BusController {
    @Autowired
    private BusService busService;

    @PostMapping("/update-location")
    public String updateLocation(@RequestParam Long busId, @RequestParam Double latitude, @RequestParam Double longitude, @RequestParam Double speed) {
        busService.updateBusLocation(busId, latitude, longitude, speed);
        return "Location updated successfully";
    }

    @GetMapping("/{id}")
    public Bus getBusDetails(@PathVariable Long id) {
        return busService.getBusById(id);
    }
}
