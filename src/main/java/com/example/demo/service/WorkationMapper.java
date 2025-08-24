package com.example.demo.service;

import com.example.demo.dto.WorkationDto;
import com.example.demo.model.Workation;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface WorkationMapper {
    Workation toEntity(WorkationDto dto);
    WorkationDto toDto(Workation entity);
}
