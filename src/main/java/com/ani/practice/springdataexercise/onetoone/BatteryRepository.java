package com.ani.practice.springdataexercise.onetoone;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BatteryRepository extends JpaRepository<Battery, Long> {

    @Query("select m from Mobile m where m.battery.id = ?1")
    Mobile findMobile(Long batteryId);
}
