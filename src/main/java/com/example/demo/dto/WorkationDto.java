package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WorkationDto implements Serializable {

    private String workationId;

    private String employee;

    private String origin;

    private String destination;

    private String start;

    private String end;

    private Integer workingDays;

    private String risk;

}
