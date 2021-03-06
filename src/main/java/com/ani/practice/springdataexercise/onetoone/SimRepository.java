package com.ani.practice.springdataexercise.onetoone;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface SimRepository extends JpaRepository<Sim, Long> {

    @Query("select s from Sim s where s.mobile.battery.id = ?1")
    Optional<Sim> findSimFromBattery(Long batteryId);
}
