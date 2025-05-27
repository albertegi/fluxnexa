package com.alvirg.fluxnexa.models;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Address {

    @Id
    @GeneratedValue
    private Integer id;

    private String streetName;

    private String houseNumber;

    private String zipCode;

    @OneToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

}
