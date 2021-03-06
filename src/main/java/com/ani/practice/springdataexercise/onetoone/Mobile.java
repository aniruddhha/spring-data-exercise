package com.ani.practice.springdataexercise.onetoone;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "mobile_data")
public class Mobile {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "mobile_id")
    private Long id;

    private String imei;
    private LocalDate mfgDt;

    @OneToOne
    @JoinColumn(name = "battery_id")
    private Battery battery;
}
