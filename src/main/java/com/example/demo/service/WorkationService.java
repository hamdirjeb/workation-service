package com.example.demo.service;

import com.example.demo.dto.WorkationDto;
import com.example.demo.handler.dto.ErrorCodes;
import com.example.demo.handler.exception.BusinessException;
import com.example.demo.repository.WorkationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Slf4j
@Service
public class WorkationService {

    private final WorkationRepository workationRepository;
    private final Mapper mapper;

    public WorkationDto save(WorkationDto workationDto) {
        if (workationDto == null) {
            throw BusinessException.builder()
                    .errorCode(ErrorCodes.NULL_OBJECT_TO_SAVE)
                    .httpCode(HttpStatus.BAD_REQUEST.value())
                    .customMessage("Workation is NULL")
                    .build();
        }
        return mapper.toWorkationDto(workationRepository.saveAndFlush(mapper.toWorkation(workationDto)));
    }

    public List<WorkationDto> getAll() {
        return workationRepository.findAll()
                .stream()
                .map(mapper::toWorkationDto)
                .collect(Collectors.toList());
    }
}
