package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@SuperBuilder
@Entity
@Table(name = "workation")
public class Workation {

    @Id
    @Column(name = "workation_id")
    private String workationId;

    @Column(name = "employee")
    private String employee;

    @Column(name = "origin")
    private String origin;

    @Column(name = "destination")
    private String destination;
    @Column(name = "start_date")
    private String start;

    @Column(name = "end_date")
    private String end;

    @Column(name = "working_days")
    private Integer workingDays;

    @Column(name = "risk")
    private String risk;

}
