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
@Table(name = "battery_info")
public class Battery {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name =  "battery_id")
    private Long id;

    private String make;
    private LocalDate date;
}
