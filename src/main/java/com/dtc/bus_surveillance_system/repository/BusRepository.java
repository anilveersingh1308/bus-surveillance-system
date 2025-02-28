package com.dtc.bus_surveillance_system.repository;


import com.dtc.bus_surveillance_system.model.Bus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusRepository extends JpaRepository<Bus, Long> {
}
