package com.alvirg.fluxnexa.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Department {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    @OneToMany(mappedBy = "department")
    private List<Employee> employees;
}
