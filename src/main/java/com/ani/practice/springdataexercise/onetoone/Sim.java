package com.ani.practice.springdataexercise.onetoone;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Sim {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String serial;
    private String country;

    @OneToOne
    @JoinColumn(name = "mobile_id")
    private Mobile mobile;
}
