package com.example.demo.service;

import com.example.demo.dto.WorkationDto;
import com.example.demo.model.Workation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@RequiredArgsConstructor
@Service
public class Mapper {

    public WorkationDto toWorkationDto(Workation workation) {
        if (Objects.isNull(workation)) {
            return null;
        }
        return WorkationDto.builder()
                .workationId(workation.getWorkationId())
                .employee(workation.getEmployee())
                .origin(workation.getOrigin())
                .destination(workation.getDestination())
                .start(workation.getStart())
                .end(workation.getEnd())
                .workingDays(workation.getWorkingDays())
                .risk(workation.getRisk())
                .build();
    }

    public Workation toWorkation(WorkationDto workation) {
        if (Objects.isNull(workation)) {
            return null;
        }
        return Workation.builder()
                .workationId(workation.getWorkationId())
                .employee(workation.getEmployee())
                .origin(workation.getOrigin())
                .destination(workation.getDestination())
                .start(workation.getStart())
                .end(workation.getEnd())
                .workingDays(workation.getWorkingDays())
                .risk(workation.getRisk())
                .build();
    }
}
