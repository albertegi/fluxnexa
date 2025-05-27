package com.alvirg.fluxnexa.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
public class Mission {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    private int duration;

    @ManyToMany(mappedBy = "missions")
    private List<Employee> employees;


}
