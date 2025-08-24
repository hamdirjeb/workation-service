package com.example.demo.service;

import com.example.demo.dto.WorkationDto;
import com.example.demo.repository.WorkationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class WorkationService {

    private final WorkationRepository workationRepository;
    private final WorkationMapper mapper;

    public WorkationService(WorkationRepository workationRepository, WorkationMapper mapper) {
        this.mapper = mapper;
        this.workationRepository = workationRepository;
    }

    public WorkationDto save(WorkationDto workationDto) {
        return mapper.toDto(workationRepository.saveAndFlush(mapper.toEntity(workationDto)));
    }

    public List<WorkationDto> getAll() {
        return workationRepository.findAll()
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }
}
