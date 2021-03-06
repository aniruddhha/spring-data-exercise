package com.ani.practice.springdataexercise.onetoone;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class OneToOneTest {

    @Autowired
    private BatteryRepository batteryRepository;

    @Autowired
    private MobileRepository mobileRepository;

    @Autowired
    private SimRepository simRepository;

    @BeforeAll
    @Rollback(value = false)
    public void saveData() {
        Battery battery = new Battery();
        battery.setDate(LocalDate.of(1989, 6, 15));
        battery.setMake("India");
        batteryRepository.save(battery);

        Mobile mobile = new Mobile();
        mobile.setBattery(battery);
        mobile.setImei("oiaf479874r");
        mobile.setMfgDt(LocalDate.of(2020, 12, 6));
        mobileRepository.save(mobile);

        Sim sim = new Sim();
        sim.setCountry("Japan");
        sim.setMobile(mobile);
        sim.setSerial("q73r3867as7dft");
        simRepository.save(sim);
    }

    @Test
    public void findMobileFromBattery() {
        Mobile mb = mobileRepository.findMobile(1L);
        assertNotNull(mb);
        assertEquals("oiaf479874r", mb.getImei() );
    }

    @Test
    public void findMobileFromMobile() {
        Mobile mb = batteryRepository.findMobile(1L);
        assertNotNull(mb);
        assertEquals("oiaf479874r", mb.getImei() );
    }

    @Test
    public void findSimFromBattery() {
        Optional<Sim> simOp = simRepository.findSimFromBattery(1L);
        assertNotNull(simOp.get());
        assertEquals(
                LocalDate.of(1989, 6, 15),
                simOp.get().getMobile().getBattery().getDate()
        );
    }
}
