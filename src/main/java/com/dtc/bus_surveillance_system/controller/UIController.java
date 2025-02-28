package com.dtc.bus_surveillance_system.controller;

import com.dtc.bus_surveillance_system.model.Bus;
import com.dtc.bus_surveillance_system.service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class UIController {
    @Autowired
    private BusService busService;

    @GetMapping("/")
    public String viewBuses(Model model) {
        List<Bus> buses = busService.getAllBuses();
        model.addAttribute("buses", buses);
        return "index";
    }
}
